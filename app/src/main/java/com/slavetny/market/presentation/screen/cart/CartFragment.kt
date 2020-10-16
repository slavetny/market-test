package com.slavetny.market.presentation.screen.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen
import com.ethanhua.skeleton.Skeleton
import com.slavetny.market.R
import com.slavetny.market.databinding.FragmentCartBinding
import com.slavetny.market.domain.extensions.observeEvent
import com.slavetny.market.domain.extensions.observeNotNull
import com.slavetny.market.presentation.adapter.ProductsAdapter
import com.slavetny.market.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.product_item.view.*
import org.koin.android.viewmodel.ext.android.viewModel

class CartFragment : BaseFragment<CartViewModel, FragmentCartBinding>() {

    override val viewModel: CartViewModel by viewModel()

    private val adapter = ProductsAdapter()

    private lateinit var skeletonView: RecyclerViewSkeletonScreen.Builder

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadData()
        subscribeObservers()
        setupRecyclerView()
        initItemTouchHelper()
    }

    private fun loadData() {
        viewModel.getProducts()
        viewModel.getProductsCount()
    }

    private fun subscribeObservers() {
        viewModel.productsLiveData.observeNotNull(viewLifecycleOwner) {
            adapter.attachData(it)
        }

        viewModel.productsCountLiveData.observeNotNull(viewLifecycleOwner) {
            binding?.productCount?.text = it.toString()
        }

        viewModel.shimmerLiveData.observeEvent(viewLifecycleOwner) { show ->
            if (show) skeletonView.show() else skeletonView.show().hide()
        }
    }

    private fun initItemTouchHelper() {
        val itemTouchHelperCallback =
            object : ItemTouchHelper
            .SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ) = false

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    viewModel.deleteProduct(viewHolder.itemView.productTitle.text.toString())

                    loadData()
                }
            }

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(binding?.recyclerView)
    }

    private fun setupRecyclerView() {
        binding?.recyclerView?.adapter = adapter
        binding?.recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        binding?.recyclerView?.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )

        skeletonView = Skeleton.bind(binding?.recyclerView)
            .adapter(adapter)
            .load(R.layout.product_item)
            .shimmer(true)
    }

    override fun setBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentCartBinding =
        FragmentCartBinding.inflate(inflater, container, false)
}
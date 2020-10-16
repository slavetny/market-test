package com.slavetny.market.presentation.screen.productlist

import android.os.Bundle
import android.view.*
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen
import com.ethanhua.skeleton.Skeleton
import com.slavetny.market.R
import com.slavetny.market.databinding.FragmentProductlistBinding
import com.slavetny.market.domain.extensions.observeEvent
import com.slavetny.market.domain.extensions.observeNotNull
import com.slavetny.market.presentation.adapter.ProductsAdapter
import com.slavetny.market.presentation.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class ProductListFragment : BaseFragment<ProductListViewModel, FragmentProductlistBinding>() {

    override val viewModel: ProductListViewModel by viewModel()

    private val adapter = ProductsAdapter()

    private lateinit var skeletonView: RecyclerViewSkeletonScreen.Builder

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)

        subscribeObservers()
        setupRecyclerView()
    }

    private fun subscribeObservers() {
        viewModel.productsLiveData.observeNotNull(viewLifecycleOwner) {
            adapter.attachData(it.products)
        }

        viewModel.shimmerLiveData.observeEvent(viewLifecycleOwner) { show ->
            if (show) skeletonView.show() else skeletonView.show().hide()
        }
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.toolbar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.cart -> findNavController().navigate(R.id.action_productList_to_cartFragment)
        }
        return false
    }

    override fun setBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentProductlistBinding =
        FragmentProductlistBinding.inflate(inflater, container, false)
}
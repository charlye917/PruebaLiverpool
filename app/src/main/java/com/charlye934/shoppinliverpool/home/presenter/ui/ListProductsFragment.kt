package com.charlye934.shoppinliverpool.home.presenter.ui

import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.view.MenuProvider
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.charlye934.shoppinliverpool.R
import com.charlye934.shoppinliverpool.databinding.FragmentListProductsBinding
import com.charlye934.shoppinliverpool.home.domain.model.ProductCardUI
import com.charlye934.shoppinliverpool.home.presenter.adapter.ProductsListAdapter
import com.charlye934.shoppinliverpool.home.presenter.viewmodel.HomeViewModel
import com.charlye934.shoppinliverpool.util.ConstantsServices.VISIBLE_THRESHOLD
import com.charlye934.shoppinliverpool.util.TypeSortPrice
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListProductsFragment : Fragment() {

    private lateinit var _binding: FragmentListProductsBinding
    private val binding: FragmentListProductsBinding get() = _binding

    private val viewModel: HomeViewModel by activityViewModels()
    private lateinit var productsListAdapter: ProductsListAdapter

    private var searchWord = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListProductsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpToolbar()
        setUpRecyclerView()
        configSearchEvent()
        setOnRefreshListener()
        viewModel.numPage.value?.let { viewModel.getDataProducts(page = it) }

        viewModel.listDataProducts.observe(viewLifecycleOwner){
            _binding.refresh.isRefreshing = false
            configuratinoListAdapter(it)
        }
    }

    private fun setUpToolbar(){
        _binding.toolbarView.toolbar.apply {
            title = getString(R.string.title_liverpool)
            /*addMenuProvider(object : MenuProvider {
                override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                    menuInflater.inflate(R.menu.menu_sort, menu)
                }

                override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                    //_binding.rvProducts.scrollToPosition(0)
                    when(menuItem.itemId){
                        R.id.action_sort_less_price -> {
                            viewModel.updatePage(false)
                            viewModel.getDataProducts(page = viewModel.numPage.value, search = searchWord, sortType = TypeSortPrice.MIN_SORT, clearData = true)
                        }

                        R.id.action_more_price -> {
                            viewModel.updatePage(false)
                            viewModel.getDataProducts(page = viewModel.numPage.value, search = searchWord, sortType = TypeSortPrice.MAX_SORT, clearData = true)
                        }
                    }
                    return true
                }

            })*/
        }
    }

    private fun setUpRecyclerView(){
        _binding.rvProducts.apply {
            productsListAdapter = ProductsListAdapter()
            layoutManager = LinearLayoutManager(requireContext())
            adapter = productsListAdapter
            addOnScrollListener(object : RecyclerView.OnScrollListener(){
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val totalItemCount = (layoutManager as LinearLayoutManager).itemCount
                    val lastVisibleItem = (layoutManager as LinearLayoutManager).findLastVisibleItemPosition()

                    if (totalItemCount <= (lastVisibleItem + VISIBLE_THRESHOLD)) {
                        viewModel.updatePage(true)
                        viewModel.numPage.value?.let { viewModel.getDataProducts(page = it, search = searchWord) }
                    }
                }
            })
        }
    }

    private fun configuratinoListAdapter(listProducts: List<ProductCardUI>){
        productsListAdapter.apply {
            submitList(listProducts)
            notifyItemRangeChanged(0, listProducts.size)
        }
    }

    private fun configSearchEvent() {
        _binding.searchView.apply {
            val updateData = {
                viewModel.updatePage(false)
                viewModel.getDataProducts(page = viewModel.numPage.value, search = searchWord, clearData = true)
            }

            txtSearch.addTextChangedListener { eventFilter ->
                searchWord = eventFilter.toString()
            }

            txtSearch.setOnEditorActionListener { textView, actionId, keyEvent ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    updateData()
                    true
                } else {
                    false
                }
            }

            searchIconImageView.setOnClickListener {
                updateData()
            }

            icClear.setOnClickListener {
                searchWord = ""
                txtSearch.setText("")
                updateData()
            }
        }
    }

    private fun setOnRefreshListener(){
        _binding.refresh.apply {
            setOnRefreshListener {
                viewModel.updatePage(false)
                viewModel.getDataProducts(page = viewModel.numPage.value, search = searchWord, clearData = true)
            }
        }
    }
}
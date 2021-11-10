package evgen.kolesnik.auroratestapp.fragments.news_list_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import evgen.kolesnik.auroratestapp.R
import evgen.kolesnik.auroratestapp.databinding.FragmentNewsListBinding
import evgen.kolesnik.auroratestapp.di.NewsListComponent
import evgen.kolesnik.domain.DESCRIPTION
import evgen.kolesnik.domain.TITLE
import evgen.kolesnik.domain.URL
import evgen.kolesnik.domain.outcome.Outcome

class NewsListFragment : Fragment(R.layout.fragment_news_list) {

    private var _binding: FragmentNewsListBinding? = null
    private val binding get() = _binding!!

    private var _adapter: NewsListRecyclerAdapter? = null
    private val adapter get() = _adapter!!
    private var layoutManager: LinearLayoutManager? = null

    private val component by lazy { NewsListComponent.create() }
    private val viewModel by viewModels<NewsListViewModel> { component.viewModelFactory() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentNewsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler(view)

        viewModel.apiData.observe(viewLifecycleOwner, {
            when (it) {
                is Outcome.Progress -> {
                    if (it.loading) showProgress() else hideProgress()
                }
                is Outcome.Next -> {
                }
                is Outcome.Success -> {
                    adapter.addList(it.data)
                }
                is Outcome.Failure -> {
                    viewModel.getNewsFromDb()
                    showSnackbarShort(R.string.check_connection)
                }
            }
        })

        viewModel.dbData.observe(viewLifecycleOwner, {
            when (it) {
                is Outcome.Progress -> {
                    if (it.loading) showProgress() else hideProgress()
                }
                is Outcome.Next -> {
                    adapter.refresh(it.data)
                }
                is Outcome.Success -> {
                }
                is Outcome.Failure -> {
                }
            }
        })

        viewModel.getAllNews()

        adapter.setItemClick { item ->
            val bundle = Bundle()
            bundle.putString(TITLE, item.title)
            bundle.putString(DESCRIPTION, item.description)
            bundle.putString(URL, item.url)

            findNavController().navigate(R.id.action_newsListFragment_to_newsItemFragment, bundle)
        }
    }

    override fun onDestroyView() {
        _binding = null
        _adapter = null
        super.onDestroyView()
    }

    private fun initRecycler(view: View) {
        binding.newsListRecycler.adapter = _adapter
        layoutManager = LinearLayoutManager(activity)
        binding.newsListRecycler.layoutManager = layoutManager

        val decoration = DividerItemDecoration(context, VERTICAL)
        binding.newsListRecycler.addItemDecoration(decoration)

        _adapter = NewsListRecyclerAdapter()
        binding.newsListRecycler.adapter = _adapter
    }

    private fun showProgress() {
        binding.progressBar.isVisible = true
        binding.frameWithProgress.isVisible = true
    }

    private fun hideProgress() {
        binding.progressBar.isVisible = false
        binding.frameWithProgress.isVisible = false
    }

    private fun showSnackbarShort(snackId: Int) {
        Snackbar.make(requireView(), snackId, Snackbar.LENGTH_SHORT).show()
    }
}
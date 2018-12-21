package test.billeasy.com.billeasytest.features.contributors.repositories

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import test.billeasy.com.billeasytest.base.BaseFragment
import test.billeasy.com.billeasytest.data.model.GitRepository
import test.billeasy.com.billeasytest.databinding.FragmentContributorRepositoryListBinding
import test.billeasy.com.billeasytest.features.contributors.repositories.ContributorRepositoryListFragmentArgs.fromBundle

const val Contributor_REPOSITORY_LIST_FRAGMENT_TAG = "CRepositoryListFragment"
class ContributorRepositoryListFragment : BaseFragment<ContributorRepositoryListPresenter>() ,
        ContributorRepositoryListView {

    private lateinit var binding : FragmentContributorRepositoryListBinding
    private lateinit var contributorRepositoryListAdapter: ContributorRepositoryListAdapter

    val imageUrl by lazy {
        fromBundle(arguments!!).imageUrl
    }

    val name by lazy {
        fromBundle(arguments!!).name
    }

    override fun instantiatePresenter(): ContributorRepositoryListPresenter {
        return ContributorRepositoryListPresenter(this);
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentContributorRepositoryListBinding.inflate(layoutInflater, container , false)

        binding.imageUrl = imageUrl
        binding.name = name

        contributorRepositoryListAdapter = ContributorRepositoryListAdapter(binding.root.context)
        binding.gitRepositoryList.adapter = contributorRepositoryListAdapter
        binding.gitRepositoryList.layoutManager = LinearLayoutManager(binding.root.context)

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        presenter.loadRepositories(name)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun showLoading() {
        binding.progressVisibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressVisibility = View.GONE
    }

    override fun showRepositories(gitRepositoryList: List<GitRepository>) {
        contributorRepositoryListAdapter.updateRepositories(gitRepositoryList)
    }

    override fun showError(error: String) {
        Log.e(Contributor_REPOSITORY_LIST_FRAGMENT_TAG, "error")
    }

}
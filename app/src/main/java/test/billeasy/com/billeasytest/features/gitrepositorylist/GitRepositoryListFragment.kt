package test.billeasy.com.billeasytest.features.gitrepositorylist

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import test.billeasy.com.billeasytest.base.BaseFragment
import test.billeasy.com.billeasytest.data.model.GitRepository
import test.billeasy.com.billeasytest.databinding.FragmentGitRepositoryListBinding

class GitRepositoryListFragment : BaseFragment<GitRepositoryListPresenter>(), GitRepositoryListView {

    private lateinit var binding : FragmentGitRepositoryListBinding
    private lateinit var gitRepositoryListAdapter :GitRepositoryListAdapter

    override fun instantiatePresenter(): GitRepositoryListPresenter {
        return GitRepositoryListPresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentGitRepositoryListBinding.inflate(inflater, container, false)

        gitRepositoryListAdapter = GitRepositoryListAdapter(binding.root.context)
        binding.gitRepositoryList.adapter = gitRepositoryListAdapter
        binding.gitRepositoryList.layoutManager = LinearLayoutManager(binding.root.context)

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        presenter.onViewCreated()
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

    override fun showGitRepositories(gitRepositoryList: List<GitRepository>) {
        gitRepositoryListAdapter.updatePosts(gitRepositoryList)
    }

    override fun showError(error: String) {
        Log.e("Error", error)
    }

}
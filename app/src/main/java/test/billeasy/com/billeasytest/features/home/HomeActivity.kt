package test.billeasy.com.billeasytest.features.home

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import test.billeasy.com.billeasytest.R
import test.billeasy.com.billeasytest.base.BaseActivity
import test.billeasy.com.billeasytest.data.model.GitRepository
import test.billeasy.com.billeasytest.databinding.ActivityHomeBinding

class HomeActivity : BaseActivity<HomePresenter>() , HomeView {

    private lateinit var binding: ActivityHomeBinding
    private val gitRepositoryListAdapter = GitRepositoryListAdapter(this)

    override fun instantiatePresenter(): HomePresenter {
        return HomePresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.gitRepositoryList.adapter = gitRepositoryListAdapter
        binding.gitRepositoryList.layoutManager = LinearLayoutManager(this)

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
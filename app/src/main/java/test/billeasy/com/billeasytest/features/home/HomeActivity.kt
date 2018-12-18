package test.billeasy.com.billeasytest.features.home

import android.os.Bundle
import android.util.Log
import test.billeasy.com.billeasytest.base.BaseActivity
import test.billeasy.com.billeasytest.data.model.GitRepository

class HomeActivity : BaseActivity<HomePresenter>() , HomeView {

    override fun instantiatePresenter(): HomePresenter {
        return HomePresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun showLoading() {
        Log.d("Loading", "True")
    }

    override fun hideLoading() {
        Log.d("Loading", "False")
    }

    override fun showGitRepositories(gitRepositoryList: List<GitRepository>) {
        Log.d("Repo Size", gitRepositoryList.size.toString())
    }

    override fun showError(error: String) {
        Log.e("Error", error)
    }
}
package test.billeasy.com.billeasytest.features.gitrepositorylist

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import test.billeasy.com.billeasytest.base.BasePresenter
import test.billeasy.com.billeasytest.data.api.GitApi
import javax.inject.Inject

class GitRepositoryListPresenter(gitRepositoryListView: GitRepositoryListView) : BasePresenter<GitRepositoryListView>(gitRepositoryListView) {

    @Inject
    lateinit var gitApi: GitApi

    private var subscription: Disposable? = null

    override fun onViewCreated() {
        loadGitRepositories()
    }

    private fun loadGitRepositories() {
        view.showLoading()

        subscription = gitApi
            .getRepositories()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnTerminate { view.hideLoading() }
            .subscribe(
                { repositoryList -> view.showGitRepositories(repositoryList) },
                { view.showError("Error") }
            )
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }
}
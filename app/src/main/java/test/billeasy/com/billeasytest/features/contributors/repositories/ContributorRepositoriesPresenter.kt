package test.billeasy.com.billeasytest.features.contributors.repositories

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import test.billeasy.com.billeasytest.base.BasePresenter
import test.billeasy.com.billeasytest.data.api.GitApi
import javax.inject.Inject

class ContributorRepositoriesPresenter(contributorRepositoriesView: ContributorRepositoriesView)
    : BasePresenter<ContributorRepositoriesView>(contributorRepositoriesView) , ContributorRepositoriesPresenterContract {


    @Inject
    lateinit var gitApi: GitApi

    private var subscription: Disposable? = null

    override fun onViewCreated() {

    }

    override fun loadRepositories(userName: String) {

        view.showLoading()

        subscription = gitApi
            .getUserRepositories(userName)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnTerminate { view.hideLoading() }
            .subscribe(
                { gitRepositoryList -> view.showRepositories(gitRepositoryList) },
                { view.showError("Error") }
            )

    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }


}
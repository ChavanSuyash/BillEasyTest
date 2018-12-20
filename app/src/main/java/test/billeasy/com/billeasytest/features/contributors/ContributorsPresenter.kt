package test.billeasy.com.billeasytest.features.contributors

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import test.billeasy.com.billeasytest.base.BasePresenter
import test.billeasy.com.billeasytest.data.api.GitApi
import javax.inject.Inject

class ContributorsPresenter(contributorsView: ContributorsView) : BasePresenter<ContributorsView>(contributorsView) , ContributorsPresenterContract {

    @Inject
    lateinit var gitApi: GitApi

    private var subscription: Disposable? = null

    override fun onViewCreated() {

    }

    override fun loadContributors(userName: String, repoName: String) {
        view.showLoading()

        subscription = gitApi
            .getContributors(userName, repoName)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnTerminate { view.hideLoading() }
            .subscribe(
                { contributorList -> view.showContributors(contributorList) },
                { view.showError("Error") }
            )
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }

}
package test.billeasy.com.billeasytest.base

import test.billeasy.com.billeasytest.features.contributors.ContributorsPresenter
import test.billeasy.com.billeasytest.features.gitrepositorylist.GitRepositoryListPresenter
import test.billeasy.com.billeasytest.injection.component.DaggerPresenterInjector
import test.billeasy.com.billeasytest.injection.component.PresenterInjector
import test.billeasy.com.billeasytest.injection.module.ContextModule
import test.billeasy.com.billeasytest.injection.module.NetworkModule

/**
 * abstract BasePresenter class will create dagger dependency injector and inject to the classes inheriting BasePresenter
 */
abstract class BasePresenter<out V: BaseView>(protected val view: V) {

    private val injector: PresenterInjector = DaggerPresenterInjector
        .builder()
        .baseView(view)
        .contextModule(ContextModule)
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    open fun onViewCreated() {

    }

    open fun onViewDestroyed() {

    }

    private fun inject() {
        when(this){
            is GitRepositoryListPresenter -> injector.inject(this)
            is ContributorsPresenter -> injector.inject(this)
        }
    }
}
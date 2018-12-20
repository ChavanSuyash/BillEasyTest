package test.billeasy.com.billeasytest.injection.component

import dagger.BindsInstance
import dagger.Component
import test.billeasy.com.billeasytest.base.BaseView
import test.billeasy.com.billeasytest.features.contributors.ContributorsPresenter
import test.billeasy.com.billeasytest.features.repositories.RepositoryListPresenter
import test.billeasy.com.billeasytest.injection.module.ContextModule
import test.billeasy.com.billeasytest.injection.module.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class, NetworkModule::class])
interface PresenterInjector{

    fun inject(repositoryListPresenter: RepositoryListPresenter)
    fun inject(contributorsPresenter: ContributorsPresenter)

    @Component.Builder
    @Suppress("unused")
    interface Builder {
        fun build() : PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }


}
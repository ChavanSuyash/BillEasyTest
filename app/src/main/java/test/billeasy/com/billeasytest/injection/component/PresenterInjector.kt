package test.billeasy.com.billeasytest.injection.component

import dagger.BindsInstance
import dagger.Component
import test.billeasy.com.billeasytest.base.BaseView
import test.billeasy.com.billeasytest.injection.module.ContextModule
import test.billeasy.com.billeasytest.injection.module.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class, NetworkModule::class])
interface PresenterInjector{

    // TODO: Inject dependencies to presenter
    fun inject()

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
package test.billeasy.com.billeasytest.base

/**
 * abstract BasePresenter class will create dagger dependency injector and inject to the classes inheriting BasePresenter
 */
abstract class BasePresenter<out V: BaseView>(protected val view: V) {

    init {
        inject()
    }

    open fun onViewCreated() {

    }

    open fun onViewDestroyed() {

    }

    private fun inject() {

    }
}
package test.billeasy.com.billeasytest.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * abstract BaseActivity class will instantiate the presenter of inheriting classes and provides BaseView context
 */
abstract class BaseActivity<basePresenter : BasePresenter<BaseView>> : BaseView, AppCompatActivity() {

    protected lateinit var presenter: basePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = instantiatePresenter()
    }

    protected abstract fun instantiatePresenter(): basePresenter

    override fun getContext(): Context {
        return this
    }
}
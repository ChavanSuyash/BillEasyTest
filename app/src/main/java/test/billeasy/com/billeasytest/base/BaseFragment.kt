package test.billeasy.com.billeasytest.base

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment

abstract class BaseFragment<basePresenter : BasePresenter<BaseView>>: BaseView, Fragment() {

    protected lateinit var presenter: basePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = instantiatePresenter()
    }

    protected abstract fun instantiatePresenter(): basePresenter

    override fun getContext(): Context {
        return activity!!
    }

}
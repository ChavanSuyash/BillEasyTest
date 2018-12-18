package test.billeasy.com.billeasytest.base

import android.content.Context

/**
 * Interface BaseView will make activity context available to inheriting Views
 */
interface BaseView {

    /**
     * Returns context of activity
     */
    fun getContext(): Context
}
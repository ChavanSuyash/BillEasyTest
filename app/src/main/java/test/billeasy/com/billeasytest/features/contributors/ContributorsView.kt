package test.billeasy.com.billeasytest.features.contributors

import test.billeasy.com.billeasytest.base.BaseView
import test.billeasy.com.billeasytest.data.model.Owner

interface ContributorsView : BaseView {

    fun showLoading()

    fun hideLoading()

    fun showContributors(contributors : List<Owner>)

    fun showError(error: String)
}
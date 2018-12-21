package test.billeasy.com.billeasytest.features.contributors.repositories

import test.billeasy.com.billeasytest.base.BaseView
import test.billeasy.com.billeasytest.data.model.GitRepository

interface ContributorRepositoryListView : BaseView {

    fun showLoading()

    fun hideLoading()

    fun showRepositories(gitRepositoryList : List<GitRepository>)

    fun showError(error: String)

}
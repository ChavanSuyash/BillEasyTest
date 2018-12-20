package test.billeasy.com.billeasytest.features.repositories

import test.billeasy.com.billeasytest.base.BaseView
import test.billeasy.com.billeasytest.data.model.GitRepository

interface RepositoryListView : BaseView {

    fun showLoading()

    fun hideLoading()

    fun showGitRepositories(gitRepositoryList: List<GitRepository>)

    fun showError(error: String)
}
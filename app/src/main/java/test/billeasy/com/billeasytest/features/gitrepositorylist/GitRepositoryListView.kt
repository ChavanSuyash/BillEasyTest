package test.billeasy.com.billeasytest.features.gitrepositorylist

import test.billeasy.com.billeasytest.base.BaseView
import test.billeasy.com.billeasytest.data.model.GitRepository

interface GitRepositoryListView : BaseView {

    fun showLoading()

    fun hideLoading()

    fun showGitRepositories(gitRepositoryList: List<GitRepository>)

    fun showError(error: String)
}
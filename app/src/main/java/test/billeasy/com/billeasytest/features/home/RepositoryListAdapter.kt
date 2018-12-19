package test.billeasy.com.billeasytest.features.home

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import test.billeasy.com.billeasytest.R
import test.billeasy.com.billeasytest.data.model.GitRepository
import test.billeasy.com.billeasytest.databinding.ItemRepositoryListBinding

class GitRepositoryListAdapter(private val context: Context) : RecyclerView.Adapter<GitRepositoryListAdapter.GitRepositoryViewHolder>() {

    /**
     * The list of git repository of the adapter
     */

    private var gitRepositoryList: List<GitRepository> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitRepositoryListAdapter.GitRepositoryViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding: ItemRepositoryListBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_repository_list, parent, false)
        return GitRepositoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return gitRepositoryList.size
    }

    override fun onBindViewHolder(holder: GitRepositoryListAdapter.GitRepositoryViewHolder, position: Int) {
        holder.bind(gitRepositoryList[position])
    }

    /**
     * Updates the list of posts of the adapter
     * @param gitRepositoryList the new list of git repository of the adapter
     */
    fun updatePosts(gitRepositoryList: List<GitRepository>) {
        this.gitRepositoryList = gitRepositoryList
        notifyDataSetChanged()
    }

    /**
     * The ViewHolder of the adapter
     * @property binding the DataBinging object for Git Repository item
     */
    class GitRepositoryViewHolder(private val binding: ItemRepositoryListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: GitRepository) {
            binding.apply {
                gitRepository = item
                executePendingBindings()
            }
        }
    }

}
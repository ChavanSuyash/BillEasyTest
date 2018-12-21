package test.billeasy.com.billeasytest.features.contributors.repositories

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import test.billeasy.com.billeasytest.R
import test.billeasy.com.billeasytest.data.model.GitRepository
import test.billeasy.com.billeasytest.databinding.ItemRepositoryListBinding

class ContributorRepositoriesAdapter(val context: Context)
    : RecyclerView.Adapter<ContributorRepositoriesAdapter.RepositoryViewHolder>() {

    var gitRepositoryList : List<GitRepository> = listOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContributorRepositoriesAdapter.RepositoryViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding : ItemRepositoryListBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_repository_list, parent, false)
        return RepositoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return gitRepositoryList.size
    }

    override fun onBindViewHolder(holder: ContributorRepositoriesAdapter.RepositoryViewHolder, position: Int) {
        holder.bind(gitRepositoryList[position])
    }

    /**
     * Updates the list of git repositories of the adapter
     * @param gitRepositoryList the new list of contributors of the adapter
     */
    fun updateRepositories(gitRepositoryList : List<GitRepository>) {
        this.gitRepositoryList = gitRepositoryList
        notifyDataSetChanged()
    }

    class RepositoryViewHolder(val binding : ItemRepositoryListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item : GitRepository) {
            binding.apply {
                gitRepository = item
                executePendingBindings()
            }
        }

    }

}
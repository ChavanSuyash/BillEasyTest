package test.billeasy.com.billeasytest.features.repositories

import android.content.Context
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import test.billeasy.com.billeasytest.R
import test.billeasy.com.billeasytest.data.model.GitRepository
import test.billeasy.com.billeasytest.databinding.ItemRepositoryListBinding

class RepositoryListAdapter(private val context: Context) : RecyclerView.Adapter<RepositoryListAdapter.GitRepositoryViewHolder>() {

    /**
     * The list of git repository of the adapter
     */

    private var gitRepositoryList: List<GitRepository> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryListAdapter.GitRepositoryViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding: ItemRepositoryListBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_repository_list, parent, false)
        return GitRepositoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return gitRepositoryList.size
    }

    override fun onBindViewHolder(holder: RepositoryListAdapter.GitRepositoryViewHolder, position: Int) {
        holder.bind(createOnClickListener(gitRepositoryList[position]),gitRepositoryList[position])
    }

    private fun createOnClickListener(gitRepository : GitRepository): View.OnClickListener {
        return View.OnClickListener {
            val direction = RepositoryListFragmentDirections.ActionGitListToContributorsFragment(gitRepository )
            it.findNavController().navigate(direction)
        }
    }

    /**
     * Updates the list of git repository of the adapter
     * @param gitRepositoryList the new list of git repository of the adapter
     */
    fun updatePosts(gitRepositoryList: List<GitRepository>) {
        this.gitRepositoryList = gitRepositoryList
        notifyDataSetChanged()
    }

    /**
     * The ViewHolder of the adapter
     * @property binding the DataBinging object for git repository item
     */
    class GitRepositoryViewHolder(private val binding: ItemRepositoryListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: GitRepository) {
            binding.apply {
                clickListener = listener
                gitRepository = item
                executePendingBindings()
            }
        }
    }

}
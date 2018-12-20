package test.billeasy.com.billeasytest.features.contributors

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import test.billeasy.com.billeasytest.R
import test.billeasy.com.billeasytest.data.model.Owner
import test.billeasy.com.billeasytest.databinding.ItemContributorsListBinding


class  ContributorsListAdapter(val context: Context) : RecyclerView.Adapter<ContributorsListAdapter.ContributorsViewHolder>(){

    private var contributorsList : List<Owner> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContributorsViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding : ItemContributorsListBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_contributors_list, parent, false)
        return ContributorsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return contributorsList.size
    }

    override fun onBindViewHolder(holder: ContributorsViewHolder, position: Int) {
        holder.bind(contributorsList[position])
    }

    /**
     * Updates the list of contributors of the adapter
     * @param contributorsList the new list of contributors of the adapter
     */
    fun updateContributors(contributorsList : List<Owner>) {
        this.contributorsList = contributorsList
        notifyDataSetChanged()
    }

    class ContributorsViewHolder(private val binding: ItemContributorsListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item : Owner) {
            binding.apply {
                owner = item
            }
        }
    }
}

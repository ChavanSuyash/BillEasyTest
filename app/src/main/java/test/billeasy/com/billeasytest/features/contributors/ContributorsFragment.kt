package test.billeasy.com.billeasytest.features.contributors

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.snackbar.Snackbar
import test.billeasy.com.billeasytest.base.BaseFragment
import test.billeasy.com.billeasytest.data.model.Owner
import test.billeasy.com.billeasytest.databinding.FragmentContributorsBinding
import test.billeasy.com.billeasytest.features.contributors.ContributorsFragmentArgs.fromBundle

const val CONTRIBUTORS_FRAGMENT_TAG = "ContributorsFragment"

class ContributorsFragment : BaseFragment<ContributorsPresenter>() , ContributorsView {

    private lateinit var binding : FragmentContributorsBinding
    private lateinit var contributorListAdapter: ContributorsListAdapter

    val gitRepository by lazy {
        fromBundle(arguments!!).gitRepository
    }

    override fun instantiatePresenter(): ContributorsPresenter {
        return ContributorsPresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.e(CONTRIBUTORS_FRAGMENT_TAG,"onCreateView")

        binding = FragmentContributorsBinding.inflate(inflater, container, false)

        binding.gitRepository = gitRepository
        contributorListAdapter = ContributorsListAdapter(binding.root.context)
        binding.contributorsList.adapter = contributorListAdapter
        binding.contributorsList.layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        Log.e(CONTRIBUTORS_FRAGMENT_TAG,"onStart")
        presenter.loadContributors(gitRepository.owner.login, gitRepository.name)
    }

    override fun onStop() {
        super.onStop()
        Log.e(CONTRIBUTORS_FRAGMENT_TAG,"onStop")
        presenter.onViewDestroyed()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e(CONTRIBUTORS_FRAGMENT_TAG,"onDestroyView")
    }

    override fun showLoading() {
        binding.progressVisibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressVisibility = View.GONE
    }

    override fun showContributors(contributorsList: List<Owner>) {
        contributorListAdapter.updateContributors(contributorsList)
    }

    override fun showError(error: String) {
        Snackbar.make(binding.root, error, Snackbar.LENGTH_LONG).show()
        Log.e(CONTRIBUTORS_FRAGMENT_TAG, "Error")
    }

}
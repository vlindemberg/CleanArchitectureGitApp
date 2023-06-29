package com.example.cleanarchitecturegitapp.presentation.view.gitUserDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.cleanarchitecturegitapp.databinding.UserDetailFragmentBinding
import com.example.cleanarchitecturegitapp.presentation.model.GitRepoViewData
import com.example.cleanarchitecturegitapp.presentation.model.GitUserViewData
import com.example.cleanarchitecturegitapp.presentation.view.gitUserDetails.adapter.GitUserDetailsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GitUserDetailsFragment : Fragment() {

    private var _binding: UserDetailFragmentBinding? = null
    private val binding get() = _binding!!
    private val args: GitUserDetailsFragmentArgs by navArgs()
    private val viewModel: GitUserDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = UserDetailFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    override fun onResume() {
        super.onResume()
        loadDate()
    }

    private fun setupObservers() {
        binding.backBtn.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        lifecycleScope.launch {
            viewModel.states.collect {
                setupLoading(it.isLoading)
                loadRepoGitList(it.gitRepoList)
                loadUser(it.user)
                loadError(it.errorMessage)
            }
        }

    }

    private fun setupLoading(loading: Boolean) {
        if (loading) {
            binding.loading.visibility = View.VISIBLE
        } else {
            binding.loading.visibility = View.GONE
        }
    }

    private fun loadError(errorMessage: String) {
        Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
    }

    private fun loadRepoGitList(repoGit: List<GitRepoViewData>) {
        val adapterLocation = GitUserDetailsAdapter(repoGit)
        binding.recyclerViewRepository.run {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterLocation
        }
    }

    private fun loadUser(user: GitUserViewData) {
        binding.run {
            name.text = user.name
            login.text = user.login
            fork.text = user.publicRepo.toString()
            Glide.with(pictureUser).load(user.imgUrl).into(pictureUser)
        }
    }

    private fun loadDate() {
        viewModel.getRepoGit(args.username)
        viewModel.getUser(args.username)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}

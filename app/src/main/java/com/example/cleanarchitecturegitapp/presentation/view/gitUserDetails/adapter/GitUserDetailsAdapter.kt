package com.example.cleanarchitecturegitapp.presentation.view.gitUserDetails.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecturegitapp.databinding.RepoListItemBinding
import com.example.cleanarchitecturegitapp.presentation.model.GitRepoViewData

class GitUserDetailsAdapter(private val repoGitList: List<GitRepoViewData>) :
    RecyclerView.Adapter<GitUserDetailsAdapter.GitRepoViewHolder>() {
    class GitRepoViewHolder(val binding: RepoListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitRepoViewHolder {
        val binding = RepoListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GitRepoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GitRepoViewHolder, position: Int) {
        val repoGit = repoGitList[position]
        holder.binding.apply {
            name.text = repoGit.name
        }

    }

    override fun getItemCount(): Int = repoGitList.size
}
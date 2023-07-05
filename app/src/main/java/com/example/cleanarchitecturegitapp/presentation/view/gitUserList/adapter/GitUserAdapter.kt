package com.example.cleanarchitecturegitapp.presentation.view.gitUserList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cleanarchitecturegitapp.databinding.UserListItemBinding
import com.example.cleanarchitecturegitapp.presentation.model.GitUserViewData

class GitUserAdapter(
    private var userList: List<GitUserViewData>,
    private val onItemClickListener: (user: GitUserViewData) -> Unit
) : RecyclerView.Adapter<GitUserAdapter.GitUserViewHolder>() {

    class GitUserViewHolder(val binding: UserListItemBinding) :
        RecyclerView.ViewHolder(binding.root)


    fun setFilteredList(userList: List<GitUserViewData>) {
        this.userList = userList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitUserViewHolder {
        val binding = UserListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GitUserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GitUserViewHolder, position: Int) {
        val user = userList[position]
        if (user.imgUrl.isNotEmpty()) {
            holder.binding.apply {
                Glide.with(picture).load(user.imgUrl).into(picture)
                name.text = user.name
                this.root.setOnClickListener { onItemClickListener.invoke(user) }
            }
        }
    }

    override fun getItemCount(): Int = userList.size
}
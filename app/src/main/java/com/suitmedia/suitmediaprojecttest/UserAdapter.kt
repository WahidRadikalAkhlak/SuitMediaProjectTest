package com.suitmedia.suitmediaprojecttest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.suitmedia.suitmediaprojecttest.databinding.ItemUserBinding
import com.suitmedia.suitmediaprojecttest.response.DataItem

class UserAdapter(private val onUserItemClickListener: OnUserItemClickListener) : PagingDataAdapter<DataItem, UserAdapter.MyUserHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyUserHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyUserHolder(binding)
    }

    override fun onBindViewHolder(holder: MyUserHolder, position: Int) {
        val review = getItem(position)
        if (review != null) {
            holder.bind(review)
            holder.itemView.setOnClickListener {
               "${review.firstName} ${review.lastName}".let { it1 -> onUserItemClickListener.onUserItemClicked(it1) }
            }
        }

    }

    class MyUserHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: DataItem) {
            binding.tvFirstname.text = "${user.firstName}"
            binding.tvLastname.text = "${user.lastName}"
            binding.tvEmail.text = "${user.email}"
            Glide.with(binding.root.context)
                .load(user.avatar)
                .into(binding.imgAvatar)
        }
    }

    interface OnUserItemClickListener {
        fun onUserItemClicked(username: String)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DataItem>() {
            override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}
package com.example.bankApplication.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bankApplication.R
import com.example.bankApplication.model.Client
import kotlinx.android.synthetic.main.little_view_user.view.*

class ItemUserAdapter(private val users:ArrayList<Client>, private val context: Context):RecyclerView.Adapter<ItemUserAdapter.UsersViewHolder>() {
    lateinit var listener:OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(view: View?, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        return UsersViewHolder(LayoutInflater.from(context).inflate(R.layout.little_view_user,parent,false))
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.tvUserName.text = users.get(position).firstName
    }


    class UsersViewHolder(view:View):RecyclerView.ViewHolder(view){
        val tvUserName = view.user_name
    }
}
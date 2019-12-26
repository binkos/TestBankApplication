package com.example.bankApplication.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bankApplication.R
import com.example.bankApplication.model.Client
import kotlinx.android.synthetic.main.little_view_user.view.*

class ItemUserAdapter(private val users:ArrayList<Client>, private val context: Context,val clickListener:(Client)->Unit):RecyclerView.Adapter<ItemUserAdapter.UsersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        return UsersViewHolder(LayoutInflater.from(context).inflate(R.layout.little_view_user,parent,false))
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.bind(users[position],clickListener)
    }

    class UsersViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        private val tvName:TextView = itemView.findViewById(R.id.user_name)
        private val tvSecondName:TextView = itemView.findViewById(R.id.user_second_name)
        private val tvSalary:TextView = itemView.findViewById(R.id.user_salary)
        private val linLay:LinearLayout = itemView.findViewById(R.id.user_linear)

        fun bind(client: Client,clickListener: (Client) -> Unit){

            tvName.text = client.firstName
            tvSecondName.user_second_name.text = client.surName
            tvSalary.user_salary.text = client.salary.toString()
            linLay.setOnClickListener {
                clickListener(client)
            }
        }
    }
}



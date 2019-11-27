package com.example.bankApplication.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bankApplication.Adapter.ItemUserAdapter
import com.example.bankApplication.R
import com.example.bankApplication.viewModel.MyModel
import kotlinx.android.synthetic.main.list_users.*
import kotlinx.android.synthetic.main.list_users.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.zip.Inflater

class ListUsersFragment: Fragment() {
lateinit var viewModel:MyModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(requireActivity()).get(MyModel::class.java)
        return layoutInflater.inflate(R.layout.list_users,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val rec = view.findViewById<RecyclerView>(R.id.rec_list_users)
        rec.layoutManager=LinearLayoutManager(this.context)

        GlobalScope.launch {
            val arrayList = viewModel.showAll()

            withContext(Dispatchers.Main){
                rec.adapter = ItemUserAdapter(arrayList,this@ListUsersFragment.context as Context)
            }

        }

        }


    }

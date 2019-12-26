package com.example.bankApplication.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bankApplication.Adapter.ItemUserAdapter
import com.example.bankApplication.R
import com.example.bankApplication.databinding.ListUsersBinding
import com.example.bankApplication.model.Client
import com.example.bankApplication.model.MainApplication
import com.example.bankApplication.viewModel.MyModel
import kotlinx.android.synthetic.main.list_users.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListUsersFragment: Fragment() {

    lateinit var viewModel:MyModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ListUsersBinding = DataBindingUtil.inflate(inflater,R.layout.list_users,container,false)
        viewModel = ViewModelProviders.of(requireActivity()).get(MyModel::class.java)
        binding.model = viewModel


        GlobalScope.launch {
            val arrayList = viewModel.showAll()
            withContext(Dispatchers.Main){
                val adapter = ItemUserAdapter(arrayList,this@ListUsersFragment.context as Context){a(it)}

                Toast.makeText(context,arrayList[0].cityFact,Toast.LENGTH_LONG).show()
                rec_list_users.adapter = adapter
                rec_list_users.layoutManager = LinearLayoutManager(MainApplication.applicationContext())

            }


        }
        return binding.root
       }

    private fun a(client: Client){
        Toast.makeText(context,"${client.ID} cHelloWorld",Toast.LENGTH_SHORT).show()
    }

    }


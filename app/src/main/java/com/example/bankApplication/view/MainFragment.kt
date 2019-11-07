package com.example.bankApplication.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.bankApplication.R
import com.example.bankApplication.databinding.ActivityMain1Binding
import com.example.bankApplication.databinding.ActivityMainBinding
import com.example.bankApplication.databinding.ActivityMainFragmentBinding
import com.example.bankApplication.viewModel.MyModel
import com.example.bankApplication.viewModel.MyViewModel

class MainFragment: Fragment() {
    lateinit var model: MyModel
    lateinit var binding:ActivityMainFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.activity_main_fragment,container,false)
        model = ViewModelProviders.of(this).get(MyModel::class.java)
        binding.model = model
        return binding.root;
    }

}
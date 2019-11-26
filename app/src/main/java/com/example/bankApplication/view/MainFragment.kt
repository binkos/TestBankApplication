package com.example.bankApplication.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.bankApplication.R
import com.example.bankApplication.databinding.ActivityMainFragmentBinding
import com.example.bankApplication.viewModel.MyModel

class MainFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:ActivityMainFragmentBinding= DataBindingUtil.inflate(inflater,R.layout.activity_main_fragment,container,false)
        val model:MyModel = ViewModelProviders.of(requireActivity()).get(MyModel::class.java)
        binding.model = model
        return binding.root
    }



}
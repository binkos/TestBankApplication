package com.example.bankApplication.view

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.bankApplication.R
import com.example.bankApplication.databinding.ActivityMain1Binding
import com.example.bankApplication.databinding.ActivityMainBinding
import com.example.bankApplication.viewModel.MyModel
import com.example.bankApplication.viewModel.MyViewModel

class SecondFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ActivityMain1Binding = DataBindingUtil.inflate(inflater,R.layout.activity_main_1,container,false)
        return binding.root;
    }
}
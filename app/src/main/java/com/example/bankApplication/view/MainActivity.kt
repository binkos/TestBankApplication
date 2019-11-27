package com.example.bankApplication.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.bankApplication.R
import com.example.bankApplication.databinding.ActivityMainBinding
import com.example.bankApplication.viewModel.MyModel
import com.example.bankApplication.viewModel.MyModel.balloon.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val model: MyModel = ViewModelProviders.of(this).get(MyModel::class.java)
        val binding:ActivityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.mainModel = model

        supportFragmentManager.beginTransaction().replace(binding.cont.id,MainFragment()).commit()


        Log.d("","observed")
        model.dates.observe(this, Observer { s->

            when (s) {
                openSecondActivity -> {
                    Log.d("","OpenSecondActivity")
                    supportFragmentManager.beginTransaction().replace(binding.cont.id,SecondFragment()).commit()
                }

                comeBackToTheFirst -> {
                    Log.d("","ComeBackToTheFirst")
                    supportFragmentManager.beginTransaction().replace(binding.cont.id,MainFragment()).commit()
                }

                showAllUsers -> {
                    Log.d("","ShowAllUsers")
                    supportFragmentManager.beginTransaction().replace(binding.cont.id,ListUsersFragment()).commit()
                }
            }
        })
    }

    override fun onPause() {
        super.onPause()
        Log.d("log","OnPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("log","OnDestroy")
    }

}

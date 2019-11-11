package com.example.bankApplication.viewModel

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyModel: ViewModel() {
    private var data = MutableLiveData<balloon>()
    var dates:LiveData<balloon> = data
    fun getData(v: View){
        changeValue()
        Log.d("loadData","changed")
    }

    private fun changeValue(){
        if (data.value == balloon.comeBackToTheFirst) {
            data.value = balloon.openSecondActivity
        } else data.value = balloon.comeBackToTheFirst
        Log.d("loadData","${dates.value} changed")
        Log.d("loadData","${dates.hasObservers()}")
    }

    sealed class balloon{
        object openSecondActivity : balloon()
        object comeBackToTheFirst : balloon()
    }

}
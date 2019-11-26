package com.example.bankApplication.viewModel

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bankApplication.model.App
import com.example.bankApplication.model.Client
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyModel: ViewModel() {

    private var data = MutableLiveData<balloon>()
    var dates:LiveData<balloon> = data
    private val ioScope = CoroutineScope(Dispatchers.IO)

    fun viewChange(){
        if (data.value == balloon.comeBackToTheFirst||data.value ==null) {
            data.value = balloon.openSecondActivity
        } else if (data.value == balloon.openSecondActivity)
            data.value = balloon.comeBackToTheFirst
    }

    fun changeValue(v:View){
        viewChange()

        Log.d("loadData","${dates.value} changed")
        Log.d("loadData","${dates.hasObservers()}")
    }

    sealed class balloon{
        object openSecondActivity : balloon()
        object comeBackToTheFirst : balloon()
    }

    fun changeBase(client: Client){
        ioScope.launch {
            App.instance.db.clientDao().insertClient(client)
            withContext(Dispatchers.Main){
                viewChange()
            }
        }
    }

    fun showAll(v:View){
        ioScope.launch {
            val size = App.instance.db.clientDao().getAllClients()
            Log.d("MyLog","size of db is ${size.size}")
            //Log.d("MyLog","first person of db is ${size[0].ID}")
        }
    }


}
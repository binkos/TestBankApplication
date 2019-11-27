package com.example.bankApplication.viewModel

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bankApplication.R
import com.example.bankApplication.model.App
import com.example.bankApplication.model.Client
import kotlinx.android.synthetic.main.activity_main_fragment.view.*
import kotlinx.coroutines.*

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

    fun viewChange(v:View){
    when(v.id){
        R.id.registr_button->data.value = balloon.openSecondActivity
        R.id.show_button->data.value = balloon.showAllUsers
        R.id.backBtn->data.value = balloon.comeBackToTheFirst
        R.id.addBtn->data.value = balloon.comeBackToTheFirst
    }
    }

    fun changeValue(v:View){
        viewChange(v)
    }

    fun changeValue(){
        viewChange()
    }

    sealed class balloon{
        object openSecondActivity : balloon()
        object comeBackToTheFirst : balloon()
        object showAllUsers : balloon()
    }

    fun changeBase(client: Client){
        ioScope.launch {
            App.instance.db.clientDao().insertClient(client)
            withContext(Dispatchers.Main){
                viewChange()
            }
        }
    }

suspend fun showAll():ArrayList<Client>{
        var users: ArrayList<Client> = ArrayList()
        Log.d("MyLog","size of users list ${users.size}")

    return ioScope.async {
        users = App.instance.db.clientDao().getAllClients() as ArrayList<Client>
        Log.d("MyLog","size of db is ${users.size}")
        withContext(Dispatchers.Main){return@withContext users;}
    }.await()
}




}
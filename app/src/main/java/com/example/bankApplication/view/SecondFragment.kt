package com.example.bankApplication.view

import android.graphics.Color
import android.os.Bundle
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.bankApplication.R
import com.example.bankApplication.databinding.ActivityMain1Binding
import com.example.bankApplication.model.Client
import com.example.bankApplication.viewModel.MyModel
import kotlinx.android.synthetic.main.activity_main_1.*

class SecondFragment: Fragment() {
    lateinit var model:MyModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ActivityMain1Binding = DataBindingUtil.inflate(inflater,R.layout.activity_main_1,container,false)
        model= ViewModelProviders.of(requireActivity()).get(MyModel::class.java)
        binding.model = model
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        addBtn.setOnClickListener { run{
            if (isValid()) model.changeBase(Client(surName = Surname.text.toString(),salary = salary.text.toString().toLong(),secondName = SecondName.text.toString(),
                serialPass = Number_passport.toString(),address = address.toString(),dateOfIssue = "qwe", disab = "zxc",firstName = "1",
                numberPass = "123".toLong(),email = "",mobile = "",phone = "", retiree = "",dutybound = "",
                birthDay = "",city = "",nation = "",marital = "", authority = ""))

        } }
    }

    private fun checkFistName():Boolean {
        if (FirstName.text.isEmpty()){
            FirstName.setBackgroundColor(Color.parseColor("#FFCCCC"))
            return false
        }
        FirstName.setBackgroundColor(Color.TRANSPARENT)
        return true
    }
    private fun checkSurName():Boolean {
        if (Surname.text.isEmpty()){
            Surname.setBackgroundColor(Color.parseColor("#FFCCCC"))
            return false
        }
        Surname.setBackgroundColor(Color.TRANSPARENT)
        return true
    }
    private fun checkSecondName():Boolean {
        if (SecondName.text.isEmpty()){
            SecondName.setBackgroundColor(Color.parseColor("#FFCCCC"))
            return false
        }
        SecondName.setBackgroundColor(Color.TRANSPARENT)
        return true
    }
    private fun checkWhoGaven():Boolean {
        if (Who_gave.text.isEmpty()){
            Who_gave.setBackgroundColor(Color.parseColor("#FFCCCC"))
            return false
        }
        Who_gave.setBackgroundColor(Color.TRANSPARENT)
        return true

    }
    private fun checkCity():Boolean {
        if (city_live.text.isEmpty()){
            city_live.setBackgroundColor(Color.parseColor("#FFCCCC"))
            return false
        }
        city_live.setBackgroundColor(Color.TRANSPARENT)
        return true

    }
    private fun checkNationality():Boolean {
        if (nationality.text.isEmpty()){
            nationality.setBackgroundColor(Color.parseColor("#FFCCCC"))
            return false
        }
        nationality.setBackgroundColor(Color.TRANSPARENT)
        return true

    }
    private fun checkDateOfBirth():Boolean {
        if (Date_Of_Birthday.text.isEmpty()){
            Date_Of_Birthday.setBackgroundColor(Color.parseColor("#FFCCCC"))
            return false
        }
        Date_Of_Birthday.setBackgroundColor(Color.TRANSPARENT)
        return true
    }
    private fun checkPlaceOfBirth():Boolean {
        if (city.text.isEmpty()){
            city.setBackgroundColor(Color.parseColor("#FFCCCC"))
            return false
        }
        city.setBackgroundColor(Color.TRANSPARENT)
        return true
    }
    private fun checkAddress():Boolean {
        if (address.text.isEmpty()){
            address.setBackgroundColor(Color.parseColor("#FFCCCC"))
            return false
        }
        address.setBackgroundColor(Color.TRANSPARENT)
        return true
    }
    private fun checkFamilyStatus():Boolean {
        if (family_status.text.isEmpty()){
            family_status.setBackgroundColor(Color.parseColor("#FFCCCC"))
            return false
        }
        family_status.setBackgroundColor(Color.TRANSPARENT)
        return true
    }
    private fun checkNumberPass():Boolean {
        if (identification.text.isEmpty()){
            identification.setBackgroundColor(Color.parseColor("#FFCCCC"))
            return false
        }
        identification.setBackgroundColor(Color.TRANSPARENT)
        return true
    }
    private fun isValid():Boolean{
        var validatiobBoolean = 0

        if (!checkCity()) ++validatiobBoolean
        if (!checkDateOfBirth()) ++validatiobBoolean
        if (!checkFistName()) ++validatiobBoolean
        if (!checkNationality()) ++validatiobBoolean
        if (!checkSecondName()) ++validatiobBoolean
        if (!checkSurName()) ++validatiobBoolean
        if (!checkWhoGaven()) ++validatiobBoolean
        if (!checkPlaceOfBirth()) ++validatiobBoolean
        if (!checkAddress()) ++validatiobBoolean
        if (!checkFamilyStatus()) ++validatiobBoolean
        if (!checkNumberPass()) ++validatiobBoolean
        return validatiobBoolean==0
    }


}
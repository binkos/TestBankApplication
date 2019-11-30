package com.example.bankApplication.view

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.bankApplication.R
import com.example.bankApplication.databinding.ActivityMain1Binding
import com.example.bankApplication.model.Client
import com.example.bankApplication.viewModel.MyModel
import kotlinx.android.synthetic.main.activity_main_1.*
import java.util.*

class SecondFragment: Fragment() {

    val currentDateBirth = Calendar.getInstance()
    val currentDateGiving = Calendar.getInstance()
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
        initSpinners()
        initTimeAndDatePickers()

        addBtn.setOnClickListener { run{
            if (isValid()) model.changeBase(Client(Surname.text.toString(),FirstName.text.toString(),SecondName.text.toString()
                ,currentDateBirth.timeInMillis,series_passport.text.toString(),Number_passport.text.toString().toLong(),Who_gave.text.toString()
                ,currentDateGiving.timeInMillis,city.text.toString(),address_of_living.text.toString(),address.text.toString(),num_of_home.toString()
                ,phone.toString(),mail.text.toString(),position.text.toString(),spinner_cities.selectedItem.toString(),family_status.selectedItem.toString()
                ,citizenship.selectedItem.toString(),disabled.selectedItem.toString(),false,salary.text.toString().toInt(),identification = identification.text.toString().toUpperCase(Locale.ROOT)))

        } }
    }

    private fun initSpinners(){
        val listOfCities = arrayOf("Choose your city","None","Minsk","Grodno","Gomel","Brest","Vitebsk","Molodechno")
        val listOfStatuses = arrayOf("Choose your family status","Free","Married","Engaged","Divorced")
        val listOfCitizenships = arrayOf("Choose your citizenship","None","Belarus","Russia","Poland","German","Ukraine","Canada")
        val listOfDisabledes = arrayOf("Choose degree of disable","None","1 degree","2 degree","3 degree","4 degree","Death")


        view?.findViewById<Spinner>(R.id.spinner_cities)?.adapter = ArrayAdapter(this.context as Context,android.R.layout.simple_spinner_item,listOfCities)
        view?.findViewById<Spinner>(R.id.family_status)?.adapter = ArrayAdapter(this.context as Context,android.R.layout.simple_spinner_item,listOfStatuses)
        view?.findViewById<Spinner>(R.id.citizenship)?.adapter = ArrayAdapter(this.context as Context,android.R.layout.simple_spinner_item,listOfCitizenships)
        view?.findViewById<Spinner>(R.id.disabled)?.adapter = ArrayAdapter(this.context as Context,android.R.layout.simple_spinner_item,listOfDisabledes)
    }
    @SuppressLint("NewApi")
    private fun initTimeAndDatePickers() {

        val pickerBirth = DatePickerDialog.OnDateSetListener { _, i, i2, i3 ->
            run {
                currentDateBirth.set(Calendar.YEAR, i)
                currentDateBirth.set(Calendar.MONTH, i2)
                currentDateBirth.set(Calendar.DAY_OF_MONTH, i3)
                Date_Of_Birthday.setText( "${currentDateBirth.get(Calendar.DAY_OF_MONTH)}/${currentDateBirth.get(Calendar.MONTH)}/${currentDateBirth.get(Calendar.YEAR)}")
            }
        }

        val pickerGiving = DatePickerDialog.OnDateSetListener { _, i, i2, i3 ->
            run {
                currentDateGiving.set(Calendar.YEAR, i)
                currentDateGiving.set(Calendar.MONTH, i2)
                currentDateGiving.set(Calendar.DAY_OF_MONTH, i3)
                time_giving.setText( "${currentDateGiving.get(Calendar.DAY_OF_MONTH)}/${currentDateGiving.get(Calendar.MONTH)}/${currentDateGiving.get(Calendar.YEAR)}")
            }
        }

        view?.findViewById<Button>(R.id.set_time_giving)?.setOnClickListener{
            run{
                DatePickerDialog(this@SecondFragment.context as Context,pickerGiving,currentDateGiving.get(Calendar.YEAR)
                    ,currentDateGiving.get(Calendar.MONTH),currentDateGiving.get(Calendar.DAY_OF_MONTH)).show()
            }
        }
        view?.findViewById<Button>(R.id.date_of_birthday_btn)?.setOnClickListener{
            run{
                Log.d("MyTAG","MyTag")
                DatePickerDialog(this@SecondFragment.context as Context,pickerBirth,currentDateBirth.get(Calendar.YEAR)
                    ,currentDateBirth.get(Calendar.MONTH),currentDateBirth.get(Calendar.DAY_OF_MONTH)).show()
            }
        }
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
    private fun checkDateOfBirthday():Boolean{
        if (Date_Of_Birthday.text.toString() == "Choose your birthday*"||currentDateBirth.timeInMillis>Calendar.getInstance().timeInMillis){
            Date_Of_Birthday.setBackgroundColor(Color.parseColor("#FFCCCC"))
            return false
        }
        Date_Of_Birthday.setBackgroundColor(Color.TRANSPARENT)

        return true
    }
    private fun checkDateOfGettingPassport():Boolean{
        if (time_giving.text.toString() == "Choose your time of getting passport*"||currentDateGiving.timeInMillis>Calendar.getInstance().timeInMillis){
            time_giving.setBackgroundColor(Color.parseColor("#FFCCCC"))
            return false
        }
        time_giving.setBackgroundColor(Color.TRANSPARENT)
        return true

    }
    private fun checkSeriesOfPassport():Boolean{
        if (series_passport.text.isEmpty()){
            series_passport.setBackgroundColor(Color.parseColor("#FFCCCC"))
            return false
        }
        series_passport.setBackgroundColor(Color.TRANSPARENT)
        return true
    }
    private fun checkIdentification():Boolean{
        if (identification.text.isEmpty()){
            identification.setBackgroundColor(Color.parseColor("#FFCCCC"))
            return false
        }
        identification.setBackgroundColor(Color.TRANSPARENT)
        return true
    }
    private fun checkAddressOfLiving():Boolean{
        if (address_of_living.text.isEmpty()){
            address_of_living.setBackgroundColor(Color.parseColor("#FFCCCC"))
            return false
        }
        address_of_living.setBackgroundColor(Color.TRANSPARENT)
        return true
    }
    private fun checkDisabled():Boolean{
        if (disabled.selectedItem == "Choose degree of disable") {
            disabled.setBackgroundColor(Color.parseColor("#FFCCCC"))
            return false
        }
        disabled.setBackgroundColor(Color.TRANSPARENT)
        return true
    }
    private fun checkCity():Boolean {
        if (spinner_cities.selectedItem=="Choose your city"){
            spinner_cities.setBackgroundColor(Color.parseColor("#FFCCCC"))
            return false
        }
        spinner_cities.setBackgroundColor(Color.TRANSPARENT)
        return true

    }
    private fun checkCitizenship():Boolean {
        if (citizenship.selectedItem == "Choose your citizenship"){
            citizenship.setBackgroundColor(Color.parseColor("#FFCCCC"))
            return false
        }
        citizenship.setBackgroundColor(Color.TRANSPARENT)
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
        if (family_status.selectedItem == "Choose your family status"){
            family_status.setBackgroundColor(Color.parseColor("#FFCCCC"))
            return false
        }
        family_status.setBackgroundColor(Color.TRANSPARENT)
        return true
    }
    private fun checkNumberPass():Boolean {
        if (Number_passport.text.isEmpty()){
            Number_passport.setBackgroundColor(Color.parseColor("#FFCCCC"))
            return false
        }
        Number_passport.setBackgroundColor(Color.TRANSPARENT)
        return true
    }

    private fun isValid():Boolean{
        var validationBoolean = 0

        if (!checkCity()) ++validationBoolean
        if (!checkDateOfBirthday()) ++validationBoolean
        if (!checkFistName()) ++validationBoolean
        if (!checkCitizenship()) ++validationBoolean
        if (!checkSecondName()) ++validationBoolean
        if (!checkSurName()) ++validationBoolean
        if (!checkWhoGaven()) ++validationBoolean
        if (!checkPlaceOfBirth()) ++validationBoolean
        if (!checkAddress()) ++validationBoolean
        if (!checkFamilyStatus()) ++validationBoolean
        if (!checkNumberPass()) ++validationBoolean
        if (!checkDateOfGettingPassport()) ++validationBoolean
        if (!checkSeriesOfPassport()) ++validationBoolean
        if (!checkIdentification()) ++validationBoolean
        if (!checkAddressOfLiving()) ++validationBoolean
        if (!checkDisabled()) ++validationBoolean
        return validationBoolean==0
    }








}
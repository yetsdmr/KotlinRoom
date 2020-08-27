package com.yetsdmr.kotlinroom.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.yetsdmr.kotlinroom.model.Country
import com.yetsdmr.kotlinroom.service.CountryDatabase
import kotlinx.coroutines.launch

class CountryViewModel(application: Application) : BaseViewModel(application) {

    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom(uuid: Int) {
        launch {

            val dao = CountryDatabase(getApplication()).countryDao()
            val country = dao.getCountry(uuid)
            countryLiveData.value = country

        }

    }
}
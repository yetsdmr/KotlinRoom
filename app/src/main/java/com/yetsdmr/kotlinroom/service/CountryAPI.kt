package com.yetsdmr.kotlinroom.service

import com.yetsdmr.kotlinroom.model.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountryAPI {

    //GET, POST

    //https://raw.githubusercontent.com/yetsdmr/DataSetCountries/master/countrydataset.json
    //BASE_URL -> https://raw.githubusercontent.com/
    //EXT -> yetsdmr/DataSetCountries/master/countrydataset.json

    @GET("yetsdmr/DataSetCountries/master/countrydataset.json")
    fun getCountries(): Single<List<Country>>
}
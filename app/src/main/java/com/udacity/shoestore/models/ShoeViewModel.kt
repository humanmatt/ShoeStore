package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {

    private var _name = MutableLiveData<String>()
    val shoeNameLive: LiveData<String>
    get() = _name

    private var _company = MutableLiveData<String>()
    val shoeCompanyLive: LiveData<String>
        get() = _company

    private var _description = MutableLiveData<String>()
    val shoeDescriptionLive: LiveData<String>
        get() = _description

    private var _size = MutableLiveData<Double>()
    val shoeSizeLive: LiveData<Double>
        get() = _size

    private var _shoeList = MutableLiveData<List<Shoe>>()
    val shoeListLive: LiveData<List<Shoe>>
    get() = _shoeList

    private val mShoeList = mutableListOf<Shoe>()

    init {

        _shoeList.value = mShoeList

    }

    fun addNewShoe(shoe: Shoe){

        mShoeList.add(shoe)

    }

}
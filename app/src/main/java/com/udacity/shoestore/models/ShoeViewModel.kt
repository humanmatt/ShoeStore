package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {


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
package com.example.compose.sceens.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProductViewModel : ViewModel() {

    private val _name = MutableLiveData<String>("")
    val name : LiveData<String> = _name

    fun setName(name : String) = _name.postValue(name)
}
package com.example.kotlin41.ui.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondViewModel :ViewModel(){
    private var _userData = MutableLiveData<UserModel>()
    val userData:LiveData<UserModel> = _userData

    fun updateUserModel(userModel: UserModel){
        _userData.value = userModel
    }
}
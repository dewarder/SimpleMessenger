package com.dewarder.messenger.ui.login

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.dewarder.messenger.base.BaseViewModel
import com.dewarder.messenger.domain.login.CheckEmailExistUseCase
import com.dewarder.messenger.util.plusAssign
import javax.inject.Inject

class LoginUsernameViewModel @Inject constructor(
        private val checkEmailExistUseCase: CheckEmailExistUseCase
) : BaseViewModel() {

    private val mutableEmailExist = MutableLiveData<Boolean>()

    val emailExist: LiveData<Boolean>
        get() = mutableEmailExist

    fun checkEmail(email: String) {
        disposables += checkEmailExistUseCase.execute(email)
                .subscribe(mutableEmailExist::postValue)
    }
}
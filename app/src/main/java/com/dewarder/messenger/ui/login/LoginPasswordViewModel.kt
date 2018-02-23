package com.dewarder.messenger.ui.login

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.dewarder.messenger.base.BaseViewModel
import com.dewarder.messenger.domain.login.LoginUseCase
import com.dewarder.messenger.util.plusAssign
import javax.inject.Inject

class LoginPasswordViewModel @Inject constructor(
        private val loginUseCase: LoginUseCase
) : BaseViewModel() {

    var email: String = ""

    private val mutableLoginSuccess = MutableLiveData<Boolean>()
    val loginSuccess: LiveData<Boolean>
        get() = mutableLoginSuccess

    fun login(password: String) {
        disposables += loginUseCase.execute(email, password)
                .subscribe(mutableLoginSuccess::postValue)
    }
}
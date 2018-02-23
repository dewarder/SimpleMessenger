package com.dewarder.messenger.ui.splash

import android.arch.lifecycle.LiveData
import com.dewarder.messenger.base.BaseViewModel
import com.dewarder.messenger.domain.login.CheckLoggedInUseCase
import com.dewarder.messenger.util.toLiveData
import javax.inject.Inject

class SplashViewModel @Inject constructor(
        private val checkLoggedInUseCase: CheckLoggedInUseCase
) : BaseViewModel() {

    val isLoggedIn: LiveData<Boolean>
        get() = checkLoggedInUseCase.isLoggedIn().toLiveData()
}
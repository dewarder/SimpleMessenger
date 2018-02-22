package com.dewarder.messenger.ui.splash

import android.arch.lifecycle.LiveData
import com.dewarder.messenger.base.BaseViewModel
import com.dewarder.messenger.domain.login.IsLoggedInUseCase
import com.dewarder.messenger.util.toLiveData
import javax.inject.Inject

class SplashViewModel @Inject constructor(
        private val isLoggedInUseCase: IsLoggedInUseCase
) : BaseViewModel() {

    val isLoggedIn: LiveData<Boolean>
        get() = isLoggedInUseCase.isLoggedIn().toLiveData()
}
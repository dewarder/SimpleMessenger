package com.dewarder.messenger.ui.splash

import android.content.Intent
import com.dewarder.messenger.base.BaseActivity
import com.dewarder.messenger.ui.login.LoginUsernameActivity
import dagger.android.AndroidInjection
import timber.log.Timber

class SplashActivity : BaseActivity<SplashViewModel>() {

    override fun injectComponents() = AndroidInjection.inject(this)

    override fun viewModelClass() = SplashViewModel::class

    override fun onViewModelCreated(viewModel: SplashViewModel) {
        viewModel.isLoggedIn.observe { isLoggedIn ->
            Timber.v("isLoggedIn = %b", isLoggedIn)
            if (isLoggedIn) {
                TODO()
            } else {
                openLoginUsernameScreen()
            }
            finish()
        }
    }

    private fun openLoginUsernameScreen() {
        startActivity(Intent(this, LoginUsernameActivity::class.java))
    }
}
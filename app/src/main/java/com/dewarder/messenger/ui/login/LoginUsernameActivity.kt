package com.dewarder.messenger.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.dewarder.messenger.R
import com.dewarder.messenger.base.BaseActivity
import dagger.android.AndroidInjection
import timber.log.Timber

class LoginUsernameActivity : BaseActivity<LoginUsernameViewModel>() {

    private lateinit var usernameInput: EditText
    private lateinit var proceedButton: View

    override fun injectComponents() = AndroidInjection.inject(this)

    override fun viewModelClass() = LoginUsernameViewModel::class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_username)

        usernameInput = findViewById(R.id.username)

        proceedButton = findViewById(R.id.proceed)
        proceedButton.setOnClickListener {
            viewModel.checkEmail(usernameInput.text.toString())
        }
    }

    override fun onViewModelCreated(viewModel: LoginUsernameViewModel) {
        viewModel.emailExist.observe { (exist, email) ->
            Timber.v("email %s, exist %b", email, exist)
            if (exist) {
                goToLoginPasswordScreen(email)
            }
        }
    }

    private fun goToLoginPasswordScreen(email: String) {
        LoginPasswordActivity.start(
                context = this,
                arguments = LoginPasswordActivity.Arguments(
                        email = email
                )
        )
    }

    companion object {

        fun start(context: Context) {
            context.startActivity(
                    Intent(context, LoginUsernameActivity::class.java)
            )
        }
    }
}
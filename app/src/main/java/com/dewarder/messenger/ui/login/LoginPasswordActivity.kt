package com.dewarder.messenger.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.dewarder.messenger.R
import com.dewarder.messenger.base.BaseActivity
import dagger.android.AndroidInjection
import kotlinx.android.parcel.Parcelize

class LoginPasswordActivity : BaseActivity<LoginPasswordViewModel>() {

    private lateinit var passwordInput: EditText
    private lateinit var proceedButton: View

    override fun injectComponents() = AndroidInjection.inject(this)

    override fun viewModelClass() = LoginPasswordViewModel::class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_password)

        passwordInput = findViewById(R.id.password)

        proceedButton = findViewById(R.id.proceed)
        proceedButton.setOnClickListener {
            viewModel.login(passwordInput.text.toString())
        }
    }

    override fun onViewModelCreated(viewModel: LoginPasswordViewModel) {
        val arguments: Arguments = getArguments()
        viewModel.email = arguments.email

        viewModel.loginSuccess.observe { success ->
            Toast.makeText(this, "Login $success", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {

        fun start(context: Context, arguments: Arguments) {
            context.startActivity(
                    Intent(context, LoginPasswordActivity::class.java).putArguments(arguments)
            )
        }
    }

    @Parcelize
    data class Arguments(
            val email: String
    ) : ArgumentsContainer
}
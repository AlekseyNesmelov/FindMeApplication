package com.nesmelovalexey.authlib.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.nesmelovalexey.authlib.R
import com.nesmelovalexey.authlib.databinding.AuthActivityBinding
import com.nesmelovalexey.authlib.presentation.AuthViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A login screen that offers login via email/password.
 *
 * @author Alexey Nesmelov
 */
class AuthActivity : AppCompatActivity() {

    val viewModel: AuthViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: AuthActivityBinding = DataBindingUtil.setContentView(this, R.layout.auth_activity)
        binding.viewModel = viewModel
    }
}

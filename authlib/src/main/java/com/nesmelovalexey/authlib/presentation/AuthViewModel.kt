package com.nesmelovalexey.authlib.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nesmelovalexey.authlib.domain.IAuthInteractor
import com.nesmelovalexey.corelib.logger.Logger

class AuthViewModel(private val authInteractor: IAuthInteractor,
                    val email : MutableLiveData<String> = MutableLiveData(),
                    val password: MutableLiveData<String> = MutableLiveData()) : ViewModel() {

    fun accept() {
        val emailValue = email.value
        val passwordValue = password.value
        if (emailValue.isNullOrEmpty()) {
            // TODO
            return
        }
        if (passwordValue.isNullOrEmpty()) {
            // TODO
            return
        }
        // TODO
        authInteractor.register(emailValue, passwordValue).subscribe(
            {
                Logger.d(TAG, "Registration has been completed successfully for email: $emailValue")
            },
            {
                Logger.d(TAG, "Registration failed for email: $emailValue", it)
            }
        )
    }

    companion object {
        const val TAG = "AuthViewModel"
    }
}
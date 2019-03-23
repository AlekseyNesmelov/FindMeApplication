package com.nesmelovalexey.authlib.presentation

import androidx.lifecycle.MutableLiveData
import com.nesmelovalexey.authlib.domain.IAuthInteractor
import com.nesmelovalexey.corelib.logger.Logger
import com.nesmelovalexey.corelib.rx.disposables.RxDisposables
import com.nesmelovalexey.corelib.rx.transformers.IRxTransformers
import com.nesmelovalexey.corelib.viewmodel.BaseViewModel

class AuthViewModel(val email : MutableLiveData<String> = MutableLiveData(),
                    val password: MutableLiveData<String> = MutableLiveData(),
                    private val authInteractor: IAuthInteractor,
                    private val rxTransformers: IRxTransformers,
                    private val rxDisposables: RxDisposables) : BaseViewModel(rxDisposables) {

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
        rxDisposables.container.add(
            authInteractor.register(emailValue, passwordValue)
                .compose(rxTransformers.ioToMain())
                .subscribe(
                    {
                        // TODO
                        Logger.d(TAG, "Registration has been completed successfully for email: $emailValue")
                    },
                    {
                        // TODO
                        Logger.d(TAG, "Registration failed for email: $emailValue", it)
                    }
                ))
    }

    companion object {
        const val TAG = "AuthViewModel"
    }
}
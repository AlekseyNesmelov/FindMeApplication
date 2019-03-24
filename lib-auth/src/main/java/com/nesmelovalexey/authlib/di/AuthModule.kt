package com.nesmelovalexey.authlib.di

import com.google.firebase.auth.FirebaseAuth
import com.nesmelovalexey.authlib.data.IAuthRepository
import com.nesmelovalexey.authlib.data.firebase.FirebaseAuthRepository
import com.nesmelovalexey.authlib.domain.AuthInteractor
import com.nesmelovalexey.authlib.domain.IAuthInteractor
import com.nesmelovalexey.authlib.presentation.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Authorization module
 */
val authModule = module {
    single { FirebaseAuth.getInstance() }
    factory<IAuthRepository> { FirebaseAuthRepository(get()) }
    factory<IAuthInteractor> { AuthInteractor(get())}
    viewModel { AuthViewModel(get(), get(), get()) }
}


package com.nesmelovalexey.userdatalib.di

import com.google.firebase.firestore.FirebaseFirestore
import com.nesmelovalexey.userdatalib.data.IUserDataRepository
import com.nesmelovalexey.userdatalib.data.firebase.FirebaseUserDataRepository
import org.koin.dsl.module.module

/**
 * User data module
 */
val userDataModule = module {
    single { FirebaseFirestore.getInstance() }
    factory<IUserDataRepository> { FirebaseUserDataRepository(get()) }
}

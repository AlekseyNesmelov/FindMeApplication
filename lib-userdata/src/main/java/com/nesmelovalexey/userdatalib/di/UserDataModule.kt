package com.nesmelovalexey.userdatalib.di

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.nesmelovalexey.userdatalib.data.IUserDataRepository
import com.nesmelovalexey.userdatalib.data.IUserPhotoRepository
import com.nesmelovalexey.userdatalib.data.firebase.FirebaseUserDataRepository
import com.nesmelovalexey.userdatalib.data.firebase.FirebaseUserPhotoRepository
import org.koin.dsl.module

/**
 * User data module
 */
val userDataModule = module {
    single { FirebaseFirestore.getInstance() }
    single { FirebaseStorage.getInstance() }
    factory<IUserDataRepository> { FirebaseUserDataRepository(get()) }
    factory<IUserPhotoRepository> { FirebaseUserPhotoRepository(get()) }
}

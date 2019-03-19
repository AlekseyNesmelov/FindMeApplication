package com.nesmelovalexey.findmeapp

import androidx.multidex.MultiDexApplication
import com.nesmelovalexey.authlib.di.authModule
import com.nesmelovalexey.userdatalib.di.userDataModule
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.Module

class FindMeApp : MultiDexApplication() {

    private val appComponent: List<Module> = listOf(userDataModule, authModule)

    override fun onCreate() {
        super.onCreate()
        startKoin(this, appComponent)
    }
}
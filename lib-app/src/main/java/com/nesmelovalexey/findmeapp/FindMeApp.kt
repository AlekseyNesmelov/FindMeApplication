package com.nesmelovalexey.findmeapp

import androidx.multidex.MultiDexApplication
import com.nesmelovalexey.authlib.di.authModule
import com.nesmelovalexey.corelib.di.coreModule
import com.nesmelovalexey.userdatalib.di.userDataModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class FindMeApp : MultiDexApplication() {

    private val appComponent: List<Module> = listOf(coreModule, userDataModule, authModule)

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@FindMeApp)
            modules(appComponent)
        }
    }
}
package com.nesmelovalexey.findmeapp

import android.app.Application
import com.nesmelovalexey.authlib.di.authComponent
import org.koin.android.ext.android.startKoin

class FindMeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, authComponent)
    }
}
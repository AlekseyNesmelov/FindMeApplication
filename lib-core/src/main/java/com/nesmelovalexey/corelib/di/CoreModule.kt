package com.nesmelovalexey.corelib.di

import com.nesmelovalexey.corelib.rx.disposables.RxDisposables
import com.nesmelovalexey.corelib.rx.schedullers.IRxSchedulers
import com.nesmelovalexey.corelib.rx.schedullers.RxSchedulers
import com.nesmelovalexey.corelib.rx.transformers.IRxTransformers
import com.nesmelovalexey.corelib.rx.transformers.RxTransformers
import io.reactivex.disposables.CompositeDisposable
import org.koin.dsl.module

/**
 * Core module
 */
val coreModule = module {
    single { CompositeDisposable() } // TODO scopes
    single<IRxSchedulers> { RxSchedulers() }
    single<IRxTransformers> { RxTransformers(get())}
    single { RxDisposables(get()) }
}


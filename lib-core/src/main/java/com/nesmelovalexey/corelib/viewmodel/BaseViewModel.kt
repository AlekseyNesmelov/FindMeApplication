package com.nesmelovalexey.corelib.viewmodel

import androidx.lifecycle.ViewModel
import com.nesmelovalexey.corelib.rx.disposables.RxDisposables

open class BaseViewModel(private val rxDisposables: RxDisposables): ViewModel() {

    override fun onCleared() {
        rxDisposables.container.dispose()
    }
}
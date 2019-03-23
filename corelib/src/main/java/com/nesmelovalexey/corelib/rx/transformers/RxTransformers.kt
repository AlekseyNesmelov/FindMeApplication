package com.nesmelovalexey.corelib.rx.transformers

import com.nesmelovalexey.corelib.rx.schedullers.IRxSchedulers
import io.reactivex.CompletableTransformer

class RxTransformers(private val rxSchedulers: IRxSchedulers): IRxTransformers{

    override fun ioToMain(): CompletableTransformer = CompletableTransformer {
            it.subscribeOn(rxSchedulers.io())
                .observeOn(rxSchedulers.mainThread())
    }

    override fun computationToMain(): CompletableTransformer = CompletableTransformer {
        it.subscribeOn(rxSchedulers.computation())
            .observeOn(rxSchedulers.mainThread())
    }
}
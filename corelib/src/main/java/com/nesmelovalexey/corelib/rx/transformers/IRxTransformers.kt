package com.nesmelovalexey.corelib.rx.transformers

import io.reactivex.CompletableTransformer

interface IRxTransformers {

    fun ioToMain(): CompletableTransformer

    fun computationToMain(): CompletableTransformer
}
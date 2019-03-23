package com.nesmelovalexey.corelib.rx.schedullers

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * Rx schedulers class, that returns standard scheduler instances.
 *
 * @author Alexey Nesmelov
 */
class RxSchedulers: IRxSchedulers{

    override fun mainThread(): Scheduler = AndroidSchedulers.mainThread()

    override fun io(): Scheduler = Schedulers.io()

    override fun computation(): Scheduler = Schedulers.computation()
}
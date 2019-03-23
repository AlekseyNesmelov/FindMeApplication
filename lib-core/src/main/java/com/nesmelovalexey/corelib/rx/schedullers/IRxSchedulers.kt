package com.nesmelovalexey.corelib.rx.schedullers

import io.reactivex.Scheduler

/**
 * Rx schedulers class, that returns standard scheduler instances.
 *
 * @author Alexey Nesmelov
 */
interface IRxSchedulers {

    fun mainThread() : Scheduler

    fun io() : Scheduler

    fun computation() : Scheduler
}
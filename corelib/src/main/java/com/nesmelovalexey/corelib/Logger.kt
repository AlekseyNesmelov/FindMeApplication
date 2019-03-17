package com.nesmelovalexey.corelib

import android.util.Log

// TODO complete this class
class Logger {
    companion object {
        fun d(tag: String? = null, message: String? = null, throwable: Throwable? = null) = Log.d(tag, message, throwable)
    }
}
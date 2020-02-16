package com.ianmedeiros.coremodule.extensions

import android.util.Log

@Suppress("unused")
inline fun <reified T : Any> T.logd(msg: () -> String) {
    Log.d(T::class.qualifiedName, msg())
}
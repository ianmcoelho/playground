package com.ianmedeiros.coremodule.di

import android.content.Context
import androidx.fragment.app.Fragment

interface CompositionRoot<T : Any> {
    val root: T
}

inline fun <reified T : Any> Context.getApplicationRoot(): T {
    return (applicationContext as CompositionRoot<*>).root as T
}

inline fun <reified T : Any> Fragment.getPresentationRoot(): T = (activity as CompositionRoot<*>).root as T
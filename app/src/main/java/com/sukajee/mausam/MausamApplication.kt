package com.sukajee.mausam

import android.app.Application
import com.sukajee.mausam.di.AppComponent
import com.sukajee.mausam.di.DaggerAppComponent

class MausamApplication: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}
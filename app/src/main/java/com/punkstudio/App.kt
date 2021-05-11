package com.punkstudio

import android.app.Application
import com.punkstudio.notes.AutoService
import com.rm.lib.daemon.util.DaemonHelper

/**
 * Date:2020/12/29-5:23 PM
 * @author Mason
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        DaemonHelper.init(applicationContext, AutoService::class.java)
    }
}
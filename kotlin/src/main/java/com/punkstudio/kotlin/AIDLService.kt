package com.punkstudio.kotlin

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.util.Log
import com.punkstudio.kotlin.binder.RequestBinder

/**
 * Date:2021/5/7-2:15 PM
 * @author Mason
 */
class AIDLService : Service() {

    private var count: Int = 0
    private val requestBinder by lazy {
        RequestBinder()
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("AIDLService", "onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("AIDLService", "onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    private fun startHandler() {
        Handler().postDelayed({
            val index = requestBinder.responseList.beginBroadcast()
            for (i in 0 until index) {
                requestBinder.responseList.getBroadcastItem(i).onProcess(count)
            }
            requestBinder.responseList.finishBroadcast()
            count ++
        }, 20000)
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.i("AIDLService", "onBind")
        startHandler()
        return requestBinder
    }

}
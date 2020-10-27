package com.punkstudio.basic.activity

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("@M-", "onStartCommand")
        val actIntent = Intent(this, Activity1::class.java)
        // todo 因为service本身没有task stack，所以需要新开辟一个task stack用于存放activity，
        //  当系统检测到已经有task stack并且新启动的activity的taskAffinity和当前task stack一致时，则不会创建新的
        actIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(actIntent)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("@M-", "onCreate")
    }
}
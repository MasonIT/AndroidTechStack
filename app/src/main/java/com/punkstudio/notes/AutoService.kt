package com.punkstudio.notes

import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import com.rm.lib.daemon.service.AbsWorkService

/**
 * Date:2020/12/29-5:12 PM
 * @author Mason
 */
class AutoService : AbsWorkService()  {
    private var isWorkRunning = false

    override fun onBind(intent: Intent?, alwaysNull: Void?): IBinder? {
        Toast.makeText(this, "onBind", Toast.LENGTH_SHORT).show()
        return null
    }

    override fun shouldStopService(intent: Intent?, flags: Int, startId: Int): Boolean {
        Toast.makeText(this, "shouldStopService", Toast.LENGTH_SHORT).show()
        return false
    }

    override fun startWork(intent: Intent?, flags: Int, startId: Int) {
        isWorkRunning = true
        Toast.makeText(this, "startWork", Toast.LENGTH_SHORT).show()
    }

    override fun stopWork(intent: Intent?, flags: Int, startId: Int) {
        isWorkRunning = false
        Toast.makeText(this, "stopWork", Toast.LENGTH_SHORT).show()
    }

    override fun isWorkRunning(intent: Intent?, flags: Int, startId: Int): Boolean {
        Toast.makeText(this, "isWorkRunning", Toast.LENGTH_SHORT).show()
        return isWorkRunning
    }

    override fun onServiceKilled(rootIntent: Intent?) {
        Toast.makeText(this, "onServiceKilled", Toast.LENGTH_SHORT).show()
    }
}
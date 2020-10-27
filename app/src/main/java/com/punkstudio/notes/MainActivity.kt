package com.punkstudio.notes

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.punkstudio.basic.activity.Activity1
import com.punkstudio.basic.activity.BaseActivity
import com.punkstudio.basic.activity.MyService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(tag, taskId.toString())
        activity.setOnClickListener {
            startActivity(Intent(this, Activity1::class.java))
        }

        service.setOnClickListener {
            startService(Intent(this, MyService::class.java))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}
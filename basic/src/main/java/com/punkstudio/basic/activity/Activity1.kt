package com.punkstudio.basic.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.punkstudio.basic.R
import kotlinx.android.synthetic.main.activity1_layout.*

/**
 * Date:2020/10/21-2:40 PM
 * @author Mason
 */
class Activity1 : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag, "onCreate ${savedInstanceState?.getString("WOW", "fail")}")
        Log.d(tag, taskId.toString())
        setContentView(R.layout.activity1_layout)
        btnJump1.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
//            startActivity(intent)
            startActivityForResult(intent, 2)
        }

        implicitJump1.setOnClickListener {
            val intent = Intent("com.punkstudio.basic.activity4")
            intent.addCategory("com.punkstudio.basic.activity4.category")
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("WOW", "OH")
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(tag, "onRestoreInstanceState ${savedInstanceState.getString("WOW", "fail")}")
        super.onRestoreInstanceState(savedInstanceState)
    }
}
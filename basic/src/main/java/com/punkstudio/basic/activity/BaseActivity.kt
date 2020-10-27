package com.punkstudio.basic.activity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

/**
 * Date:2020/10/21-2:34 PM
 * @author Mason
 */
abstract class BaseActivity : AppCompatActivity() {

    protected val tag: String = "@M-${this.javaClass.simpleName}"
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(tag, "onCreate(savedInstanceState: Bundle?)")
        super.onCreate(savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        Log.d(tag, "onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?)")
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onStart() {
        Log.d(tag, "onStart()")
        super.onStart()
    }

    override fun onResume() {
        Log.d(tag, "onResume()")
        super.onResume()
    }

    override fun onPause() {
        Log.d(tag, "onPause()")
        super.onPause()
    }

    override fun onStop() {
        Log.d(tag, "onStop()")
        super.onStop()
    }

    override fun onRestart() {
        Log.d(tag, "onRestart()")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d(tag, "onDestroy()")
        super.onDestroy()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d(tag, "onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(tag, "onSaveInstanceState(outState: Bundle)")
        super.onSaveInstanceState(outState)
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        Log.d(tag, "onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle)")
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(tag, "onRestoreInstanceState(savedInstanceState: Bundle)")
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        Log.d(tag, "onRestoreInstanceState(savedInstanceState: Bundle?, persistentState: PersistableBundle?)")
        super.onRestoreInstanceState(savedInstanceState, persistentState)
    }
}
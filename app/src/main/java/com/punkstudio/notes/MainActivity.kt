package com.punkstudio.notes

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import com.punkstudio.aidl.ICommonRequest
import com.punkstudio.aidl.ICommonResponse
import com.punkstudio.basic.activity.BaseActivity
import com.punkstudio.basic.activity.MyService
import com.punkstudio.kotlin.AIDLService
import com.punkstudio.ui.ViewActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {
    var commonRequest: ICommonRequest? = null
    var response = Response()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(tag, taskId.toString())
        activity.setOnClickListener {
//            startActivity(Intent(this, Activity1::class.java))
            Log.i("MainActivity", "${commonRequest?.user}")
        }

        service.setOnClickListener {
            startService(Intent(this, MyService::class.java))
        }

        view.setOnClickListener {
            startActivity(Intent(this, ViewActivity::class.java))
        }

        ui.setOnClickListener {
//            startActivity(Intent(this, CollapsingLayoutActivity::class.java))
            val intent = Intent(this, AIDLService::class.java)
//            intent.action = "com.punkstudio.kotlin.AIDLService.BINDER"
//            intent.setPackage("com.punkstudio.kotlin")
            bindService(intent, Connection(), Context.BIND_AUTO_CREATE)
//            bindService(this)
        }


    }

    private fun bindService(context: Context) {
        val serviceIntent = Intent("com.punkstudio.kotlin.AIDLService.BINDER")
        val componentIntent: Intent = createExplicitFromImplicitIntent(context, serviceIntent)
        val intent = Intent(componentIntent)
        context.bindService(intent, Connection(), BIND_AUTO_CREATE)
    }


    private fun createExplicitFromImplicitIntent(
        context: Context,
        implicitIntent: Intent
    ): Intent {
        // Retrieve all services that can match the given intent
        val pm = context.packageManager
        val resolveInfo = pm.queryIntentServices(implicitIntent, 0)
        // Get component info and create ComponentName
        val serviceInfo = resolveInfo[0]
        val packageName = serviceInfo.serviceInfo.packageName
        val className = serviceInfo.serviceInfo.name
        val component = ComponentName(packageName, className)

        // Create a new intent. Use the old one for extras and such reuse
        val explicitIntent = Intent(implicitIntent)

        // Set the component to be explicit
        explicitIntent.component = component
        explicitIntent.action = "com.punkstudio.kotlin.AIDLService.BINDER"
        return explicitIntent
    }





    inner class Connection : ServiceConnection {

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            commonRequest = ICommonRequest.Stub.asInterface(service)
            commonRequest?.registerListener(response)
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            commonRequest?.unregisterListener(response)
        }
    }

    inner class Response : ICommonResponse.Stub() {
        override fun onProcess(position: Int) {
            Log.i("MainActivity", "position=$position")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}
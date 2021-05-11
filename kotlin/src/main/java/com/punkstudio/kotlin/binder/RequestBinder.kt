package com.punkstudio.kotlin.binder

import android.os.RemoteCallbackList
import com.punkstudio.aidl.ICommonRequest
import com.punkstudio.aidl.ICommonResponse
import com.punkstudio.aidl.bean.User

/**
 * Date:2021/5/7-2:16 PM
 * @author Mason
 */
class RequestBinder : ICommonRequest.Stub() {

    val responseList = RemoteCallbackList<ICommonResponse>()

    override fun registerListener(commonResponse: ICommonResponse?) {
        responseList.register(commonResponse)
    }

    override fun unregisterListener(commonResponse: ICommonResponse?) {
        responseList.unregister(commonResponse)
    }

    override fun getUser(): User {
        val user = User()
        user.name = "Mason"
        user.age = 22
        return user
    }
}
// ICommonRequest.aidl
package com.punkstudio.aidl;
import com.punkstudio.aidl.ICommonResponse;
import com.punkstudio.aidl.bean.User;

// Declare any non-default types here with import statements

interface ICommonRequest {

    void registerListener(ICommonResponse commonResponse);

    void unregisterListener(ICommonResponse commonResponse);

    User getUser();
}
package com.rm.lib.daemon.util;

import android.content.Context;

import com.rm.lib.daemon.service.AbsWorkService;

/**
 * @Author: 王东升
 * @CreatedDate: 2019/3/25
 * @Version: 1.0
 */
public class DaemonHelper {
    public static Context mContext;
    public DaemonHelper(){

    }
    public static void init(Context context,Class<? extends AbsWorkService> serviceClass){
        mContext=context;
        //需要在 Application 的 onCreate() 中调用一次 DaemonEnv.initialize() 保活
        DaemonEnv.initialize(context, serviceClass, DaemonEnv.DEFAULT_WAKE_UP_INTERVAL);
        DaemonEnv.startServiceMayBind(serviceClass);
    }
}

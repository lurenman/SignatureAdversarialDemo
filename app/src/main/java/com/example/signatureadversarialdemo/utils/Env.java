package com.example.signatureadversarialdemo.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/**
 * 创建日期：2024-04-16
 * 作者:baiyang
 */
public class Env {
    public static boolean isApkInDebug(Context context) {
        try {
            ApplicationInfo info = context.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            return false;
        }
    }
}

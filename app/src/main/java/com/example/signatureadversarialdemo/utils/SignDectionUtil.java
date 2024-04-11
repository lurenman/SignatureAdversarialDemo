package com.example.signatureadversarialdemo.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;

/**
 * 创建日期：2024-04-11
 * 作者:baiyang
 */
public class SignDectionUtil {
    private static final String TAG = "SignDectionUtil";

    public static boolean checkMd5(Context context) {
        boolean result = false;
        if (context == null) {
            return false;
        }
        String signMd5 = getSign(context, context.getPackageName());
        if ("c07c70e96c657ea124cc473a4b2c6bfa".equals(signMd5)) {
            result = true;
        }
        Log.d(TAG, "checkMd5 signMd5: " + signMd5);
        return result;
    }

    /**
     * 获取包名对应应用的签名信息
     */
    public static String getSign(Context context, String packageName) {
        String S = "";
        try {
            byte[] array = null;

            PackageInfo localPackageInfo = context.getPackageManager().getPackageInfo(packageName, 64);

            for (int i = 0; i < localPackageInfo.signatures.length; i++) {
                array = localPackageInfo.signatures[i].toByteArray();
                if (array != null) break;
            }
            S = Md5Util.MD5(array);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return S;
    }
}

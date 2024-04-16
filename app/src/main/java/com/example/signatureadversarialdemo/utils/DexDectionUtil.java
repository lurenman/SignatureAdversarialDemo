package com.example.signatureadversarialdemo.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.example.signatureadversarialdemo.R;

import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * 创建日期：2024-04-16
 * 作者:baiyang
 */
public class DexDectionUtil {
    private static final String TAG = "DexDectioUtil";

    public static boolean checkCRC(Context context) {
        boolean result = false;
        String orginalCrc = "";
        if (Env.isApkInDebug(context)) {
            orginalCrc = context.getString(R.string.str_code_debug);
        } else {
            orginalCrc = context.getString(R.string.str_code_release);
        }
        if (TextUtils.isEmpty(orginalCrc))
            return result;
        ZipFile zf;
        try {
            zf = new ZipFile(context.getApplicationContext().getPackageCodePath());
            ZipEntry ze = zf.getEntry("classes.dex");
            String strCrc = String.valueOf(ze.getCrc());
            String MD5Crc = Md5Util.MD5(strCrc);
            Log.d(TAG, "checkCRC MD5Crc: " + MD5Crc);
            if (!orginalCrc.equals(MD5Crc)) {
                //ActivityManagerUtil.getScreenManager().removeAllActivity();
                // Process.killProcess(Process.myPid());
                Log.d(TAG, "checkCRC 重打包了");
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

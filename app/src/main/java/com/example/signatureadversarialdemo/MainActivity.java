package com.example.signatureadversarialdemo;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.signatureadversarialdemo.databinding.ActivityMainBinding;
import com.example.signatureadversarialdemo.utils.DexDectionUtil;
import com.example.signatureadversarialdemo.utils.SignDectionUtil;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private Context mContext;

    // Used to load the 'signatureadversarialdemo' library on application startup.
    static {
        System.loadLibrary("signatureadversarialdemo");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initEvent();
    }

    /**
     * A native method that is implemented by the 'signatureadversarialdemo' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    private void initEvent() {
        binding.btnMd5Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = SignDectionUtil.checkMd5(mContext);
                Toast.makeText(mContext, "md5检测通过:" + result, Toast.LENGTH_SHORT).show();
            }
        });
        binding.btnCrcCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checkCRC = DexDectionUtil.checkCRC(mContext);
                Toast.makeText(mContext, "Crc检测是否重打包:" + checkCRC, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
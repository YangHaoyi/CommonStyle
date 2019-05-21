package com.autoai.commonaar;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.autoai.commonstylelibrary.view.dialog.CommonDialog;
import com.autoai.commonstylelibrary.view.dialog.LoadingDialog;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.tvStart);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadingDialog.getInstance().show(getSupportFragmentManager(),"Loading");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        LoadingDialog.getInstance().dismiss();
                    }
                },1000);
            }
        });


    }
}

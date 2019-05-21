package com.autoai.commonstylelibrary.view.dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;

import com.autoai.commonstylelibrary.R;

/**
 * @author : YangHaoYi on  2019/5/2115:59.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on  2019/5/2115:59.
 * Version : V 1.0
 */
public class LoadingDialog extends DialogFragment {

    private static LoadingDialog instance;
    protected View dialog;
    protected LayoutInflater inflater;
    private FrameLayout room;
    private View content;


    public static LoadingDialog getInstance(){
        if(null==instance){
            instance = new LoadingDialog();
        }
        return instance;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.Theme_Dialog);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflater = inflater;
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog = inflater.inflate(R.layout.pop_layer,container,false);
        init();
        return dialog;
    }

    private void init(){
        initDialog();
    }

    /** 初始化View */
    private void initDialog(){
        room = dialog.findViewById(R.id.room);
        content = inflater.inflate(R.layout.dialog_loading, null);
        FrameLayout.LayoutParams layoutParam = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT);
        layoutParam.gravity = Gravity.CENTER;
        room.addView(content,layoutParam);
    }


}

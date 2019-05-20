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
import android.widget.TextView;

import com.autoai.commonstylelibrary.R;
import com.autoai.commonstylelibrary.model.util.JudgeNullUtil;
import com.autoai.commonstylelibrary.presenter.util.ScreenUtil;

/**
 * @author : YangHaoYi on  2019/4/2610:40.
 * Email  :  yang.haoyi@qq.com
 * Description :通用样式Dialog
 * Change : YangHaoYi on  2019/4/2610:40.
 * Version : V 1.0
 */
public class CommonDialog extends DialogFragment implements View.OnClickListener {

    protected View dialog;
    protected LayoutInflater inflater;
    private FrameLayout room;

    private View content;
    private TextView tvNotice;
    private TextView tvSure;
    private TextView tvCancel;

    private String notice = "";

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
        initView();
        initData();
        initEvent();
    }

    /** 初始化View */
    private void initDialog(){
        room = dialog.findViewById(R.id.room);
        content = inflater.inflate(configResourceId(), null);
        int dialogWidth = 0;
        if(JudgeNullUtil.isObjectNotNull(ScreenUtil.getScreenResolution(getContext()).get(ScreenUtil.SCREEN_WIDTH))){
            dialogWidth = (int) (ScreenUtil.getScreenResolution(getContext()).get(ScreenUtil.SCREEN_WIDTH)*0.7);
        }
        FrameLayout.LayoutParams layoutParam = new FrameLayout.LayoutParams(dialogWidth,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        layoutParam.gravity = Gravity.CENTER;
        room.addView(content,layoutParam);
    }

    protected void initView(){
        tvNotice = content.findViewById(R.id.tvNotice);
        tvSure = content.findViewById(R.id.tvSure);
        tvCancel = content.findViewById(R.id.tvCancel);
    }

    protected void initData(){
        tvNotice.setText(notice);
    }

    protected void initEvent(){
        tvSure.setOnClickListener(this);
        tvCancel.setOnClickListener(this);
    }

    protected int configResourceId(){
        return R.layout.dialog_common_style;
    }


    public CommonDialog setNotice(String notice){
        this.notice = notice;
        return this;
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.tvSure){
            dismiss();
        }else if(v.getId()==R.id.tvCancel){
            dismiss();
        }
    }
}

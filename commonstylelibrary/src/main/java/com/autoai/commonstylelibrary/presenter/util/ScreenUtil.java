package com.autoai.commonstylelibrary.presenter.util;

import android.content.Context;
import android.util.DisplayMetrics;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : YangHaoYi on  2019/4/2610:58.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on  2019/4/2610:58.
 * Version : V 1.0
 */
public class ScreenUtil {

    public static final String SCREEN_WIDTH = "width";
    public static final String SCREEN_HEIGHT = "height";


    public static Map<String,Integer> getScreenResolution(Context context) {
        Map<String, Integer> map = new HashMap<>();
        try {
            DisplayMetrics dm = context.getResources().getDisplayMetrics();
            int screenHeight = dm.heightPixels;
            int screenWidth = dm.widthPixels;
            map.put(SCREEN_WIDTH, screenWidth);
            map.put(SCREEN_HEIGHT, screenHeight);
            return map;
        } catch (Exception e) {
            map.put(SCREEN_WIDTH, 0);
            map.put(SCREEN_HEIGHT, 0);
            return map;
        }
    }

}

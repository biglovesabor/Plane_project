package com.jiuhong.plane.ui.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.FileProvider;

import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.google.gson.Gson;
import com.hjq.base.BaseDialog;
import com.hjq.http.EasyHttp;
import com.hjq.http.listener.HttpCallback;
import com.hjq.toast.ToastUtils;
import com.hjq.widget.layout.SettingBar;
import com.jiuhong.plane.R;
import com.jiuhong.plane.app.TitleBarFragment;
import com.jiuhong.plane.ui.activity.HomeActivity;
import com.jiuhong.plane.ui.activity.testActivity;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import okhttp3.Call;

import static android.app.Activity.RESULT_OK;

/**
 * author : Android 轮子哥
 * github : https://github.com/getActivity/AndroidProject
 * time   : 2018/10/18
 * desc   : 可进行拷贝的副本
 */
public final class MyFragment1 extends TitleBarFragment<HomeActivity> {
    private ImageView mAvatarView;
    private LinearLayout mAvatarLayout;

    /**
     * 头像地址
     */
    private String mAvatarUrl;
    private SettingBar tv_wddd;
    private SettingBar tv_bdcl;
    private SettingBar tv_tcdl;

    private TextView tv_phone;
    private TextView tv_name;


    private String driverid;
    private String types="";
    //是否审核通过
    private Boolean isshtg= false;
    private LinearLayout ll_exit;

    public static MyFragment1 newInstance() {
        return new MyFragment1();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.my_fragment1;
    }


    @Override
    protected void initView() {
TextView tv_text1=findViewById(R.id.tv_text1);
        tv_text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), testActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }


    @Override
    protected void initData() {
//        GlideApp.with(getActivity())
//                .load(R.mipmap.logo1)
//                .placeholder(R.mipmap.logo1)
//                .error(R.mipmap.logo1)
//                .circleCrop()
//                .transform(new MultiTransformation<>(new CenterCrop(), new CircleCrop()))
//                .into(mAvatarView);



    }

    @Override
    public void onResume() {
        super.onResume();

    }





    @Override
    public boolean isStatusBarEnabled() {
        // 使用沉浸式状态栏
        return !super.isStatusBarEnabled();
    }


}
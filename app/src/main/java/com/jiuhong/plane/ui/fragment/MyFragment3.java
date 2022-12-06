package com.jiuhong.plane.ui.fragment;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hjq.widget.layout.SettingBar;
import com.jiuhong.plane.R;
import com.jiuhong.plane.app.TitleBarFragment;
import com.jiuhong.plane.ui.activity.HomeActivity;

/**
 * author : Android 轮子哥
 * github : https://github.com/getActivity/AndroidProject
 * time   : 2018/10/18
 * desc   : 可进行拷贝的副本
 */
public final class MyFragment3 extends TitleBarFragment<HomeActivity> {
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

    public static MyFragment3 newInstance() {
        return new MyFragment3();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.my_fragment3;
    }


    @Override
    protected void initView() {



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
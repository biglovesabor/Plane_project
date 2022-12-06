package com.jiuhong.plane.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.hjq.base.BaseDialog;
import com.hjq.base.FragmentPagerAdapter;
import com.hjq.http.EasyHttp;
import com.hjq.http.listener.HttpCallback;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
import com.hjq.toast.ToastUtils;
import com.jiuhong.plane.R;
import com.jiuhong.plane.app.AppActivity;
import com.jiuhong.plane.app.AppFragment;
import com.jiuhong.plane.http.response.LoginBean1;
import com.jiuhong.plane.manager.ActivityManager;
import com.jiuhong.plane.other.DoubleClickHelper;
import com.jiuhong.plane.other.IntentKey;
import com.jiuhong.plane.other.PermissionCallback;
import com.jiuhong.plane.ui.fragment.HomeFragment;
import com.jiuhong.plane.ui.fragment.MyFragment1;
import com.jiuhong.plane.ui.fragment.MyFragment2;
import com.jiuhong.plane.ui.fragment.MyFragment3;
import com.jiuhong.plane.ui.fragment.MyFragment4;
import com.jiuhong.plane.utils.SPUtils;


import java.util.List;

import okhttp3.Call;

/**
 * author : Android 轮子哥
 * github : https://github.com/getActivity/AndroidProject
 * time   : 2018/10/18
 * desc   : 首页界面
 */
public final class MyHomeActivity extends AppActivity {


    private ViewPager mViewPager;
    private BottomNavigationView mBottomNavigationView;

    private FragmentPagerAdapter<AppFragment<?>> mPagerAdapter;

    private LoginBean1 userbean;
    private LinearLayout ll_view1;
    private LinearLayout ll_view2;
    private TextView tv_view20;
    private TextView tv_view21;
    private LinearLayout ll_view3;
    private TextView tv_view30;
    private TextView tv_view31;
    private LinearLayout ll_view4;
    private TextView tv_view40;
    private TextView tv_view41;
    private LinearLayout ll_view5;
    private TextView tv_view50;
    private TextView tv_view51;

    public static void start(Context context) {
        start(context, HomeFragment.class);
    }

    public static void start(Context context, Class<? extends AppFragment<?>> fragmentClass) {
        Intent intent = new Intent(context, MyHomeActivity.class);
        intent.putExtra(IntentKey.INDEX, fragmentClass);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.myhome_activity;
    }

    @Override
    protected void initView() {


        mViewPager = findViewById(R.id.vp_home_pager);
        String type = getIntent().getStringExtra("type");
        if (type.equals("1")){
            mViewPager.setCurrentItem(0);
        }else if (type.equals("2")){
            mViewPager.setCurrentItem(1);
        }else if (type.equals("3")){
            mViewPager.setCurrentItem(2);
        }else if (type.equals("4")){
            mViewPager.setCurrentItem(3);
        }


        ll_view1 = findViewById(R.id.ll_view1);
        ll_view2 = findViewById(R.id.ll_view2);
        tv_view20 = findViewById(R.id.tv_view20);
        tv_view21 = findViewById(R.id.tv_view21);

        ll_view3 = findViewById(R.id.ll_view3);
        tv_view30 = findViewById(R.id.tv_view30);
        tv_view31 = findViewById(R.id.tv_view31);
        ll_view4 = findViewById(R.id.ll_view4);
        tv_view40 = findViewById(R.id.tv_view40);
        tv_view41 = findViewById(R.id.tv_view41);
        ll_view5 = findViewById(R.id.ll_view5);
        tv_view50 = findViewById(R.id.tv_view50);
        tv_view51 = findViewById(R.id.tv_view51);

        setOnClickListener(ll_view1, ll_view2,ll_view3,ll_view4,ll_view5);

        ll_view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ll_view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tv_view20.setTextColor(getResources().getColor(R.color.home_text_color));
                tv_view30.setTextColor(getResources().getColor(R.color.moren_text));
                tv_view40.setTextColor(getResources().getColor(R.color.moren_text));
                tv_view50.setTextColor(getResources().getColor(R.color.moren_text));
                tv_view21.setVisibility(View.VISIBLE);
                tv_view31.setVisibility(View.INVISIBLE);
                tv_view41.setVisibility(View.INVISIBLE);
                tv_view51.setVisibility(View.INVISIBLE);
                mViewPager.setCurrentItem(0);

            }
        });
        ll_view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tv_view30.setTextColor(getResources().getColor(R.color.home_text_color));
                tv_view20.setTextColor(getResources().getColor(R.color.moren_text));
                tv_view40.setTextColor(getResources().getColor(R.color.moren_text));
                tv_view50.setTextColor(getResources().getColor(R.color.moren_text));
                tv_view31.setVisibility(View.VISIBLE);
                tv_view21.setVisibility(View.INVISIBLE);
                tv_view41.setVisibility(View.INVISIBLE);
                tv_view51.setVisibility(View.INVISIBLE);
                mViewPager.setCurrentItem(1);

            }
        });
        ll_view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tv_view40.setTextColor(getResources().getColor(R.color.home_text_color));
                tv_view30.setTextColor(getResources().getColor(R.color.moren_text));
                tv_view20.setTextColor(getResources().getColor(R.color.moren_text));
                tv_view50.setTextColor(getResources().getColor(R.color.moren_text));
                tv_view41.setVisibility(View.VISIBLE);
                tv_view31.setVisibility(View.INVISIBLE);
                tv_view21.setVisibility(View.INVISIBLE);
                tv_view51.setVisibility(View.INVISIBLE);
                mViewPager.setCurrentItem(2);

            }
        });
        ll_view5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tv_view50.setTextColor(getResources().getColor(R.color.home_text_color));
                tv_view30.setTextColor(getResources().getColor(R.color.moren_text));
                tv_view40.setTextColor(getResources().getColor(R.color.moren_text));
                tv_view20.setTextColor(getResources().getColor(R.color.moren_text));
                tv_view51.setVisibility(View.VISIBLE);
                tv_view31.setVisibility(View.INVISIBLE);
                tv_view41.setVisibility(View.INVISIBLE);
                tv_view21.setVisibility(View.INVISIBLE);
                mViewPager.setCurrentItem(3);

            }
        });


//        if (isLogin()) {
            //取出登录成功 返回的值
//            userbean = new Gson().fromJson(SPUtils.getString("ZXGuserbean", ""), LoginBean1.class);
//        }
    }

    @Override
    protected void initData() {
        mPagerAdapter = new FragmentPagerAdapter<>(this);
//        mPagerAdapter.addFragment(HomeFragment2.newInstance());
        mPagerAdapter.addFragment(MyFragment1.newInstance());
        mPagerAdapter.addFragment(MyFragment2.newInstance());
        mPagerAdapter.addFragment(MyFragment3.newInstance());
        mPagerAdapter.addFragment(MyFragment4.newInstance());
        mViewPager.setAdapter(mPagerAdapter);

        onNewIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        int fragmentIndex = mPagerAdapter.getFragmentIndex(getSerializable(IntentKey.INDEX));
        if (fragmentIndex == -1) {
            return;
        }

        mViewPager.setCurrentItem(fragmentIndex);
    }


    @Override
    public void onBackPressed() {
        if (!DoubleClickHelper.isOnDoubleClick()) {
            toast(R.string.home_exit_hint);
            return;
        }

        // 移动到上一个任务栈，避免侧滑引起的不良反应
        moveTaskToBack(false);
        postDelayed(() -> {
            // 进行内存优化，销毁掉所有的界面
            ActivityManager.getInstance().finishAllActivities();
            // 销毁进程（注意：调用此 API 可能导致当前 Activity onDestroy 方法无法正常回调）
            // System.exit(0);
        }, 300);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewPager.setAdapter(null);
//        mBottomNavigationView.setOnNavigationItemSelectedListener(null);
    }



}

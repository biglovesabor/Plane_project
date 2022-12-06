package com.jiuhong.plane.ui.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.jiuhong.plane.R;
import com.jiuhong.plane.aop.DebugLog;
import com.jiuhong.plane.aop.SingleClick;
import com.jiuhong.plane.app.AppActivity;
import com.jiuhong.plane.http.glide.GlideApp;
import com.jiuhong.plane.http.model.HttpData;
import com.jiuhong.plane.http.request.LoginApi;
import com.jiuhong.plane.http.response.LoginBean;
import com.jiuhong.plane.manager.InputTextManager;
import com.jiuhong.plane.other.IntentKey;
import com.jiuhong.plane.other.KeyboardWatcher;
import com.jiuhong.plane.ui.fragment.MeFragment;
//import com.jiuhong.plane.wxapi.WXEntryActivity;
import com.hjq.http.EasyConfig;
import com.hjq.http.EasyHttp;
import com.hjq.http.listener.HttpCallback;
//import com.hjq.umeng.Platform;
//import com.hjq.umeng.UmengClient;
//import com.hjq.umeng.UmengLogin;
import com.hjq.widget.view.SubmitButton;

import okhttp3.Call;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/AndroidProject
 *    time   : 2018/10/18
 *    desc   : 登录界面
 */
public final class LoginActivity extends AppActivity
        implements KeyboardWatcher.SoftKeyboardStateListener,
        TextView.OnEditorActionListener {

    @DebugLog
    public static void start(Context context, String phone, String password) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra(IntentKey.PHONE, phone);
        intent.putExtra(IntentKey.PASSWORD, password);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }

    private ImageView mLogoView;

    private ViewGroup mBodyLayout;
    private EditText mPhoneView;
    private EditText mPasswordView;

    private View mForgetView;
    private SubmitButton mCommitView;

    private View mOtherView;
    private View mQQView;
    private View mWeChatView;

    /** logo 缩放比例 */
    private final float mLogoScale = 0.8f;
    /** 动画时间 */
    private final int mAnimTime = 300;

    @Override
    protected int getLayoutId() {
        return R.layout.login_activity;
    }

    @Override
    protected void initView() {
        mLogoView = findViewById(R.id.iv_login_logo);
        mBodyLayout = findViewById(R.id.ll_login_body);
        mPhoneView = findViewById(R.id.et_login_phone);
        mPasswordView = findViewById(R.id.et_login_password);
        mForgetView = findViewById(R.id.tv_login_forget);
        mCommitView = findViewById(R.id.btn_login_commit);
        mOtherView = findViewById(R.id.ll_login_other);
        mQQView = findViewById(R.id.iv_login_qq);
        mWeChatView = findViewById(R.id.iv_login_wechat);

        setOnClickListener(mForgetView, mCommitView, mQQView, mWeChatView);

        mPasswordView.setOnEditorActionListener(this);

        InputTextManager.with(this)
                .addView(mPhoneView)
                .addView(mPasswordView)
                .setMain(mCommitView)
                .build();
    }

    @Override
    protected void initData() {
        postDelayed(() -> {
            KeyboardWatcher.with(LoginActivity.this)
                    .setListener(LoginActivity.this);
        }, 500);

//        // 判断用户当前有没有安装 QQ
//        if (!UmengClient.isAppInstalled(this, Platform.QQ)) {
//            mQQView.setVisibility(View.GONE);
//        }

//        // 判断用户当前有没有安装微信
//        if (!UmengClient.isAppInstalled(this, Platform.WECHAT)) {
//            mWeChatView.setVisibility(View.GONE);
//        }

        // 如果这两个都没有安装就隐藏提示
        if (mQQView.getVisibility() == View.GONE && mWeChatView.getVisibility() == View.GONE) {
            mOtherView.setVisibility(View.GONE);
        }

        // 自动填充手机号和密码
        mPhoneView.setText(getString(IntentKey.PHONE));
        mPasswordView.setText(getString(IntentKey.PASSWORD));
    }

    @Override
    public void onRightClick(View view) {
        // 跳转到注册界面
        RegisterActivity.start(this, mPhoneView.getText().toString(), mPasswordView.getText().toString(), (phone, password) -> {
            // 如果已经注册成功，就执行登录操作
            mPhoneView.setText(phone);
            mPasswordView.setText(password);
            mPasswordView.requestFocus();
            mPasswordView.setSelection(mPasswordView.getText().length());
            onClick(mCommitView);
        });
    }

    @SingleClick
    @Override
    public void onClick(View view) {
        if (view == mForgetView) {
            startActivity(PasswordForgetActivity.class);
            return;
        }

        if (view == mCommitView) {
            if (mPhoneView.getText().toString().length() != 11) {
                mPhoneView.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.shake_anim));
                mCommitView.showError(3000);
                toast(R.string.common_phone_input_error);
                return;
            }

            // 隐藏软键盘
            hideKeyboard(getCurrentFocus());

            if (true) {
                mCommitView.showProgress();
                postDelayed(() -> {
                    mCommitView.showSucceed();
                    postDelayed(() -> {
                        HomeActivity.start(getContext(), MeFragment.class);
                        finish();
                    }, 1000);
                }, 2000);
                return;
            }

            EasyHttp.post(this)
                    .api(new LoginApi()
                            .setPhone(mPhoneView.getText().toString())
                            .setPassword(mPasswordView.getText().toString()))
                    .request(new HttpCallback<HttpData<LoginBean>>(this) {

                        @Override
                        public void onStart(Call call) {
                            mCommitView.showProgress();
                        }

                        @Override
                        public void onEnd(Call call) {}

                        @Override
                        public void onSucceed(HttpData<LoginBean> data) {
                            // 更新 Token
                            EasyConfig.getInstance()
                                    .addParam("token", data.getData().getToken());
                            postDelayed(() -> {
                                mCommitView.showSucceed();
                                postDelayed(() -> {
                                    // 跳转到首页
                                    HomeActivity.start(getContext(), MeFragment.class);
                                    finish();
                                }, 1000);
                            }, 1000);
                        }

                        @Override
                        public void onFail(Exception e) {
                            super.onFail(e);
                            postDelayed(() -> {
                                mCommitView.showError(3000);
                            }, 1000);
                        }
                    });
            return;
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 友盟登录回调
//        UmengClient.onActivityResult(this, requestCode, resultCode, data);
    }



    /**
     * {@link KeyboardWatcher.SoftKeyboardStateListener}
     */

    @Override
    public void onSoftKeyboardOpened(int keyboardHeight) {
        // 执行位移动画
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mBodyLayout, "translationY", 0, -mCommitView.getHeight());
        objectAnimator.setDuration(mAnimTime);
        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator.start();

        // 执行缩小动画
        mLogoView.setPivotX(mLogoView.getWidth() / 2f);
        mLogoView.setPivotY(mLogoView.getHeight());
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(mLogoView, "scaleX", 1f, mLogoScale);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(mLogoView, "scaleY", 1f, mLogoScale);
        ObjectAnimator translationY = ObjectAnimator.ofFloat(mLogoView, "translationY", 0f, -mCommitView.getHeight());
        animatorSet.play(translationY).with(scaleX).with(scaleY);
        animatorSet.setDuration(mAnimTime);
        animatorSet.start();
    }

    @Override
    public void onSoftKeyboardClosed() {
        // 执行位移动画
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mBodyLayout, "translationY", mBodyLayout.getTranslationY(), 0f);
        objectAnimator.setDuration(mAnimTime);
        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator.start();

        if (mLogoView.getTranslationY() == 0) {
            return;
        }

        // 执行放大动画
        mLogoView.setPivotX(mLogoView.getWidth() / 2f);
        mLogoView.setPivotY(mLogoView.getHeight());
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(mLogoView, "scaleX", mLogoScale, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(mLogoView, "scaleY", mLogoScale, 1f);
        ObjectAnimator translationY = ObjectAnimator.ofFloat(mLogoView, "translationY", mLogoView.getTranslationY(), 0f);
        animatorSet.play(translationY).with(scaleX).with(scaleY);
        animatorSet.setDuration(mAnimTime);
        animatorSet.start();
    }

    /**
     * {@link TextView.OnEditorActionListener}
     */
    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE && mCommitView.isEnabled()) {
            // 模拟点击登录按钮
            onClick(mCommitView);
            return true;
        }
        return false;
    }
}
package com.jiuhong.plane.ui.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.hjq.http.EasyHttp;
import com.hjq.http.listener.HttpCallback;
import com.hjq.toast.ToastUtils;
import com.hjq.widget.view.CountdownView;
import com.hjq.widget.view.SubmitButton;
import com.jiuhong.plane.R;
import com.jiuhong.plane.aop.DebugLog;
import com.jiuhong.plane.aop.SingleClick;
import com.jiuhong.plane.app.AppActivity;
import com.jiuhong.plane.http.model.HttpData;
import com.jiuhong.plane.http.request.GetCodeApi;
import com.jiuhong.plane.http.response.UserInfoBean;
import com.jiuhong.plane.other.IntentKey;
import com.jiuhong.plane.other.KeyboardWatcher;
import com.jiuhong.plane.utils.SPUtils;


import okhttp3.Call;

/**
 * author : Android 轮子哥
 * github : https://github.com/getActivity/AndroidProject
 * time   : 2018/10/18
 * desc   : 登录界面
 */
public final class LoginActivity1 extends AppActivity
        implements KeyboardWatcher.SoftKeyboardStateListener,
        TextView.OnEditorActionListener {

    private CheckBox cb_check;
    private CountdownView tv_login_yzm;
    private TextView tv_login;

    @DebugLog
    public static void start(Context context, String phone, String password) {
        Intent intent = new Intent(context, LoginActivity1.class);
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
    private EditText et_login_yzm;

    private View mForgetView;
    private SubmitButton mCommitView;

    private View mOtherView;
    private View mQQView;
    private View mWeChatView;

    /**
     * logo 缩放比例
     */
    private final float mLogoScale = 0.8f;
    /**
     * 动画时间
     */
    private final int mAnimTime = 300;

    @Override
    protected int getLayoutId() {
        return R.layout.login_activity1;
    }

    @Override
    protected void initView() {
//        mCommitView=findViewById(R.id.btn_login_commit);
//        mPhoneView = findViewById(R.id.et_login_phone);
        tv_login = findViewById(R.id.tv_login);


//        if (isLogin()){
//            Log.e("dsadsa", "onAnimationEnd: ttrue" );
//            Intent intent = new Intent(getContext(), PlanHomeActivity.class);
//            startActivity(intent);
//        }else {
//        Log.e("dsadsa", "onAnimationEnd: false");
//        Intent intent = new Intent(getContext(), LoginActivity1.class);
//        startActivity(intent);

//        }


        setOnClickListener(tv_login);
        // 自动填充手机号和密码
//        mPhoneView.setText(getString(IntentKey.PHONE));
//        mPasswordView.setText(getString(IntentKey.PASSWORD));
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onRightClick(View view) {
        // 跳转到注册界面
        RegisterActivity.start(this, mPhoneView.getText().toString(), et_login_yzm.getText().toString(), (phone, password) -> {
            // 如果已经注册成功，就执行登录操作
            mPhoneView.setText(phone);
            et_login_yzm.setText(password);
            et_login_yzm.requestFocus();
            et_login_yzm.setSelection(et_login_yzm.getText().length());
//            onClick(mCommitView);
        });
    }

    @SingleClick
    @Override
    public void onClick(View view) {


        if (view == tv_login) {
            Intent intent = new Intent(getContext(), PlanHomeActivity.class);
            startActivity(intent);
            finish();
        }


//        if (view == mCommitView) {
//            if (mPhoneView.getText().toString().length() != 11) {
//                mPhoneView.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.shake_anim));
//                mCommitView.showError(3000);
//                toast(R.string.common_phone_input_error);
//                return;
//
//            }
//
//
//            if (TextUtils.isEmpty(tv_login_yzm.getText().toString().trim())) {
//                toast("请先填写验证码");
//                return;
//            }


        // 隐藏软键盘
//            hideKeyboard(getCurrentFocus());


//
//            EasyHttp.post(this)
//                    .api(new LoginApi1()
//                            .setPhonenumber(mPhoneView.getText().toString())
//                            .setRoleIds("1")
//                            .setAuthCode(et_login_yzm.getText().toString()))
//                    .request(new HttpCallback<HttpData<UserInfoBean>>(this) {
//
//                        @Override
//                        public void onStart(Call call) {
//                            mCommitView.showProgress();
//                        }
//
//                        @Override
//                        public void onEnd(Call call) {}
//
//                        @Override
//                        public void onSucceed(HttpData<UserInfoBean> data) {
//                            if (data!=null){
//                                if (data.getCode()==200){
//                                    String userbean = new Gson().toJson(data.getData());
//                                    Log.e("EasyHttp---userinfo", "onSucceed: "+ userbean);
//                                    SPUtils.putString("userbean", userbean);
//
//                                    postDelayed(() -> {
//                                mCommitView.showSucceed();
//                                postDelayed(() -> {
//                                    // 跳转到首页
//                                    Intent intent = new Intent(getContext(), PlanHomeActivity.class);
//                                    startActivity(intent);
//                                    finish();
//                                }, 1000);
//                            }, 1000);
//
//                                }else {
//                                    mCommitView.showError(3000);
//                                    ToastUtils.show(data.getMessage());
//                                }
//                            }else {
//                                ToastUtils.show("登录失败");
//                            }
//
//
//                        }
//
//                        @Override
//                        public void onFail(Exception e) {
//                            super.onFail(e);
//                            postDelayed(() -> {
//                                mCommitView.showError(3000);
//                            }, 1000);
//                        }
//                    });
//        }


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
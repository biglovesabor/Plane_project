package com.jiuhong.plane.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hjq.base.BaseDialog;
import com.jiuhong.dds.core.util.ActivityStackManager;
import com.jiuhong.plane.R;
import com.jiuhong.plane.aop.SingleClick;
import com.jiuhong.plane.app.AppActivity;
import com.jiuhong.plane.ui.dialog.MessageDialog;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/AndroidProject
 *    time   : 2018/10/18
 *    desc   : 项目首页
 */
public final class PlanHomeActivity extends AppActivity {

    private TextView tv_exit;
    private LinearLayout ll_home1;
    private LinearLayout ll_home2;
    private LinearLayout ll_home3;
    private LinearLayout ll_home4;
    private LinearLayout ll_home5;
    private LinearLayout ll_home6;

    @Override
    protected int getLayoutId() {
        return R.layout.planhome_activity;
    }

    @Override
    protected void initView() {

        tv_exit = findViewById(R.id.tv_exit);
         ll_home1 = findViewById(R.id.ll_home1);
         ll_home2 =findViewById(R.id.ll_home2);
         ll_home3 =findViewById(R.id.ll_home3);
         ll_home4 =findViewById(R.id.ll_home4);
         ll_home5 =findViewById(R.id.ll_home5);
         ll_home6 =findViewById(R.id.ll_home6);

        setOnClickListener(tv_exit, ll_home1,ll_home2,ll_home3,ll_home4,ll_home5,ll_home6);
    }

    @Override
    protected void initData() {

    }


    @SingleClick
    @Override
    public void onClick(View view) {


        if (view == tv_exit) {
            // 消息对话框
            new MessageDialog.Builder(getActivity())
                    // 标题可以不用填写
//                    .setTitle("")
                    // 内容必须要填写
                    .setMessage("是否确定退出系统")
                    // 确定按钮文本
                    .setConfirm(getString(R.string.common_confirm))
                    // 设置 null 表示不显示取消按钮
                    .setCancel(getString(R.string.common_cancel))
                    // 设置点击按钮后不关闭对话框
                    //.setAutoDismiss(false)
                    .setListener(new MessageDialog.OnListener() {

                        @Override
                        public void onConfirm(BaseDialog dialog) {
                            toast("确定了");
//                            SPUtils.remove("ZXGuserbean");

                            // 退出登录
                            startActivity(LoginActivity1.class);
                            // 进行内存优化，销毁掉所有的界面
                            ActivityStackManager.getInstance().finishAllActivities(LoginActivity1.class);
                        }

                        @Override
                        public void onCancel(BaseDialog dialog) {
                            toast("取消了");
                        }
                    })
                    .show();
        }else if (view == ll_home1) {

          Intent intent = new Intent(this,HomeGrid1Activity.class);
          startActivity(intent);

        }else if (view == ll_home2) {

          Intent intent = new Intent(this,HomeGrid2Activity.class);
          startActivity(intent);


        }else if (view == ll_home3) {

          Intent intent = new Intent(this,HomeGrid3Activity.class);
          startActivity(intent);

        }else if (view == ll_home4) {
          Intent intent = new Intent(this,HomeGrid4Activity.class);
          startActivity(intent);
        }
    }
}
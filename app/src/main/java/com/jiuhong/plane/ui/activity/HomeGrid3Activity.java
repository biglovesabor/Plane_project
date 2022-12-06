package com.jiuhong.plane.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiuhong.plane.R;
import com.jiuhong.plane.app.AppActivity;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/AndroidProject
 *    time   : 2018/10/18
 *    desc   : 远程协助   页面1
 */
public final class HomeGrid3Activity extends AppActivity {
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
    @Override
    protected int getLayoutId() {
        return R.layout.home_grid3_activity;
    }

    @Override
    protected void initView() {
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
                Intent intent = new Intent(getContext(),PlanHomeActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(0,0);
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


              //  finish();
                Intent intent = new Intent(getContext(), HomeGrid1Activity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(0,0);
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
                Intent intent = new Intent(getContext(),HomeGrid2Activity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(0,0);
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
                Intent intent = new Intent(getContext(),HomeGrid3Activity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(0,0);
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

                Intent intent = new Intent(getContext(),HomeGrid4Activity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(0,0);
            }
        });
    }

    @Override
    protected void initData() {

    }


}
package com.jiuhong.plane.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.jiuhong.plane.R;
import com.jiuhong.plane.aop.SingleClick;
import com.jiuhong.plane.app.AppActivity;

import java.util.ArrayList;
import java.util.List;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/AndroidProject
 *    time   : 2018/10/18
 *    desc   : 数据采集   页面1
 */
public final class HomeGrid2Caiji1Activity extends AppActivity {
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
    private Spinner spinner;

    @Override
    protected int getLayoutId() {
        return R.layout.home_grid2_caiji1_activity;
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

        spinner = (Spinner) findViewById(R.id.spinner);

        //原始string数组
        final String[] spinnerItems = {"飞机", "机翼","驾驶舱","发动机"};

        //简单的string数组适配器：样式res，数组
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, spinnerItems);
        //下拉的样式res
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //绑定 Adapter到控件
        spinner.setAdapter(spinnerAdapter);
        //选择监听
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                xb = spinnerItems[i];
                //  Toast.makeText(XXWSActivity1.this,"选择了"+spinnerItems[i],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });









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
                Intent intent = new Intent(getContext(), HomeGrid2Caiji1Activity.class);
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
    @SingleClick
    @Override
    public void onClick(View view) {
//        if (view==ll_right){
//            ll_sx_view.setVisibility(View.VISIBLE);
//        }
    }

}
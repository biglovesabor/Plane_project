package com.jiuhong.plane.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jiuhong.plane.R;
import com.jiuhong.plane.aop.SingleClick;
import com.jiuhong.plane.app.AppActivity;
import com.jiuhong.plane.http.response.SX_LeftBean;
import com.jiuhong.plane.http.response.SX_RightBean;
import com.jiuhong.plane.ui.adapter.Home_Grid4_ListAdapter;
import com.jiuhong.plane.ui.adapter.SX_LeftAdapter;
import com.jiuhong.plane.ui.adapter.SX_RightAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/AndroidProject
 *    time   : 2018/10/18
 *    desc   : 签字提交   页面1
 */
public final class HomeGrid4Activity extends AppActivity {
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
    private RecyclerView recycler_left;
    private RecyclerView recycler_right;
    private RecyclerView recycler_list;
    private SX_LeftAdapter sxLeftAdapter;
    private LinearLayout ll_right;
    private LinearLayout ll_sx_view;
    private TextView tv_right;
    private TextView tv_right2;
    private SX_RightAdapter sxRightAdapter;
    private Home_Grid4_ListAdapter homeGrid4ListAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.home_grid4_activity;
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


        ll_right = findViewById(R.id.ll_right);
        tv_right = findViewById(R.id.tv_right);

        ll_sx_view = findViewById(R.id.ll_sx_view);
        tv_right2 = findViewById(R.id.tv_right2);
        recycler_left = findViewById(R.id.recycler_left);
        recycler_right = findViewById(R.id.recycler_right);
        recycler_list = findViewById(R.id.recycler_list);


        List<SX_LeftBean> list3 = new ArrayList();
        SX_LeftBean sx_l1 = new SX_LeftBean();
        sx_l1.setText("列表数据1");

        list3.add(sx_l1);

        SX_LeftBean sx_l2 = new SX_LeftBean();
        sx_l2.setText("列表数据2");
        list3.add(sx_l2);

        SX_LeftBean sx_l3 = new SX_LeftBean();
        sx_l3.setText("列表数据3");
        list3.add(sx_l3);

        SX_LeftBean sx_l4 = new SX_LeftBean();
        sx_l4.setText("列表数据4");
        list3.add(sx_l4);

        SX_LeftBean sx_l5 = new SX_LeftBean();
        sx_l5.setText("列表数据5");
        list3.add(sx_l5);

        SX_LeftBean sx_l6 = new SX_LeftBean();
        sx_l6.setText("列表数据6");
        list3.add(sx_l6);



        LinearLayoutManager layoutManager3 = new LinearLayoutManager(getActivity());
        layoutManager3.setOrientation(RecyclerView.VERTICAL);
        recycler_list.setLayoutManager(layoutManager3);
        homeGrid4ListAdapter = new Home_Grid4_ListAdapter(getActivity());
        recycler_list.setAdapter(homeGrid4ListAdapter);
        homeGrid4ListAdapter.setNewData(list3);

        homeGrid4ListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {


                Intent intent = new Intent(getContext(), HomeGrid4QianZiActivity.class);
                startActivity(intent);
                overridePendingTransition(0,0);
            }
        });





       List<SX_LeftBean> list = new ArrayList();
       SX_LeftBean sx_leftBean1 = new SX_LeftBean();
       sx_leftBean1.setText("图像采集1");
        sx_leftBean1.setIsxz(true);
        list.add(sx_leftBean1);

        SX_LeftBean sx_leftBean2 = new SX_LeftBean();
        sx_leftBean2.setText("图像采集2");
        sx_leftBean2.setIsxz(false);
        list.add(sx_leftBean2);

        SX_LeftBean sx_leftBean3 = new SX_LeftBean();
        sx_leftBean3.setText("图像采集3");
        sx_leftBean3.setIsxz(false);
        list.add(sx_leftBean3);



        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recycler_left.setLayoutManager(layoutManager);
        sxLeftAdapter = new SX_LeftAdapter(getActivity());
        recycler_left.setAdapter(sxLeftAdapter);
        sxLeftAdapter.setNewData(list);



        List<SX_RightBean> list2 = new ArrayList();
        SX_RightBean sx_Bean1 = new SX_RightBean();
        sx_Bean1.setText("右边图像采集1");
        list2.add(sx_Bean1);

        SX_RightBean sx_Bean2 = new SX_RightBean();
        sx_Bean2.setText("右边图像采集2");
        list2.add(sx_Bean2);

        SX_RightBean sx_lBean3 = new SX_RightBean();
        sx_lBean3.setText("右边图像采集3");
        list2.add(sx_lBean3);

        LinearLayoutManager   layoutManager2 = new LinearLayoutManager(getActivity());
        layoutManager2.setOrientation(RecyclerView.VERTICAL);
        recycler_right.setLayoutManager(layoutManager2);
        sxRightAdapter = new SX_RightAdapter(getActivity());
        recycler_right.setAdapter(sxRightAdapter);
        sxRightAdapter.setNewData(list2);




        sxLeftAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                for (int i = 0; i < list.size(); i++) {
                    if (i == position) {
                        list.get(i).setIsxz(true);
                    }else {
                        list.get(i).setIsxz(false);
                    }
                }
                sxLeftAdapter.notifyDataSetChanged();
            }
        });


        setOnClickListener(ll_view1, ll_view2,ll_view3,ll_view4,ll_view5,ll_right);

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

    @SingleClick
    @Override
    public void onClick(View view) {
        if (view==ll_right){
            ll_sx_view.setVisibility(View.VISIBLE);
        }
    }
}
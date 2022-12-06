package com.jiuhong.plane.ui.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jiuhong.plane.R;
import com.jiuhong.plane.http.response.SX_LeftBean;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/AndroidProject
 *    time   : 2018/11/05
 *    desc   : 可进行拷贝的副本
 */
public final class Home_Grid4_ListAdapter extends BaseQuickAdapter<SX_LeftBean, BaseViewHolder> {

    private Context context;

    public Home_Grid4_ListAdapter(Context context) {
        super(R.layout.item_recycle_left);
        this.context = context;
    }




    @Override
    protected void convert(BaseViewHolder helper, SX_LeftBean item) {
        helper.setText(R.id.tv_text2,item.getText());




    }
}
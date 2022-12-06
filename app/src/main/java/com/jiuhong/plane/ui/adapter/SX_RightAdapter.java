package com.jiuhong.plane.ui.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jiuhong.plane.R;
import com.jiuhong.plane.http.response.SX_LeftBean;
import com.jiuhong.plane.http.response.SX_RightBean;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/AndroidProject
 *    time   : 2018/11/05
 *    desc   : 可进行拷贝的副本
 */
public final class SX_RightAdapter extends BaseQuickAdapter<SX_RightBean, BaseViewHolder> {

    private Context context;

    public SX_RightAdapter(Context context) {
        super(R.layout.item_recycle_right);
        this.context = context;
    }




    @Override
    protected void convert(BaseViewHolder helper, SX_RightBean item) {
        helper.setText(R.id.tv_text1,item.getText());




    }
}
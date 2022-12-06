package com.jiuhong.plane.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jiuhong.plane.R;
import com.jiuhong.plane.app.AppAdapter;
import com.jiuhong.plane.http.response.SX_LeftBean;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/AndroidProject
 *    time   : 2018/11/05
 *    desc   : 可进行拷贝的副本
 */
public final class SX_LeftAdapter extends BaseQuickAdapter<SX_LeftBean, BaseViewHolder> {

    private Context context;

    public SX_LeftAdapter(Context context) {
        super(R.layout.item_recycle_left);
        this.context = context;
    }




    @Override
    protected void convert(BaseViewHolder helper, SX_LeftBean item) {
        helper.setText(R.id.tv_text2,item.getText());

        if (item.getIsxz()){
            helper.setVisible(R.id.tv_text1,true);
            helper.setBackgroundColor(R.id.tv_text2,context.getResources().getColor(R.color.sx_huitext));
        }else {
            helper.setVisible(R.id.tv_text1,false);
            helper.setBackgroundColor(R.id.tv_text2,context.getResources().getColor(R.color.white));
        }


    }
}
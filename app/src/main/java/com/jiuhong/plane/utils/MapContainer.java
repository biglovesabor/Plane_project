package com.jiuhong.plane.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/*
 * 地图容器,,解决ScrollView  嵌套MapView 滑动冲突的问题
 *
 * */
public class MapContainer extends RelativeLayout {

    public MapContainer(Context context) {
        super(context);
    }
    public MapContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //我们现在需要在手指抬起的时候交由父布局拦截我子View的事件,也就是交由ScrollView滑动处理
//       requestDisallInterceptRouchEvent(true);
        // 但是在按下或者移动的时候禁用父布局的拦截事件,也就是
//        requestDisallInterceptRouchEvent(true);这时候地图滑动就正常了
        if (ev.getAction() == MotionEvent.ACTION_UP) {
            requestDisallowInterceptTouchEvent(false);
        } else {
            requestDisallowInterceptTouchEvent(true);
        }
        //返回false触摸事件才会传递到子View中,否则永远不会得到分发
        return false;
    }

    /*
     * retuan true 是需要当前的View处理这次的touch事件，以后发出的ACTION_MOVE，ACTION_UP还是要接收，
     * 而且这次的action已经被这个View给消费掉了，父布局层的ViewGroup将不会走onTouchEvent了

     * 如果return false，这次action会调用父级View的onTouchEvent。
     * 但是这一次的touch事件之后发出的任何action，该View都不会再接受，onTouchEvent在这一次的touch事件中再也不会触发，
     * 也就是说一旦View返回false，那么之后的ACTION_MOVE，ACTION_UP等ACTION就不会在传入这个View，
     * 但是下一次touch事件的action还是会传进来的。
     * 所以这里要返回true,自己处理所有的ACTION
     * */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
}

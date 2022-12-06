package com.jiuhong.plane.http.response;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/AndroidProject
 *    time   : 2019/12/07
 *    desc   : 可进行拷贝的副本
 */
public final class SX_RightBean {
    public Boolean getIsxz() {
        return Isxz;
    }

    public void setIsxz(Boolean isxz) {
        Isxz = isxz;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private Boolean Isxz=false;
    private String text;

}
package com.jiuhong.plane.utils;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SPUtils {

    private static SharedPreferences sp;
    private static Editor editor;

    public static void init(Context context) {
        // 如果这个上下文不是全局的上下文，就自动换成全局的上下文
        if (context != context.getApplicationContext()) {
            context = context.getApplicationContext();
        }
        sp = context.getSharedPreferences("common", Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    /**
     * 移除某个key值已经对应的值
     */
    public static void remove( String key) {
        editor.remove(key);
        editor.commit();

    }

    public static void getInstance(Context context, String filename) {
        context = context;
        sp = context.getSharedPreferences(filename, Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    public static void putBoolean(String key, Boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static boolean getBoolean(String key, Boolean defValue) {
        return sp.getBoolean(key, defValue);
    }

    public static void putString(String key, String value) {
        if (key == null) {
            return;
        }
        editor.putString(key, value);
        editor.commit();
    }

    public static String getString(String key, String defValue) {
        return sp.getString(key, defValue);
    }

    public static void putInt(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    public static int getInt(String key, int defValue) {
        return sp.getInt(key, defValue);
    }

    public static void putLong(String key, Long value) {
        editor.putLong(key, value);
        editor.commit();
    }

    public static Long getLong(String key, Long defValue) {
        return sp.getLong(key, defValue);
    }

    public static Map<String, ?> getAll() {
        return sp.getAll();
    }

    public static void removeAll() {
        editor.clear();
        editor.commit();
    }

    /**
     * 存储List<String>
     *
     * @param key     List<String>对应的key
     * @param strList 对应需要存储的List<String>
     */
    public static void putStrListValue(String key, List<String> strList) {
        if (null == strList) {
            return;
        }
        int size = strList.size();
        putInt(key + "size", size);
        for (int i = 0; i < size; i++) {
            putString(key + i, strList.get(i));
        }
    }

    /**
     * SP中是否存在该key
     *
     * @param key 键
     * @return {@code true}: 存在<br>{@code false}: 不存在
     */
    public static boolean contains(@NonNull String key) {
        return sp.contains(key);
    }

    /**
     * 取出List<String>
     * @param key     List<String> 对应的key
     * @return List<String>
     */
    public static List<String> getStrListValue(String key) {
        List<String> strList = new ArrayList<String>();
        int size = getInt(key + "size", 0);
        for (int i = 0; i < size; i++) {
            strList.add(getString(key + i, null));
        }
        return strList;
    }



    /**
     * 关闭软键盘
     *
     * @param view 当前页面上任意一个可用的view
     */
    public static void closeSoftKeyboard(View view) {
        if (view == null || view.getWindowToken() == null) {
            return;
        }
        InputMethodManager imm = (InputMethodManager)
                view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }



    //校验通过返回true，否则返回false
    public static boolean isMobile(String mobile) {

        String str = mobile;
        String pattern = "^(13[0-9]|14[0-9]|15[0-9]|16[0-9]|17[0-9]|18[0-9]|19[0-9])[0-9]{8}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);

        return m.matches();
    }





    /**
     * 判断给定的设备mac地址是否已连接经典蓝⽛
     *
     * @param macAddress 设备mac地址,例如"78:02:B7:01:01:16"
     * @return
     */
    public static boolean isConnectClassicBT(String macAddress) {
        if (TextUtils.isEmpty(macAddress)) {
            return false;
        }
        final BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        Class<BluetoothAdapter> bluetoothAdapterClass = BluetoothAdapter.class;//得到BluetoothAdapter的Class对象
        try {
            //是否存在连接的蓝⽛设备
            Method method = bluetoothAdapterClass.getDeclaredMethod("getConnectionState", (Class[]) null);
            //打开权限
            method.setAccessible(true);
            int state = (int) method.invoke(bluetoothAdapter, (Object[]) null);
            if (state == BluetoothAdapter.STATE_CONNECTED) {
                Log.d("test", "BluetoothAdapter.STATE_CONNECTED");
                Set<BluetoothDevice> devices = bluetoothAdapter.getBondedDevices();
                Log.d("test", "devices:" + devices.size());
                for (BluetoothDevice device : devices) {
                    Method isConnectedMethod = BluetoothDevice.class.getDeclaredMethod("isConnected", (Class[]) null);
                    method.setAccessible(true);
                    boolean isConnected = (boolean) isConnectedMethod.invoke(device, (Object[]) null);
                    if (isConnected) {
                        {
                            return macAddress.contains(device.getAddress());
                        }
                    } else {
                        Log.d("test", device.getName() + " connect false(" + device.getAddress() + ")");
                    }
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }




}

package cn.senjoeson.mylibrary.utilschanged;

import android.content.Context;
import android.support.annotation.IdRes;
import android.widget.Toast;

import cn.senjoeson.mylibrary.utils.AppUtils;
import cn.senjoeson.mylibrary.utils.ResourcesUtils;

/**
 * <p>
 * toast工具类封装
 */
public class MyToast {
    private static Toast mToast = null;

    /**
     * 显示一个toast提示
     *
     * @param resouceId toast字符串资源id
     */
    public static void showToast(@IdRes int resouceId) {
        showToast(ResourcesUtils.getString(resouceId));
    }

    /**
     * 显示一个toast提示
     *
     * @param text toast字符串
     */
    public static void showToast(String text) {
        showToast(text, Toast.LENGTH_SHORT);
    }

    /**
     * 显示一个toast提示
     *
     * @param text     toast字符串
     * @param duration toast显示时间
     */
    public static void showToast(String text, int duration) {
        showToast(AppUtils.getContext(), text, duration);
    }

    /**
     * 显示一个toast提示
     *
     * @param context  context 上下文对象
     * @param text     toast字符串
     * @param duration toast显示时间
     */
    public static void showToast(final Context context, final String text, final int duration) {
        /**
         * 保证运行在主线程
         */
        AppUtils.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                if (mToast == null) {
                    mToast = Toast.makeText(context, text, duration);
                } else {
                    mToast.setText(text);
                    mToast.setDuration(duration);
                }
                mToast.show();
            }
        });
    }

    public static void showToast(Object number) {
        if (number instanceof Integer) {
            showToast(String.valueOf(number));
        }
        if (number instanceof Long) {
            showToast(String.valueOf(number));
        }
        if (number instanceof Double) {
            showToast(String.valueOf(number));
        } else {
            MyToast.showToast("无法输出一个对象,此方法仅限于打印数字类型");
        }

    }
}

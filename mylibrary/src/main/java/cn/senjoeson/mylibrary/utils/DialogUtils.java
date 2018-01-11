package cn.senjoeson.mylibrary.utils;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import cn.senjoeson.mylibrary.R;

/**
 * Created by senjoeson on 2017/8/31.
 * <p>
 * 对话框工具类, 提供常用对话框显示, 使用support.v7包内的AlertDialog样式
 */
public class DialogUtils {

    private static Dialog mDialog;

    public static Dialog createProgressDialog(Context context) {
        return mDialog = createProgressDialog(context, true);
    }

    /**
     * 创建一个进度条
     *
     * @param context    上下文
     * @param needCancel 是否可被取消
     * @return 得到一个dialog
     */
    public static Dialog createProgressDialog(Context context, boolean needCancel) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setMessage("Loading ...");
        dialog.setCancelable(needCancel);
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }

    /**
     * 普通的对话框
     *
     * @param context  上下文
     * @param message  弹出消息提示
     * @param listener 确认对话框的监听
     * @return 得到一个dialog
     */
    public static Dialog showCommonDialog(Context context, String message,
                                          DialogInterface.OnClickListener listener) {
        return mDialog = showCommonDialog(context, message, context.getString(R.string.dialog_positive),
                context.getString(R.string.dialog_negative), listener);
    }

    /**
     * @param context      上下文
     * @param message      弹出消息提示
     * @param positiveText 确认
     * @param negativeText 取消
     * @param listener     对话框的确认监听
     * @return
     */
    public static Dialog showCommonDialog(Context context, String message, String positiveText,
                                          String negativeText, DialogInterface.OnClickListener
                                                  listener) {
        return new AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton(positiveText, listener)
                .setNegativeButton(negativeText, null)
                .show();
    }

    public static Dialog showConfirmDialog(Context context, String message,
                                           DialogInterface.OnClickListener listener) {
        return mDialog = showConfirmDialog(context, message, context.getString(R.string.dialog_positive),
                listener);
    }

    public static Dialog showConfirmDialog(Context context, String message, String positiveText,
                                           DialogInterface.OnClickListener listener) {
        return new AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton(positiveText, listener)
                .show();
    }

    /**
     * 关闭显示的弹框
     */
    public static void dismiss() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }
}

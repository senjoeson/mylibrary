package cn.senjoeson.mylibrary.utils;

import java.io.Closeable;
import java.io.IOException;

import cn.senjoeson.mylibrary.utilschanged.LogUtils;

/**
 * Created by senjoeson on 2017/8/31.
 * <p>
 * IO流工具类
 */
public class IOUtils {
    /**
     * 关闭流
     */
    public static boolean close(Closeable io) {
        if (io != null) {
            try {
                io.close();
            } catch (IOException e) {
                LogUtils.e(e);
            }
        }
        return true;
    }
}

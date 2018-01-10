package cn.senjoeson.mylibrary.utilschanged;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.HashMap;

import cn.senjoeson.mylibrary.http.BeanCallback;

/**
 * @author Android
 * @date 2018/1/10
 */

public class HttpHelper {
    /**
     * 网络访问请求
     *
     * @param url          地址
     * @param hashMap      参数
     * @param beanCallback 请求回调
     */
    public static void loadData(String url, HashMap<String, String> hashMap, BeanCallback beanCallback) {

        OkHttpUtils.post().url(url).params(hashMap).build().execute(beanCallback);

       /* new BeanCallback<T>() {

            @Override
            public void onSuccess(T respnose) {
                LogUtils.d(respnose.toString());

            }
        }*/
    }
}



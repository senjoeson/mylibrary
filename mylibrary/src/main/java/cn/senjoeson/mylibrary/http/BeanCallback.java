package cn.senjoeson.mylibrary.http;


import com.google.gson.Gson;
import com.zhy.http.okhttp.callback.Callback;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import cn.senjoeson.mylibrary.utilschanged.LogUtils;
import cn.senjoeson.mylibrary.utilschanged.MyToast;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by senjoeson on 2017/7/27 0027.
 */

public abstract class BeanCallback<T> extends Callback<T> {


    @Override
    public void onError(Call call, Exception e, int id) {
        MyToast.showToast("网络开了个小差");
    }

    @Override
    public T parseNetworkResponse(Response response, int id) throws Exception {
        LogUtils.d(""+response.code());
        //以下代码是通过泛型解析实际参数,泛型必须传
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        Type type = params[0];
        /*if (!(type instanceof ParameterizedType)) throw new IllegalStateException("没有填写泛型参数");

        JsonReader jsonReader = new JsonReader(response.body().charStream());
        Type rawType = ((ParameterizedType) type).getRawType();
        if (rawType == GankResponse.class) {
            GankResponse gankResponse = new Gson().fromJson(jsonReader, type);
            if (!gankResponse.error) {
                response.close();
                //noinspection unchecked
                return (T) gankResponse;
            } else {
                response.close();
                throw new IllegalStateException("服务端接口错误");
            }
        } else {
            response.close();
            throw new IllegalStateException("基类错误无法解析!");
        }*/

        T t = (T) new Gson().fromJson(response.body().string(), type);
        return t;


    }

    @Override
    public void onResponse(T t, int id) {
        onSuccess(t);
    }


    public abstract void onSuccess(T t);
}


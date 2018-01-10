package cn.senjoeson.mylibrary.http;

import java.io.Serializable;

/**
 * Created by senjoeson on 2017/11/18.
 */

public class GankResponse<T> implements Serializable {
    private static final long serialVersionUID = -686453405647539973L;

    public boolean error;
    public T results;
}
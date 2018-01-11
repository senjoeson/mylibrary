package cn.senjoeson.mylibrary.base;

/**
 * @author Android
 * @date 2018/1/11
 */

public abstract class BasePresenter<T> {

    public T mView;

    public void attach(T mView) {
        this.mView = mView;
    }

    public void dettach() {
        mView = null;
    }
}

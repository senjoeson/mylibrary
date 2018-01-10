package cn.senjoeson.mylibrary.base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * @author senjoeson
 * @date 2018/1/3
 */

public abstract class BaseRVAdapter<T, K extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<K> {
    private List<T> mDatas;

    /**
     * set a list for rv
     * @param list
     */
    public void setDatas(List<T> list) {
        this.mDatas = list;
    }

    @Override
    public K onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(setResId(), parent, false);
        return getViewHolder(view);
    }

    /**
     * set a view to get viewholder of rv
     * @param view
     * @return must extends viewholder of rv
     */
    protected abstract K getViewHolder(View view);

    /**
     * set a login of Res
     * @return
     */
    protected abstract int setResId();

    @Override
    public void onBindViewHolder(K holder, int position) {
                onBindData(holder,mDatas.get(position));
    }

    /**
     * bind data for rv
     * @param holder
     * @param t
     */
    protected abstract void onBindData(K holder, T t);

    @Override
    public int getItemCount() {
        return mDatas!=null?mDatas.size():0;
    }


    /**
     * add a data to list
     * @param e element
     */
    public void addItem(T e) {
        mDatas.add(e);
        notifyDataSetChanged();
    }

    /**
     *   delete a data if  exist
     * @param e element
     */
    public void deleteItem(T e) {
        if (mDatas.contains(e)) {
            mDatas.remove(e);
            notifyDataSetChanged();
        }
    }
}

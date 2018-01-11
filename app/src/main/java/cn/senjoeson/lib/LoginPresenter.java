package cn.senjoeson.lib;

import android.app.Activity;
import android.app.Dialog;

import cn.senjoeson.mylibrary.base.BasePresenter;
import cn.senjoeson.mylibrary.utils.DialogUtils;

/**
 * @author Android
 * @date 2018/1/11
 */

public class LoginPresenter extends BasePresenter<ILoginView> implements ILoginView {

    public Dialog mProgressDialog;

    @Override
    public void showLoading() {
        Activity view = (Activity) mView;
        mProgressDialog = DialogUtils.createProgressDialog(view);
        mProgressDialog.show();

    }

    @Override
    public void hideLoading() {
        DialogUtils.dismiss();
    }

    @Override
    public void login(String userName, String password) {
        showLoading();
       /* new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MyToast.showToast("登陆成功");
                hideLoading();
            }
        }, 3000);*/

       /* HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("username",userName);
        hashMap.put("password",password);
        HttpHelper.loadData("http://www.senjoeson.cn/login", hashMap, new BeanCallback<User>() {
            @Override
            public void onSuccess(User respnose) {

            }
        });
*/

    }




}

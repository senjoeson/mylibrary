package cn.senjoeson.lib;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import cn.senjoeson.mylibrary.base.BaseCompatActivity;
import cn.senjoeson.mylibrary.utilschanged.MyToast;

public class LoginActivity extends BaseCompatActivity<ILoginView, LoginPresenter> {
    @BindView(R.id.et_id)
    EditText mEtId;
    @BindView(R.id.et_pwd)
    EditText mEtPwd;
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    @BindView(R.id.tv_forgetpwd)
    TextView mTvForgetpwd;
    @BindView(R.id.tv_register)
    TextView mTvRegister;

    @Override
    protected LoginPresenter getPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {


    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLoginData();
            }
        });
    }

    /*
       * 检查login的数据合法性
       */
    private void checkLoginData() {
        String userName = mEtId.getText().toString().trim();
        String password = mEtPwd.getText().toString().trim();
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
            MyToast.showToast("用户名或者密码不能为空!");
            return;
        }
        //执行具体登陆逻辑,一般这个时候我们需要连接网络进行数据校验,因此要交给P层进行处理
        presenter.login(userName, password);
    }


}

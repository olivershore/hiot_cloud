package com.example.hiot_cloud.test.mvptest;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hiot_cloud.R;
import com.example.hiot_cloud.base.BaseActivity;
import com.example.hiot_cloud.test.dagger2test.DaggerPresenterComponent;
import com.example.hiot_cloud.test.dagger2test.PresenterComponent;
import com.example.hiot_cloud.test.mvptest.model.User;

import javax.inject.Inject;

public class TestMVPActivity extends BaseActivity<TestView, TestPresenter> implements TestView {

    @Inject
    TestPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getComponent().inject(this);
        super.onCreate(savedInstanceState);
        //
        setContentView(R.layout.activity_test_mvpactivity);
        EditText etUsername = findViewById(R.id.et_user_name);
        EditText etPassword = findViewById(R.id.et_password);
        //
        Button btnLogin = findViewById(R.id.btn_login);
        //
        final User user = new User();
        // final TestPresenter presenter =new TestPresenter();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mvc,在这身份校验
                user.setUserName(etUsername.getText().toString());
                user.setPassword(etPassword.getText().toString());
                presenter.login(user);
//                login(user);


            }
        });
    }

    @Override
    public TestPresenter creatPresenter() {
        return presenter;
    }


    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }

    /**
     * 创建注入器
     * @return
     */
    public PresenterComponent getComponent(){

        return DaggerPresenterComponent.builder().build();
    }

}
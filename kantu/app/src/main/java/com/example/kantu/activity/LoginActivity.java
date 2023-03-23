package com.example.kantu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;

import android.widget.Button;
import android.widget.Toast;

import com.example.kantu.R;
import com.example.kantu.utils.Constants;
import com.example.kantu.utils.ValidatorUtils;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btLogin = findViewById(R.id.btn_login);
        btLogin.setOnClickListener(v -> {
            //如果校验成功，则保存登录状态，跳转到列表页面
            if (ValidateSucc()){
                //保存登录状态

                //跳转列表界面
            }
        });

    }

    /**
     * 校验用户输入
     */
    private boolean ValidateSucc() {
        TextInputEditText tiptetEmail = findViewById(R.id.tiptet_email);
        TextInputEditText tiptetPassword = findViewById(R.id.tiptet_password);
        String email = Objects.requireNonNull(tiptetEmail.getText()).toString();
        String password = Objects.requireNonNull(tiptetPassword.getText()).toString();
        //校验邮箱非控
        if (TextUtils.isEmpty(email)){
            tiptetEmail.setError("邮箱不能为空，请重新输入");
            return false;
        }
        //校验邮箱合规
        if (!ValidatorUtils.isEmail(email)){
            tiptetEmail.setError("邮箱输入不正确，请重新输入");
            return false;
        }
        //校验密码非空
        if (TextUtils.isEmpty(password)){
            tiptetPassword.setError("密码不能为空");
            return false;
        }
        //校验密码合规
        if (!ValidatorUtils.isPassword(password)){
            tiptetPassword.setError("密码输入不正确，请重新输入");
            return false;
        }
        //校验用户名密码正确
        if (!Constants.LOGIN_USER_NAME.equals(email)||Constants.LOGIN_PASSWORD.equals(password)){
            Toast.makeText(this, "用户名密码不符，请重新输入", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
package com.md9999.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.md9999.R;

/**
 * Created by Lionnd on 2015/9/29.
 */
public class LoginAcitvity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ViewUtils.inject(this);
        initialView();
    }
    private void initialView() {

    }
    @OnClick(R.id.loginActivity_btn_login)
    public void btn_loginClicked(View v){
        Intent intent = new Intent();
        intent.setClass(LoginAcitvity.this, MainActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.loginActivity_btn_signUp)
    public void btn_signUpClicked(View v){
        Intent intent = new Intent();
        intent.setClass(LoginAcitvity.this, SignUpActivity.class);
        startActivity(intent);
    }

}

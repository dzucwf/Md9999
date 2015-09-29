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
public class SignUpActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ViewUtils.inject(this);
        initialView();
    }
    private void initialView() {

    }
    @OnClick(R.id.signUpActivity_btn_back)
    public void btn_loginClicked(View v){
        Intent intent = new Intent();
        intent.setClass(SignUpActivity.this,LoginAcitvity.class);
        startActivity(intent);
    }
}

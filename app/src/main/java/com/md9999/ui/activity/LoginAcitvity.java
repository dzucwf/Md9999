package com.md9999.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.lidroid.xutils.ViewUtils;
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
}

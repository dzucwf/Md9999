
package com.md9999.ui.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.md9999.R;
import com.md9999.common.BitmapHelper;

/**
 * Created by Lionnd on 2015/9/30.
 */
public class DrDetailsAcitvity extends FragmentActivity {

    @ViewInject(R.id.drDetailActivity_layout_desc)
    private RelativeLayout layout_desc;
    @ViewInject(R.id.drDetailActivity_layout_photoBg)
    private LinearLayout layout_photoBg;
    @ViewInject(R.id.lionnd_test)
    private ImageView lionndtest;
    @ViewInject(R.id.drDetailActivity_image_photo)
    private ImageView image_photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dr_detail);
        ViewUtils.inject(this);
        initialView();
    }

    private void initialView() {
        //半透明代码 //缩放 截取 模糊
        layout_desc.getBackground().setAlpha(100);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = BitmapHelper.dip2px(this, 280);
        //1`23123123
        //lionndtest.setImageBitmap(BitmapHelper.fastblur(this, Bitmap.createBitmap(BitmapHelper.resizeImage(this.getResources(), R.drawable.photo_test, width, height), 0, 0, width, height), 50));
        layout_photoBg.setBackground(new BitmapDrawable(BitmapHelper.fastblur(this, Bitmap.createBitmap(BitmapHelper.resizeImage(this.getResources(), R.drawable.photo_test, width, height), 0, 0, width, height), 30)));
        layout_photoBg.getBackground().setAlpha(80);
        image_photo.setBackground(new BitmapDrawable(BitmapHelper.toRoundBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.photo_test))));
    }

    @OnClick(R.id.drDetailActivity_btn_back)
    public void btn_backClicked(View v) {
        DrDetailsAcitvity.this.finish();
    }


}


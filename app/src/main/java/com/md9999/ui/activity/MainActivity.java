package com.md9999.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.md9999.R;
import com.md9999.adapter.BtmNaviSwitchAdapter;

public class MainActivity extends FragmentActivity {

    private static final String TAG = "MainActivity";


    private static  final  int TAB_SERVICE = 0;

    private static  final  int TAB_HEALTH = 1;

    private static  final  int TAB_DOCTOR = 2;

    private static  final  int TAB_MINE = 3;




    //切换导航栏
    @ViewInject(R.id.navi_view_pager)
    private ViewPager mSearchVp;

    BtmNaviSwitchAdapter switchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtils.inject(this);
        initialView();
    }


    private void initialView() {
        switchAdapter = new BtmNaviSwitchAdapter(getSupportFragmentManager());
        mSearchVp = (ViewPager) findViewById(R.id.navi_view_pager);
        mSearchVp.setAdapter(switchAdapter);
        mSearchVp.setOnPageChangeListener(mPageChgListener);
    }

    private ViewPager.OnPageChangeListener mPageChgListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {

            int vpItem = mSearchVp.getCurrentItem();
            setSelectButtonState(vpItem);

        }


    };

    private void setSelectButtonState(int curId) {

    }


    /*
      * 选中导航
      * */
    public void onNaviCheck(View view){
        int cur = TAB_SERVICE;

        switch (view.getId()){


            case R.id.navi_switcher_item_service:
                cur = TAB_SERVICE;

                break;
            case R.id.navi_switcher_item_health:
                cur = TAB_HEALTH;
                break;
            case R.id.navi_switcher_item_doctor:
                cur = TAB_DOCTOR;
                break;
            case R.id.navi_switcher_item_mine:
                cur = TAB_MINE;
                break;

        }

        if(mSearchVp.getCurrentItem() != cur) {
            mSearchVp.setCurrentItem(cur);

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

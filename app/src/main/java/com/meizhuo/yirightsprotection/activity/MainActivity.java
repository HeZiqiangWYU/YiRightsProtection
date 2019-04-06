package com.meizhuo.yirightsprotection.activity;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import com.meizhuo.yirightsprotection.R;
import com.meizhuo.yirightsprotection.fragment.FindFragment;
import com.meizhuo.yirightsprotection.fragment.HomePageFragment;
import com.meizhuo.yirightsprotection.fragment.MessagesFragment;
import com.meizhuo.yirightsprotection.fragment.MyFragment;

public class MainActivity extends AppCompatActivity
        implements HomePageFragment.OnFragmentInteractionListener,
        MessagesFragment.OnFragmentInteractionListener,
        FindFragment.OnFragmentInteractionListener,
        MyFragment.OnFragmentInteractionListener{

    FragmentManager fm; //Fragment管理器
    FragmentTransaction ft; //Fragment事务管理器
    //fragment
    HomePageFragment homePageFragment;
    MessagesFragment messagesFragment;
    FindFragment findFragment;
    MyFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager(); //初始化fm
        homePageFragment = new HomePageFragment();
        showFragment(homePageFragment);

        //  检查是否有相应的权限
        boolean isAllGranted = checkPermissionAllGranted(new String[] {
                        Manifest.permission.INTERNET,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                }
        );
        //请求权限
        if (!isAllGranted) {
            ActivityCompat.requestPermissions(this, new String[] {
                            Manifest.permission.INTERNET,
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                    },1
            );
        }

        translucentStatusBar(this, true); //设置透明状态栏

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home_page:
                        if (homePageFragment == null) {
                            homePageFragment = new HomePageFragment();
                        }
                        showFragment(homePageFragment);
                        break;

                    case R.id.navigation_messages:
                        if (messagesFragment == null) {
                            messagesFragment = new MessagesFragment();
                        }
                        showFragment(messagesFragment);
                        break;

                    case R.id.navigation_find:
                        if (findFragment == null) {
                            findFragment = new FindFragment();
                        }
                        showFragment(findFragment);
                        break;

                    case R.id.navigation_my:
                        if (myFragment == null) {
                            myFragment = new MyFragment();
                        }
                        showFragment(myFragment);
                        break;
                }
                return true;
            }
        });
    }

    /**
     * 设置状态栏颜色
     *
     * @param activity
     * @param hideStatusBarBackground
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    static void translucentStatusBar(Activity activity, boolean hideStatusBarBackground) {
        Window window = activity.getWindow();
        //添加Flag把状态栏设为可绘制模式
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (hideStatusBarBackground) {
            //如果为全透明模式，取消设置Window半透明的Flag
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //设置状态栏为白色
            window.setStatusBarColor(Color.WHITE);
            //状态栏文字为黑色
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else {
            //如果为半透明模式，添加设置Window半透明的Flag
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //设置系统状态栏处于可见状态
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        }
        //view不根据系统窗口来调整自己的布局
        ViewGroup mContentView = (ViewGroup) window.findViewById(Window.ID_ANDROID_CONTENT);
        View mChildView = mContentView.getChildAt(0);
        if (mChildView != null) {
            ViewCompat.setFitsSystemWindows(mChildView, false);
            ViewCompat.requestApplyInsets(mChildView);
        }
    }

    /**
     * 检查是否拥有指定的所有权限
     */
    private boolean checkPermissionAllGranted(String[] permissions) {
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    /**
     * 申请权限结果返回处理
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1) {
            boolean isAllGranted = true;

            // 判断是否所有的权限都已经授予了
            for (int grant : grantResults) {
                if (grant != PackageManager.PERMISSION_GRANTED) {
                    isAllGranted = false;
                    break;
                }
            }

            if (isAllGranted) {
                Toast.makeText(this, "已授权", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "未授权", Toast.LENGTH_SHORT).show();
            }
        }
    }



    /**
     * 显示fragment
     */
    private void showFragment(Fragment fragment) {
        ft = fm.beginTransaction();
        ft.replace(R.id.contentContainer, fragment);
        ft.commit(); //提交事务
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

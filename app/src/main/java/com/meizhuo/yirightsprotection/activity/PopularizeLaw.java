package com.meizhuo.yirightsprotection.activity;

import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.meizhuo.yirightsprotection.R;
import com.meizhuo.yirightsprotection.adapter.ViewPagerAdapter;
import com.meizhuo.yirightsprotection.fragment.CartoonFragment;
import com.meizhuo.yirightsprotection.fragment.ImageTextFragment;
import com.meizhuo.yirightsprotection.fragment.VideoFragment;

import java.util.ArrayList;
import java.util.List;

public class PopularizeLaw extends AppCompatActivity
        implements View.OnClickListener, VideoFragment.OnFragmentInteractionListener,
                ImageTextFragment.OnFragmentInteractionListener, CartoonFragment.OnFragmentInteractionListener {

    private ViewPager viewPager;
    private PagerTabStrip pagerTitle;
    private List<Fragment> fragmentList;
    private List<String> pagerTitleStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popularize_law);

        initView();
    }

    /**
     * 初始化视图
     */
    private void initView() {
        ImageView imgBack = findViewById(R.id.img_back);
        imgBack.setOnClickListener(this);

        TextView tvTitle = findViewById(R.id.title);
        tvTitle.setText("普法学堂");

        viewPager = findViewById(R.id.view_pager);
        pagerTitle = findViewById(R.id.pager_title);
        pagerTitle.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        pagerTitle.setTextColor(Color.WHITE);
        pagerTitle.setTabIndicatorColor(Color.WHITE);
        pagerTitleStrings = new ArrayList<>();
        pagerTitleStrings.add("视频");
        pagerTitleStrings.add("图文");
        pagerTitleStrings.add("漫画");
        fragmentList = new ArrayList<>();
        fragmentList.add(new VideoFragment());
        fragmentList.add(new ImageTextFragment());
        fragmentList.add(new CartoonFragment());
        FragmentManager fm = getSupportFragmentManager();
        viewPager.setAdapter(new ViewPagerAdapter(fm, fragmentList, pagerTitleStrings));
    }

    /**
     * 点击事件
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.img_back: //点击返回按钮
                this.finish();
                break;

        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

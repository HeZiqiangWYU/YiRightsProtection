package com.meizhuo.yirightsprotection.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.meizhuo.yirightsprotection.R;
import com.meizhuo.yirightsprotection.adapter.CaseListAdapter;
import com.meizhuo.yirightsprotection.bean.DigestOfCase;

import java.util.ArrayList;
import java.util.List;

public class CaseList extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "CaseList";

    RecyclerView recyclerView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_list);

        initView();
    }

    private void initView() {
        recyclerView = findViewById(R.id.recycler_view);
        TextView toolbarTitle = findViewById(R.id.title);
        //设置toolbar标题
        Intent intent = getIntent();
        switch (intent.getStringExtra("type")) {
            case "labourLaw":
                toolbarTitle.setText("劳动法");
                break;
            case "drugCrime":
                toolbarTitle.setText("毒品罪");
                break;
            case "domesticViolence":
                toolbarTitle.setText("家庭暴力");
                break;
            case "teenCrime":
                toolbarTitle.setText("青少年犯罪");
                break;
            case "larceny":
                toolbarTitle.setText("行窃");
                break;
            case "prostitution":
                toolbarTitle.setText("卖淫");
                break;
            case "piracy":
                toolbarTitle.setText("非法翻印");
                break;
            case "drunkDriving":
                toolbarTitle.setText("醉酒驾驶");
                break;
            case "antiSecessionLaw":
                toolbarTitle.setText("反分裂国家法");
                break;
            case "antiSocial":
                toolbarTitle.setText("反社会倾向");
                break;
        }

        ImageView back = findViewById(R.id.img_back);
        back.setOnClickListener(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        /**
         * 测试数据
         */
        List<DigestOfCase> digestOfCases = new ArrayList<>();
        DigestOfCase digestOfCase = new DigestOfCase();
        digestOfCase.setTitle("111111");
        digestOfCase.setDescribe("22222222222");
        digestOfCases.add(digestOfCase);

        CaseListAdapter adapter = new CaseListAdapter(digestOfCases);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.img_back:
                this.finish();
                break;
        }
    }
}

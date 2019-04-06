package com.meizhuo.yirightsprotection.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.meizhuo.yirightsprotection.R;

public class CaseDetails extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_details);

        initView();
    }

    private void initView() {
        ImageView back = findViewById(R.id.img_back);
        back.setOnClickListener(this);
        TextView toolbarTitle = findViewById(R.id.title);
        toolbarTitle.setText("案例详情"); //设置toolbar标题
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

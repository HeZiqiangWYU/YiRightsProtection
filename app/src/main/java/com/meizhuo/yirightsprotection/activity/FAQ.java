package com.meizhuo.yirightsprotection.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.meizhuo.yirightsprotection.R;

public class FAQ extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        initView();
    }

    private void initView() {
        TextView toolbarTitle = findViewById(R.id.title);
        toolbarTitle.setText("常见问题");
        ImageView back = findViewById(R.id.img_back);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                this.finish();
                break;

            default:
                break;
        }
    }
}

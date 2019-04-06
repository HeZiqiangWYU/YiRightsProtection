package com.meizhuo.yirightsprotection.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.meizhuo.yirightsprotection.R;

import org.w3c.dom.Text;

public class CaseAnalysis extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "CaseAnalysis";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_analysis);

        initView();
    }

    private void initView() {
        ImageView imgBack = findViewById(R.id.img_back);
        imgBack.setOnClickListener(this);

        TextView tvTitle = findViewById(R.id.title);
        tvTitle.setText("案例分析");

        TextView tvLabourLaw = findViewById(R.id.labour_law);
        tvLabourLaw.setOnClickListener(this);
        TextView tvDrugCrime = findViewById(R.id.drug_crime);
        tvDrugCrime.setOnClickListener(this);
        TextView tvDomesticViolence = findViewById(R.id.domestic_violence);
        tvDomesticViolence.setOnClickListener(this);
        TextView tvTeenCrime = findViewById(R.id.teen_crime);
        tvTeenCrime.setOnClickListener(this);
        TextView tvLarceny = findViewById(R.id.larceny);
        tvLarceny.setOnClickListener(this);
        TextView tvProstitution = findViewById(R.id.prostitution);
        tvProstitution.setOnClickListener(this);
        TextView tvPiracy = findViewById(R.id.piracy);
        tvPiracy.setOnClickListener(this);
        TextView tvDrunkDriving = findViewById(R.id.drunk_driving);
        tvDrunkDriving.setOnClickListener(this);
        TextView tvAntiSecessionLaw = findViewById(R.id.anti_secession_law);
        tvAntiSecessionLaw.setOnClickListener(this);
        TextView tvAntiSocial = findViewById(R.id.anti_social);
        tvAntiSocial.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;

        switch (view.getId()) {
            case R.id.img_back:
                this.finish();
                break;
                
            case R.id.labour_law:
                Log.d(TAG, "onClick: 劳动法");
                intent = new Intent(this, CaseList.class);
                intent.putExtra("type", "labourLaw");
                startActivity(intent);
                break;

            case R.id.drug_crime:
                Log.d(TAG, "onClick: 毒品罪");
                intent = new Intent(this, CaseList.class);
                intent.putExtra("type", "drugCrime");
                startActivity(intent);
                break;

            case R.id.domestic_violence:
                Log.d(TAG, "onClick: 家庭暴力");
                intent = new Intent(this, CaseList.class);
                intent.putExtra("type", "domesticViolence");
                startActivity(intent);
                break;

            case R.id.teen_crime:
                Log.d(TAG, "onClick: 青少年犯罪");
                intent = new Intent(this, CaseList.class);
                intent.putExtra("type", "teenCrime");
                startActivity(intent);
                break;

            case R.id.larceny:
                Log.d(TAG, "onClick: 行窃");
                intent = new Intent(this, CaseList.class);
                intent.putExtra("type", "larceny");
                startActivity(intent);
                break;

            case R.id.prostitution:
                Log.d(TAG, "onClick: 卖淫");
                intent = new Intent(this, CaseList.class);
                intent.putExtra("type", "prostitution");
                startActivity(intent);
                break;

            case R.id.piracy:
                Log.d(TAG, "onClick: 非法翻印");
                intent = new Intent(this, CaseList.class);
                intent.putExtra("type", "piracy");
                startActivity(intent);
                break;

            case R.id.drunk_driving:
                Log.d(TAG, "onClick: 醉酒驾驶");
                intent = new Intent(this, CaseList.class);
                intent.putExtra("type", "drunkDriving");
                startActivity(intent);
                break;

            case R.id.anti_secession_law:
                Log.d(TAG, "onClick: 反分裂国家法");
                intent = new Intent(this, CaseList.class);
                intent.putExtra("type", "antiSecessionLaw");
                startActivity(intent);
                break;

            case R.id.anti_social:
                Log.d(TAG, "onClick: 反社会倾向");
                intent = new Intent(this, CaseList.class);
                intent.putExtra("type", "antiSocial");
                startActivity(intent);
                break;
        }
    }
}

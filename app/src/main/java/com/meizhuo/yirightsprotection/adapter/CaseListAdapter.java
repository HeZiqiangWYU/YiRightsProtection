package com.meizhuo.yirightsprotection.adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.meizhuo.yirightsprotection.R;
import com.meizhuo.yirightsprotection.activity.CaseDetails;
import com.meizhuo.yirightsprotection.activity.CaseList;
import com.meizhuo.yirightsprotection.bean.DigestOfCase;

import java.util.List;

/**
 * Created by 何子强 on 2019/3/4
 */
public class CaseListAdapter extends RecyclerView.Adapter<CaseListAdapter.ViewHolder> {
    private static final String TAG = "CaseListAdapter";

    private List<DigestOfCase> mDigestOfCaseList;

    /**
     * ViewHolder内部类
     */
    static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout itemLayout;
        TextView caseTitle;
        TextView caseDescribe;

        public ViewHolder(View view) {
            super(view);
            itemLayout = view.findViewById(R.id.item_layout);
            caseTitle = view.findViewById(R.id.case_title);
            caseDescribe = view.findViewById(R.id.case_describe);
        }
    }

    public CaseListAdapter(List<DigestOfCase> digestOfCaseList) {
        mDigestOfCaseList = digestOfCaseList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_digest_of_case, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);

        //为案例摘要设置点击事件
        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: 案例详情");
                Intent intent = new Intent(view.getContext(), CaseDetails.class); //adapter没有context，由view获取context
                view.getContext().startActivity(intent);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        DigestOfCase digestOfCase = mDigestOfCaseList.get(position);
        viewHolder.caseTitle.setText(digestOfCase.getTitle());
        viewHolder.caseDescribe.setText(digestOfCase.getDescribe());
    }

    @Override
    public int getItemCount() {
        return mDigestOfCaseList.size();
    }
}

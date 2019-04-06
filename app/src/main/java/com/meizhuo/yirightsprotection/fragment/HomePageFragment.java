package com.meizhuo.yirightsprotection.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.meizhuo.yirightsprotection.GlideImageLoader;
import com.meizhuo.yirightsprotection.R;
import com.meizhuo.yirightsprotection.activity.CaseAnalysis;
import com.meizhuo.yirightsprotection.activity.FAQ;
import com.meizhuo.yirightsprotection.activity.MainActivity;
import com.meizhuo.yirightsprotection.activity.PopularizeLaw;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import static android.support.constraint.Constraints.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomePageFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomePageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomePageFragment extends Fragment implements OnBannerListener, View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;
    private Context mContext; //context

    private RelativeLayout searchBox;
    private RelativeLayout point1;
    private RelativeLayout point2;
    private RelativeLayout point3;
    private RelativeLayout point4;
    private RelativeLayout point5;
    private RelativeLayout point6;
    private RelativeLayout point7;
    private RelativeLayout point8;

    private View view;

    public HomePageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomePageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomePageFragment newInstance(String param1, String param2) {
        HomePageFragment fragment = new HomePageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home_page, container, false);
        initFragment();
        return view;
    }

    /**
     * 初始化Fragment
     */
    private void initFragment() {
        searchBox = view.findViewById(R.id.search_box);
        point1 = view.findViewById(R.id.point1);
        point2 = view.findViewById(R.id.point2);
        point3 = view.findViewById(R.id.point3);
        point4 = view.findViewById(R.id.point4);
        point5 = view.findViewById(R.id.point5);
        point6 = view.findViewById(R.id.point6);
        point7 = view.findViewById(R.id.point7);
        point8 = view.findViewById(R.id.point8);

        searchBox.setOnClickListener(this);
        point1.setOnClickListener(this);
        point2.setOnClickListener(this);
        point3.setOnClickListener(this);
        point4.setOnClickListener(this);
        point5.setOnClickListener(this);
        point6.setOnClickListener(this);
        point7.setOnClickListener(this);
        point8.setOnClickListener(this);

        Banner banner = view.findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
//        List<URL> imageUrls = new ArrayList<>();
//        try {
//            Toast.makeText(getContext(), Environment.getExternalStorageDirectory().toString(), Toast.LENGTH_SHORT).show();
//
//            String str = Environment.getExternalStorageDirectory() + "1.jpg";
////            imageUrls.add(new URL(str));
//            imageUrls.add(new URL("http://guolin.tech/api/bing_pic"));
//            imageUrls.add(new URL("http://guolin.tech/api/bing_pic"));
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }

        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.point_img_test);
        images.add(R.drawable.point_img_test);
        images.add(R.drawable.point_img_test);
        images.add(R.drawable.point_img_test);
        banner.setImages(images);
        banner.setOnBannerListener(this);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        mContext = null;
    }

    /**
     * 轮播图点击事件
     * @param position
     */
    @Override
    public void OnBannerClick(int position) {
        Toast.makeText(mContext, "轮播图" + (position+1), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;

        switch (view.getId()) {
            case R.id.search_box:
                Toast.makeText(mContext, "搜索框", Toast.LENGTH_SHORT).show();
                break;

            case R.id.point1: //普法学堂
                Log.d(TAG, "onClick: 启动PopularizeLawActivity");
                intent = new Intent(mContext, PopularizeLaw.class);
                mContext.startActivity(intent);
                break;

            case R.id.point2: //案例分析
                Log.d(TAG, "onClick: 启动CaseAnalysisActivity");
                intent = new Intent(mContext, CaseAnalysis.class);
                mContext.startActivity(intent);
                break;

            case R.id.point3:
                Log.d(TAG, "onClick: 启动FAQActivity");
                intent = new Intent(mContext, FAQ.class);
                mContext.startActivity(intent);
                break;

            case R.id.point4:
                Toast.makeText(mContext, "point4", Toast.LENGTH_SHORT).show();
                break;

            case R.id.point5:
                Toast.makeText(mContext, "point5", Toast.LENGTH_SHORT).show();
                break;

            case R.id.point6:
                Toast.makeText(mContext, "point6", Toast.LENGTH_SHORT).show();
                break;

            case R.id.point7:
                Toast.makeText(mContext, "point7", Toast.LENGTH_SHORT).show();
                break;

            case R.id.point8:
                Toast.makeText(mContext, "point8", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

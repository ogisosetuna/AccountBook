package com.example.AccountBook;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;


import androidx.fragment.app.Fragment;

public class TwoFragment extends Fragment {
    private PieView mPieView;
    private TextView tvAdd;
    private TextView tvReduce;

    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstancesState){
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_two, container,false);
        mPieView = v.findViewById(R.id.pieView);
        initPieView();
//        initAddAndReduce();
        return v;
    }

    private void initPieView() {
        mPieView.setColors(createColors());
        mPieView.setData(createData());
    }

    private ArrayList<PieEntry> createData() {
        ArrayList<PieEntry> pieLists = new ArrayList<>();
        pieLists.add(new PieEntry(30.00F, "娱乐"));
        pieLists.add(new PieEntry(30.00F, "生活"));
        pieLists.add(new PieEntry(20.00F, "必需"));
//        pieLists.add(new PieEntry(20.00F, "用品"));
        pieLists.add(new PieEntry(20.00F, "其他"));
        return pieLists;
    }

    private ArrayList<Integer> createColors() {
        ArrayList<Integer> colorLists = new ArrayList<>();
        colorLists.add(Color.parseColor("#EBBF03"));
        colorLists.add(Color.parseColor("#ff4d4d"));
        colorLists.add(Color.parseColor("#8d5ff5"));
//        colorLists.add(Color.parseColor("#41D230"));
        colorLists.add(Color.parseColor("#4FAAFF"));
        return colorLists;
    }

//    private void initAddAndReduce() {
//        tvAdd = tvAdd.findViewById(R.id.tv_add);
//        tvReduce = tvReduce.findViewById(R.id.tv_reduce);
//        tvAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ViewGroup.LayoutParams layoutParams = mPieView.getLayoutParams();
//                layoutParams.height = mPieView.getMeasuredHeight() + 10;
//                mPieView.setLayoutParams(layoutParams);
//            }
//        });
//        tvReduce.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ViewGroup.LayoutParams layoutParams = mPieView.getLayoutParams();
//                layoutParams.height = mPieView.getMeasuredHeight() - 10;
//                mPieView.setLayoutParams(layoutParams);
//            }
//        });
//    }
}

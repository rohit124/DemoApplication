package com.sws.demoapplication;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class MyPostFragment extends Fragment {

    private Activity activity;
    private RecyclerView recyclerView;
    private MyPostAdapter myPostAdapter;
    private int itemPosition;
    private TextView customMsg;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rView = inflater.inflate(R.layout.fragment_mypost, container, false);
        activity = getActivity();
        initializeView(rView);
        initializeData();
        setLintener();

        return rView;
    }

    private void initializeData() {
        myPostAdapter = new MyPostAdapter(activity, null);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(myPostAdapter);

    }


    private void setLintener() {
    }

    private void initializeView(View rView) {
        recyclerView = (RecyclerView) rView.findViewById(R.id.recycler_view);
    }
}

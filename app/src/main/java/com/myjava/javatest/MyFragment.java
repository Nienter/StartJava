package com.myjava.javatest;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.transition.Transition;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MyFragment extends Fragment {
    private static final String TAG = "MyFragment";
    private Thread myThread;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(container.getContext()).inflate(R.layout.layout_my_fragment, container, false);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged: " + getArguments().getString("kl"));
        myThread.start();
    }

    public MyFragment newInstance(String s) {
        myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "run: ");
            }
        });
        Bundle args = new Bundle();
        args.putString("kl", s);
        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach: ");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated: ");
        getView().findViewById(R.id.bt).setOnClickListener(v -> {
//            AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).setTitle("fdsg").create();
//            alertDialog.show();
            FragmentTransaction transition = getChildFragmentManager().beginTransaction().add(R.id.fl, new MyFragmentB().newInstance("df"));
            transition.addToBackStack(null);
            transition.commit();
        });

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach: ");
    }
}

package com.example.donsll02.Fragment.Fragment;

import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.donsll02.R;


public class BlankFragment1 extends Fragment {

    // 创建的快捷键 logt
    private static final String TAG = "BlankFragment1";

    private View root;
    private TextView textView;
    private Button button;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach:");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (this.getArguments() != null){
            // 获取传输过来的 Bundle
            Bundle bundle = this.getArguments();
            Log.d(TAG, "onCreate: " + bundle.getString("message"));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(TAG, "onCreateView:");

        if (root == null){
            root = inflater.inflate(R.layout.fragment_blank1, container, false);
        }

        textView = root.findViewById(R.id.fm_tv_1);

        button = root.findViewById(R.id.fm_btn_1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Yeah, I'm fine");
            }
        });

        return root;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated:");

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart:");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume:");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause:");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop:");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView:");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy:");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach:");
    }
}
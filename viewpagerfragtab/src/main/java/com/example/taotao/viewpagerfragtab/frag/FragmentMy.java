package com.example.taotao.viewpagerfragtab.frag;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taotao.viewpagerfragtab.R;
import com.example.taotao.viewpagerfragtab.SecondActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentMy extends Fragment {

    View mainView = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mainView == null) {
            mainView = inflater.inflate(R.layout.fragment_my, container, false);
        }
        ButterKnife.bind(this, mainView);


        return mainView;
    }

    @OnClick(R.id.button)
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), SecondActivity.class);
        startActivity(intent);
    }

}

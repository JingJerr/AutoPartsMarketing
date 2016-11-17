package com.project.liuboyuan.autopartsmarketing;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


/**
 * Created by 13173 on 2016/10/26.
 */

public class vip_Fragment extends Fragment{
    private LinearLayout like;
    private LinearLayout address;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vip_main, container, false);

        like = (LinearLayout)view.findViewById(R.id.ll_like);
        address = (LinearLayout)view.findViewById(R.id.ll_address);
        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),adress_activity.class);
                getActivity().startActivity(intent);
            }
        });
        return view;

    }


}

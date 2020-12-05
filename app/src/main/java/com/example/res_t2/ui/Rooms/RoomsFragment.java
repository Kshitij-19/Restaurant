package com.example.res_t2.ui.Rooms;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.res_t2.R;

public class RoomsFragment extends Fragment {

    private Button btn1, btn2, btn3;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_rooms, container, false);
        btn1 = (Button) rootView.findViewById(R.id.button1room);
        btn2 = (Button) rootView.findViewById(R.id.button2room);
        btn3 = (Button) rootView.findViewById(R.id.button3room);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), room1.class);
                startActivity(intent);

            }


        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), room2.class);
                startActivity(intent);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), room3.class);
                startActivity(intent);



            }
        });

        return rootView;
    }

}
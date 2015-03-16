package com.example.osdevlab.simplefragmenttutorial;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by osdevlab on 12/29/14.
 */
public class FragmentOne extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout with fragment_one.xml
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        //create Button 'buttonPress' and link with button id from fragment_one.xml
        Button buttonPress = (Button) view.findViewById(R.id.button);
        //create TextView 'textViewPress' and link with texView id from fragment_one.xml
        final TextView textViewPress = (TextView) view.findViewById(R.id.textView);

        /*define OnClickListener here*/
        buttonPress.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //when button is pressed, textViewPress is changed to following message
                textViewPress.setText("Button has been Pressed");
            }
        });

        return view;
    }


}

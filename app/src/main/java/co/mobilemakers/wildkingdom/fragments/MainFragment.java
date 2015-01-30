package co.mobilemakers.wildkingdom.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import co.mobilemakers.wildkingdom.OnClickImageListener;
import co.mobilemakers.wildkingdom.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    ImageButton buttonBrownBear;
    ImageButton buttonCoralSnake;
    ImageButton buttonGecko;
    ImageButton buttonGrizzlyBear;
    ImageButton buttonTortoise;
    ImageButton buttonWombat;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.fragment_main,container,false);
       prepareButtons(rootView);
       return rootView;
    }

    private void prepareButtons(View rootView) {
        buttonBrownBear = (ImageButton)rootView.findViewById(R.id.image_button_brown_bear);
        buttonCoralSnake= (ImageButton)rootView.findViewById(R.id.image_button_coral_snake);
        buttonGecko= (ImageButton)rootView.findViewById(R.id.image_button_gecko);
        buttonGrizzlyBear= (ImageButton)rootView.findViewById(R.id.image_button_grizzly_bear);
        buttonTortoise= (ImageButton)rootView.findViewById(R.id.image_button_tortoise);
        buttonWombat= (ImageButton)rootView.findViewById(R.id.image_button_wombat);

        buttonBrownBear.setOnClickListener(new OnClickImageListener(getFragmentManager(), R.drawable.brown_bear ));
        buttonCoralSnake.setOnClickListener(new OnClickImageListener(getFragmentManager(), R.drawable.coral_snake));
        buttonGecko.setOnClickListener(new OnClickImageListener(getFragmentManager(),R.drawable.gecko));
        buttonGrizzlyBear.setOnClickListener(new OnClickImageListener(getFragmentManager(),R.drawable.grizzly_bear));
        buttonTortoise.setOnClickListener(new OnClickImageListener(getFragmentManager(),R.drawable.tortoise));
        buttonWombat.setOnClickListener(new OnClickImageListener(getFragmentManager(),R.drawable.wombat));

    }




}

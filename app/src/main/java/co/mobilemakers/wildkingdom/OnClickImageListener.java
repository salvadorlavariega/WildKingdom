package co.mobilemakers.wildkingdom;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;

import co.mobilemakers.wildkingdom.fragments.TemplateAnimalFragment;

/**
 * Created by root on 29/01/15.
 */
public class OnClickImageListener implements View.OnClickListener{

    public final static String PARAM_ANIMAL = " PARAM_ANIMAL";
    private FragmentManager fragmentManager;
    private int drawableID;

    public OnClickImageListener(){

    }

    public OnClickImageListener(FragmentManager fragmentManager,int drawableID){
        this.fragmentManager = fragmentManager;
        this.drawableID = drawableID;
    }
    @Override
    public void onClick(View v) {
        TemplateAnimalFragment templateAnimalFragment = new TemplateAnimalFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(PARAM_ANIMAL,drawableID);
        templateAnimalFragment.setArguments(bundle);

        fragmentManager.beginTransaction().replace(
                R.id.fragmen_main_layout,templateAnimalFragment).addToBackStack(null).commit();
    }
}

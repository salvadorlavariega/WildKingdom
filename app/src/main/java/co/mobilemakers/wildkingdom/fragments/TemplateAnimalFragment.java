package co.mobilemakers.wildkingdom.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.mobilemakers.wildkingdom.AnimalBean;
import co.mobilemakers.wildkingdom.OnClickImageListener;
import co.mobilemakers.wildkingdom.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TemplateAnimalFragment extends Fragment {

    private final int MAX_ANIMALS=5;
    private final String LOG_TAG = TemplateAnimalFragment.class.getSimpleName();
    private ImageButton buttonNext;
    private ImageButton buttonPrevious;
    private ImageView imageView;
    private TextView nameAnimalTextView;
    private TextView habitatAnimalTextView;
    private TextView descAnimalTextView;
    private ArrayList<AnimalBean> animals = new ArrayList<AnimalBean>();
    int currentAnimal=0;

    public TemplateAnimalFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_animal_template, container, false);

        prepareTemplate(rootView);
        prepareArrayAnimals();
        prepareButtons(rootView);

        if(getArguments().containsKey(OnClickImageListener.PARAM_ANIMAL)){
            currentAnimal = getAnimalPosition(getArguments().getInt(OnClickImageListener.PARAM_ANIMAL));
            updateImage(currentAnimal);
        }

        return rootView;
    }

    private void prepareTemplate(View rootView) {
        nameAnimalTextView = (TextView)rootView.findViewById(R.id.text_view_name_animal);
        habitatAnimalTextView = (TextView)rootView.findViewById(R.id.text_view_habitad);
        descAnimalTextView = (TextView)rootView.findViewById(R.id.text_view_description);
        imageView = (ImageView) rootView.findViewById(R.id.image_view_layout);
    }


    private void prepareButtons(View rootView) {
        buttonNext = (ImageButton) rootView.findViewById(R.id.image_button_next);
        buttonPrevious = (ImageButton) rootView.findViewById(R.id.image_button_previous);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(currentAnimal < MAX_ANIMALS) {
                    if(currentAnimal==0) buttonPrevious.setVisibility(View.VISIBLE);
                    currentAnimal += 1;
                    updateImage(currentAnimal);
                }
                if(currentAnimal >= MAX_ANIMALS) {
                    buttonNext.setVisibility(View.INVISIBLE);
                }

            }


        });

        buttonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(currentAnimal > 0) {
                    if(currentAnimal==MAX_ANIMALS) buttonNext.setVisibility(View.VISIBLE);
                    currentAnimal -= 1;
                    updateImage(currentAnimal);
                }
                if(currentAnimal <= 0) {
                    buttonPrevious.setVisibility(View.INVISIBLE);
                }

            }


        });
    }


    private void updateImage(int currentAnimal) {
        Log.i(LOG_TAG,"## updateImage( )### Accesando al Animal en posicion= "+currentAnimal);
        Log.i(LOG_TAG,"## updateImage( )### Size arrayList Animals= "+animals.size());
            AnimalBean animalBean = animals.get(currentAnimal);
            imageView.setImageResource(animalBean.getIdAnimal());
            nameAnimalTextView.setText(animalBean.getNameAnimal());
            habitatAnimalTextView.setText(animalBean.getHabitatAnimal());
            descAnimalTextView.setText(animalBean.getDescriptionAnimal());

    }
    private void prepareArrayAnimals() {
        int[] ids = prepareArrayAnimalIds();
        String[] habitats = prepareArrayAnimalHabitat();
        String[] descriptions = prepareArrayAnimalDescription();
        String[] names = prepareArrayNameAnimals();

        for (int i = 0; i < ids.length; i++)
            animals.add(new AnimalBean(names[i], habitats[i], descriptions[i], ids[i]));

    }


    private int[] prepareArrayAnimalIds() {
        return new int[]{
                R.drawable.brown_bear,
                R.drawable.coral_snake,
                R.drawable.gecko,
                R.drawable.grizzly_bear,
                R.drawable.tortoise,
                R.drawable.wombat
        };

    }

    private String[] prepareArrayAnimalHabitat() {
        return new String[]{
                "Brown bears can be found in many habitats, from the fringes of deserts to high mountain forests and ice fields. In Europe, the brown bear is mostly found in mountain woodlands, in Siberia it occurs primarily in forests while in North America they prefer tundra, alpine meadows and coastlines.",
                "The eastern coral snake is found in scattered localities in the southern Coastal Plain from North Carolina to Louisiana, including all of Florida, where they are most prevalent.",
                "Native Habitat of the Leopard Gecko & Setting up a Natural Enclosure. The leopard gecko is the most common pet reptile in homes today. They're small and easy to care for. They come in a variety of colors and have a very docile temperament.",
                "Grizzly bears are found many different habitats, from dense forests to subalpine meadows, open plains and arctic tundra. In North America, grizzly bears are found in western Canada, Alaska, Wyoming, Montana, Idaho and a potentially a small population in Washington.",
                "Most desert tortoises live in creosote bush scrub habitat at elevations ranging from 1,000 to 3,000 feet above sea level, although they are known to occur in suitable habitats up to about 5,000 feet in elevation.",
                "They are adaptable in habitat tolerance, and are found in forested, mountainous, and heathland areas of south-eastern Australia, including Tasmania"
        };
    }


    private String[] prepareArrayAnimalDescription() {
        return new String[]{
                "These omnivorous giants tend to be solitary animals, except for females and their cubs, but at times they do congregate. Dramatic gatherings can be seen at prime Alaskan fishing spots when the salmon swim upstream for summer spawning.",
                "This iconic snake, with its bulbous head and red, yellow, and black bands, is famous as much for its potent venom as for the many rhymes",
                "The gecko is a small to medium species of lizard that is found in the more temperate and tropical regions of the world. Geckos are more commonly found around the Equator and in the Southern Hemisphere although a few species of gecko are found north of the Equator in warmer regions.",
                "Grizzly bears are powerful, top-of-the-food-chain predators, yet much of their diet consists of nuts, berries, fruit, leaves, and roots. Bears also eat other animals, from rodents to moose.",
                "No other tortoise in North America shares the extreme conditions of habitats occupied by the desert tortoise. It has a high domed shell, which is usually brown in adults and dark tan in younger individuals. ",
                "Wombats are short-legged, muscular quadrupedal marsupials that are native to Australia and are approximately 1 metre (40 in) in length, with short, stubby tails."
        };
    }

    private String[] prepareArrayNameAnimals() {
        return new String[]{
                "Brown Bear",
                "Coral Snake",
                "Gecko",
                "Grizzly Bear",
                "Tortoise",
                "Wombat"
        };
    }

    private int getAnimalPosition(int drawableId){

        Log.i(LOG_TAG,"##### getAnimalPosition int drawableId= "+drawableId);
        for(int i=0; i<prepareArrayAnimalIds().length;i++){
            Log.i(LOG_TAG,"&&& id="+prepareArrayAnimalIds()[i]);
        }
        switch(drawableId){
            case R.drawable.brown_bear:
                return 0;

            case R.drawable.coral_snake:
                return 1;

            case R.drawable.gecko:
                return 2;

            case  R.drawable.grizzly_bear:
                return 3;

            case R.drawable.tortoise:
                return 4;

            case R.drawable.wombat:
                return 5;

            default: return 0;
        }

    }

}

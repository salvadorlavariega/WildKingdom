package co.mobilemakers.wildkingdom;

/**
 * Created by root on 29/01/15.
 */
public class AnimalBean {

    private String nameAnimal;
    private String habitatAnimal;
    private String descriptionAnimal;
    private int idAnimal;
    public AnimalBean(){

    }

    public AnimalBean(String nameAnimal,String habitatAnimal,String descriptionAnimal, int idAnimal){

        this.nameAnimal=nameAnimal;
        this.habitatAnimal=habitatAnimal;
        this.descriptionAnimal=descriptionAnimal;
        this.idAnimal=idAnimal;
    }



    public String getNameAnimal() {
        return nameAnimal;
    }

    public void setNameAnimal(String nameAnimal) {
        this.nameAnimal = nameAnimal;
    }

    public String getHabitatAnimal() {
        return habitatAnimal;
    }

    public void setHabitatAnimal(String habitatAnimal) {
        this.habitatAnimal = habitatAnimal;
    }

    public String getDescriptionAnimal() {
        return descriptionAnimal;
    }

    public void setDescriptionAnimal(String descriptionAnimal) {
        this.descriptionAnimal = descriptionAnimal;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }
}

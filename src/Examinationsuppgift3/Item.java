package Examinationsuppgift3;

//Skapar en Item class
public class Item {

    private String name;
    private String description;


    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //Formaterar utskrift av item
    public String toString(){
        return name + " - " + description;
    }


}

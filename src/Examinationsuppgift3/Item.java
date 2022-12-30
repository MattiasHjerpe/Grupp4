package Examinationsuppgift3;

//Skapar en Item class
public class Item {

    protected String name;
    protected String description;


    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Item getItem() {
        return new Item(name, description);
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return name + " - " + description;
    }
}

package Examinationsuppgift3;

public class Key extends Item {
    private boolean unlock;
    private Key key;

    public Key(String name, String description, boolean unlock) {
        super(name, description);
        this.unlock = unlock;
    }

    public boolean getUnlock() {
        return this.unlock;
    }

    public Key getKey() {
        return this.key;
    }
}

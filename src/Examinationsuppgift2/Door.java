package Examinationsuppgift2;

public class Door {
    private char position;
    private boolean locked;

    public Door(char position, boolean locked) {
            this.position = position;
            this.locked = locked;
        }
        public boolean isLocked() {
            return this.locked;
        }
    }


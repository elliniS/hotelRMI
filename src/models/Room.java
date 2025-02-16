package models;

public class Room {
    private boolean reserved;
    private int type;
    private double price;

    public Room(boolean reserved, int type, double price) {
        this.reserved = reserved;
        this.type = type;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean getReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}

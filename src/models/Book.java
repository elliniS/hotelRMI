package models;

public class Book {
   private String customerName;
   private int roomType;

    public Book(String customerName, int roomType) {
        this.customerName = customerName;
        this.roomType = roomType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }
}

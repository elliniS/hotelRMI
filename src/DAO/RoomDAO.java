package DAO;

import models.Room;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class RoomDAO {
    private static RoomDAO instance;
    public ArrayList<Room> list;

    public static RoomDAO getInstance() {

        if (instance == null) {
            instance = new RoomDAO();

        }

        return instance;
    }

    private RoomDAO() {
        list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Room room = new Room(false, 0, 55);

            list.add(room);
        }

        for (int i = 0; i < 20; i++) {
            Room room = new Room(false, 1, 75);

            list.add(room);
        }

        for (int i = 0; i < 5; i++) {
            Room room = new Room(false, 2, 80);

            list.add(room);
        }

        for (int i = 0; i < 3; i++) {
            Room room = new Room(false, 3, 150);

            list.add(room);
        }

        for (int i = 0; i < 4; i++) {
            Room room = new Room(false, 4, 230);

            list.add(room);
        }

    }

    public ArrayList<Room> getRooms() {
        return list;
    }

    public  ArrayList<Room> getRoomsAvailableBytype(int type) {
        return list.stream().filter(room -> room.getType() == type && room.getReserved() == false).collect(Collectors.toCollection(ArrayList::new));
    }
}

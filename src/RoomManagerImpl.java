import DAO.BookDAO;
import DAO.RoomDAO;
import models.Book;
import models.Room;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RoomManagerImpl extends UnicastRemoteObject implements RoomManager {
    protected RoomManagerImpl() throws RemoteException {
        super();
    }

    @Override
    public int[] listRoomAvailable() throws RemoteException {
        int[] result = new int[5];
        RoomDAO roomDAO = RoomDAO.getInstance();

        for (int i = 0; i < 5; i++){
            ArrayList<Room> rooms = roomDAO.getRoomsAvailableBytype(i);
            result[i] =  rooms == null ? 0 : rooms.size();
        }

        return result;

    }

    @Override
    public String book(int type, String name) throws RemoteException {
        if(type < 0 || type > 5){
            return "Tipo de quarto inválido";
        }

        RoomDAO roomDAO = RoomDAO.getInstance();

        ArrayList<Room> rooms = roomDAO.getRoomsAvailableBytype(type);

        if(rooms == null || rooms.size() == 0){
            return "Este tipo de quarto não está disponível!";
        }

        BookDAO bookDAO = BookDAO.getInstance();

        bookDAO.add(new Book(name, type));

        rooms.get(0).setReserved(true);

        return "Reserva feita com sucesso!";
    }

    @Override
    public ArrayList<String> listClient() throws RemoteException {
        BookDAO bookDAO = BookDAO.getInstance();
        ArrayList<Book> books = bookDAO.getBooks();
        ArrayList<String> result = new ArrayList<>();

        for( Book book : books){
            result.add(book.getCustomerName());
        }

        return result;
    }
}

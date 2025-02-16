import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RoomManager extends Remote {
    public int[] listRoomAvailable() throws RemoteException;
    public String book(int type, String name) throws RemoteException;
    public ArrayList<String> listClient() throws RemoteException;
}

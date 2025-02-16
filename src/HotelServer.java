import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class HotelServer {
    public static void main(String[] args) {
        try {
            String host;

            if (args.length > 0) {
                host = args[0];
            }
            else {
                host = InetAddress.getLocalHost().getHostAddress();
            }

            LocateRegistry.createRegistry(1099);
            RoomManager roomManager = new RoomManagerImpl();
            String caminho = String.format("rmi://%s/HotelServer", host);

            Naming.rebind(caminho, roomManager);

            System.out.println("Hotel Server ready in: " + caminho);
        }
        catch (Exception e) {
            System.out.println("Hotel Server exception: " + e.getMessage());
        }
    }
}

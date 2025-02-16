import java.rmi.Naming;
import java.util.ArrayList;

public class HotelClient{
    public static void main(String[] args){
        try {
            if (args.length > 1) {

                RoomManager manager = (RoomManager) Naming.lookup(String.format("rmi://%s:1099/HotelServer", args[0]));

                if (args[1].equals("list")) {
                    int[] rooms = manager.listRoomAvailable();

                    System.out.println("Quartos:");
                    System.out.println(String.format("%d quartos do tipo 0 estão disponíveis por 55 reais por noite", rooms[0]));
                    System.out.println(String.format("%d quartos do tipo 1 estão disponíveis por 75 reais por noite", rooms[1]));
                    System.out.println(String.format("%d quartos do tipo 2 estão disponíveis por 80 reais por noite", rooms[2]));
                    System.out.println(String.format("%d quartos do tipo 3 estão disponíveis por 150 reais por noite", rooms[3]));
                    System.out.println(String.format("%d quartos do tipo 4 estão disponíveis por 230 reais por noite", rooms[4]));

                    return;
                }
                else if (args[1].equals("book") && args.length == 4) {
                    int type= Integer.parseInt(args[2]);

                    String retorno = manager.book(type, args[3]);
                    System.out.println(retorno);

                    return;
                }
                else if (args[1].equals("clientes")) {
                    ArrayList<String> clientes = manager.listClient();

                    System.out.println("Lista de clientes: ");
                    for (String cliente : clientes) {
                        System.out.println(cliente);
                    }

                    return;
                }
            }

            System.out.println("java HotelClient list <Endereço do servidor> | Mostra quartos disponiveis");
            System.out.println("java HotelClient book <Endereço do servidor> <tipo Quarto> <Nome do hospede> | Efetua reserva");
            System.out.println("java HotelClient clientes <Endereço do servidor> | Lista os clientes hospedados");
        }
        catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

# Configuração
## IDE: 
IntelliJ.
## JDK usado no local do desenvilvimento: 
20.0.2.
## Build system: 
IntelliJ.
# Estrutura
## Dados:
Para manipulação dos dados foram criados os models Book(reserva) e Room(quarto). <br>
Para os controles dos dados foram criados DAOS que adotam o padrão singleton, para cada um dos models existentes.
## Inicialização dos dados:
Quando o DAO do Room é inicializado são inseridos a ele todos os quartos presentes no sistema.
Interface:
Serve como mediadora entre, o server e o client, nela estão as funções que o client irá poder consumir do servidor.
## Imp:
Nele está condindo a implementação dos métodos da interface. Estes são:
- listRoomAvailable: Obtém do DAO os quantos que estão disponíveis de cada tipo e os contabiliza, retornando somente a soma dos que estão livres de cada tipo.
- book: Recebe como entrada o tipo do quarto e o nome do hóspede. Se houver um quarto disponível do tipo informado, cria um objeto Book, armazena-o no DAO correspondente, e marca um dos quartos do tipo informado como reservado.
- listClient: Através do DAO pegar as hospedagens e retorna o nome dos hóspedes.
## Server:
Carrega a implementação da interface e a deixa disponível para uso.
## Client:
É utilizado para conectar-se ao servidor e invocar métodos da implementação da interface. Em seguida, formata os dados para apresentação ao usuário. 

# Execução
Requisito: está na pasta “src” do projeto.

## Compilar sem IDE:
Executa comandos:
- javac models/Book.java
- javac models/Room.java
- javac DAO/BookDAO.java
- javac DAO/RoomDAO.java
- javac RoomManager.java
- javac RoomManagerImpl.java
- javac HotelClient.java
- javac HotelServer.java

## Executar Servidor:
java HotelServer <endereço opcional se não for informado é colocado o ip encontrado>
 ![image](https://github.com/user-attachments/assets/422b1668-3d9a-41d6-90bb-9df806734ccd)

## Executar Client:
java HotelClient: É mostrado a lista de comandos que podem ser usados
 ![image](https://github.com/user-attachments/assets/9d4b0b9f-eab2-4c01-9930-a0adc797c548)

Java HotelClient list <endereço>:  Chama o método listRoomAvailable, assim retornando a quantidade de de quartos deisponiveis para cada um dos tipos.
 ![image](https://github.com/user-attachments/assets/a5bfb783-2dae-43d1-9764-49bf7d2104e9)

Java book <endereço> <tipo Quarto> <Nome do hospede>: Executa o método Book, a reserva do tipo de quarto especificado
 ![image](https://github.com/user-attachments/assets/b25c53e7-226b-4273-b866-4049c65de666)

Java clientes <endereço>: executa o listClient obtendo os hospedes e os mostrando para os usuários
![image](https://github.com/user-attachments/assets/c345e9ea-bbad-408c-9c69-5e746e23f989)

 

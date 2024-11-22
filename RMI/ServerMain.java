package RMI;


import java.rmi.RemoteException;
import java.sql.SQLException;

public class ServerMain {
    public static void main(String[] args) throws RemoteException, SQLException {
        System.out.println("Server is starting up!!!");
        RMI server = new RMI();
        Thread sThread = new Thread(server);
        sThread.run();
        System.out.println("Server is up!!!");
    }
}
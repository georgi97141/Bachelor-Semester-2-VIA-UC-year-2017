package Client;


import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import view.Login;
import view.SplashMP;
import view.SplashPatient;

import model.MP;


public class ClientMain {
    private Client client;

    Client c = new Client();

    public ClientMain() throws SQLException, RemoteException, MalformedURLException, NotBoundException {
        System.out.println("Establishing connection , please wait");
    }

    public static void main(String[] args) throws SQLException, RemoteException, MalformedURLException, NotBoundException {
        Login log = new Login();
    }
}
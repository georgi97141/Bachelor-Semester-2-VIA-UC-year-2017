package controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import Client.Client;

public class Controller {

    private String user;
    private static Controller instance;
    private Socket sock;
    private Client c;
    private String userCpr;

    public static Controller getController() {
        if (instance != null) {
            return instance;
        } else {
            instance = new Controller();
            return instance;
        }
    }

    private Controller() {
        try {
            c = new Client();
        } catch (MalformedURLException | RemoteException | NotBoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void setSocket(String ip) {
        try {
            sock = new Socket(ip, 9999);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getUser() {
        return user;
    }

    public void setUser(String uid) {
        user = uid;
    }

    public void addPatient(String text, String text2, String text3) {
        try {
            c.addPatient(text, text2, text3);
        } catch (RemoteException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public ArrayList<String> getPatient(String cpr) {

        // TODO Auto-generated method stub
        try {
            return c.getPatient(cpr);
        } catch (RemoteException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public void editPatient(String text, String text2, String text3) {
        // TODO Auto-generated method stub
        try {
            c.editPatient(text, text2, text3);
        } catch (RemoteException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public ArrayList<ArrayList<String>> getRecords(String cpr) {

        try {
            return c.getRecords(cpr);
        } catch (RemoteException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<ArrayList<String>> getPrescriptions(String cpr) {
        return c.getPrescriptions(cpr);
    }

    public void addPrescription(String cpr, String medName, int i, boolean selected, String disease) {
        Calendar currenttime = Calendar.getInstance();
        java.sql.Date sqldate = new Date((currenttime.getTime()).getTime());
        try {
            c.addPrescription(medName, disease, i, selected, sqldate, cpr, userCpr);
        } catch (RemoteException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String getUserCPR() {
        return userCpr;
    }

    public boolean login(String id, String pass) {
        try {
            userCpr = c.getName();
            return c.Log_in(id, pass);
        } catch (RemoteException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return false;
    }

    public void addMp(String a, String b, String z) {
        try {
            c.addMp(a, b, z);
        } catch (RemoteException | SQLException e) {
            e.printStackTrace();
        }
    }

    public String getStatus() {
        return c.getStatus();
    }

    public void deletePatient(String cpr) {
        c.deletePatient(cpr);
    }

    public void deleteMP(String id) {
        c.deleteMP(id);
    }
}


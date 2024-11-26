package server;

import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ConnectorInterface {
    ArrayList<String> log_in(String Cpr) throws SQLException, RemoteException;

    void deletePatient(String str) throws SQLException, RemoteException;

    void deleteMP(String str) throws SQLException, RemoteException;

    void addPatient(ArrayList<Object> lis) throws SQLException, RemoteException;

    void addMP(ArrayList<Object> lis) throws SQLException, RemoteException;

    void AddTreatment(ArrayList<Object> lis) throws SQLException, RemoteException;

    void addPrescription(ArrayList<Object> lis) throws SQLException, RemoteException;


    ArrayList<String> findPatient(String str) throws SQLException, RemoteException;

    ArrayList<ArrayList<String>> viewTreatment(String cpr) throws SQLException, RemoteException;

    ArrayList<ArrayList<String>> viewPrescription(String cpr) throws SQLException, RemoteException;

    ArrayList<String> findMP(String id) throws SQLException, RemoteException;

    ArrayList<String> findDisease(int d) throws SQLException, RemoteException;

    void editPatient(String cpr, String Adress, String nome) throws SQLException, RemoteException;

}

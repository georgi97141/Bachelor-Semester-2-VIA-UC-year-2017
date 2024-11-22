package Client;

import java.net.*;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import model.MP;
import model.Patient;
import model.Prescription;
import model.Treatment;
import RMI.*;

public class Client {
    private RMInterface rmiServer;
    @SuppressWarnings("unused")
    private Registry registry;
    String status;
    String user;

    @SuppressWarnings("unused")
    public Client() throws MalformedURLException, RemoteException,
            NotBoundException, SQLException {

        String ip = "localhost";
        int port = 1099;

        registry = LocateRegistry.getRegistry(ip, port);
        rmiServer = (RMInterface) Naming.lookup("sep");


        rmiServer.sayHi();

    }

    public String getName() {
        return user;
    }

    public String getStatus() {
        return status;
    }

    public boolean Log_in(String id, String pass) throws SQLException, RemoteException {
        ArrayList<String> str = new ArrayList<>();
        str.add(rmiServer.log_in(id).get(0));
        str.add(rmiServer.log_in(id).get(1));
        str.add(rmiServer.log_in(id).get(2));
        System.out.println(str.get(0));
        System.out.println("pas" + str.get(1));
        System.out.println("Stat" + str.get(2));

        if (pass.equals(str.get(1))) {
            this.user = id;
            this.status = str.get(2);
            return true;
        }
        return false;

    }

    public void addMp(String id, String name, String spec) throws RemoteException, SQLException {
        MP m = new MP(id, name, spec);
        rmiServer.addMP(m.toList());
    }


    public void addPatient(String cpr, String nam, String adr)  throws RemoteException, SQLException {
        Patient p = new Patient(cpr, nam, adr);
        rmiServer.addPatient(p.toList());
    }

    public void addTreatment(String treatment, Date d, String patient, String dok)  throws RemoteException, SQLException {
        Treatment t = new Treatment(treatment, d, patient, dok);
        rmiServer.AddTreatment(t.toList());
    }


    public void addPrescription(String medName, String disease, int renewals, boolean continous,
                                Date prescripedOn, String patient, String prescriber) throws RemoteException, SQLException {
        if (patient.matches("^[0-9]*$") && rmiServer.findPatient(patient) != null) {
            String lie;
            if (continous) {
                lie = "y";
            } else
                lie = "n";
            Prescription t = new Prescription(medName, renewals, lie,
                    prescripedOn, patient, prescriber, disease);
            rmiServer.addPrescription(t.toList());
        } else {
            JOptionPane j = new JOptionPane();
            j.showMessageDialog(null, "Incorrect input Data", "error", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public ArrayList<String> getPatient(String cpr) throws RemoteException, SQLException {
        return rmiServer.findPatient(cpr);
    }

    public void editPatient(String text, String text2, String text3) throws RemoteException, SQLException {
        rmiServer.editPatient(text, text2, text3);
    }

    public ArrayList<ArrayList<String>> getRecords(String cpr) throws RemoteException, SQLException {
        return rmiServer.viewTreatment(cpr);

    }

    public ArrayList<ArrayList<String>> getPrescriptions(String cpr) {
        try {
            return rmiServer.viewPrescription(cpr);
        } catch (RemoteException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public void deletePatient(String cpr) {
        try {
            rmiServer.deletePatient(cpr);
        } catch (RemoteException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void deleteMP(String id) {
        try {
            rmiServer.deleteMP(id);
        } catch (RemoteException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

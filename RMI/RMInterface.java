package RMI;

// throws exceptions
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public interface RMInterface extends Remote {
	public void sayHi() throws SQLException,RemoteException;
	public ArrayList<String> log_in(String Cpr)
	throws SQLException,RemoteException;
	public void deletePatient(String str)
	throws SQLException,RemoteException;
	public void deleteMP(String str)
	throws SQLException,RemoteException;
	public void addPatient(ArrayList<Object> lis)
	throws SQLException,RemoteException;
	public void addMP(ArrayList<Object> lis)
	throws SQLException,RemoteException;
	public void AddTreatment(ArrayList<Object> lis)
	throws SQLException,RemoteException;
	public void addPrescription(ArrayList<Object> lis)
	throws SQLException,RemoteException;
	public ArrayList<String> findPatient(String str)
	throws SQLException,RemoteException;
	public ArrayList<ArrayList<String>> viewTreatment(String cpr)
	throws SQLException,RemoteException;
	public ArrayList<ArrayList<String>> viewPrescription(String cpr)
	throws SQLException,RemoteException;
	public ArrayList<String> findMP(String id)
	throws SQLException,RemoteException;
	public ArrayList<String> findDisease(int d)
	throws SQLException,RemoteException;
	public void editPatient(String cpr, String Adress,String nome)
	throws SQLException,RemoteException;
}

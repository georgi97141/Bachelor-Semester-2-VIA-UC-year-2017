package RMI;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import server.Connector;
import server.ConnectorInterface;


public class RMI extends UnicastRemoteObject implements RMInterface,Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public RMI() throws RemoteException {}
	private ConnectorInterface con= new Connector();

	@Override
	public void run() {
		try 
		{ 
			@SuppressWarnings("unused")
			Registry reg = LocateRegistry.createRegistry(1099);
			RMI obj = new RMI();
			Naming.rebind("sep", obj); 
			System.out.println("Server is running");
		} 
		catch (Exception e) 
		{ 
			System.out.println(" Error: " + e.getMessage()); 
			e.printStackTrace(); 
		} 
	}
	

	@Override
	public ArrayList<String> log_in(String Cpr) throws SQLException, RemoteException {
		// TODO Auto-generated method stub
		return con.log_in(Cpr);
	}

	@Override
	public void deletePatient(String str) throws SQLException, RemoteException {
		// TODO Auto-generated method stub
		con.deletePatient(str);
	}

	@Override
	public void deleteMP(String str) throws SQLException, RemoteException {
		// TODO Auto-generated method stub
		con.deleteMP(str);
	}

	@Override
	public void addPatient(ArrayList<Object> lis)
			throws SQLException, RemoteException {
		// TODO Auto-generated method stub
		con.addPatient( lis);
	}

	@Override
	public void addMP(ArrayList<Object> lis)
			throws SQLException, RemoteException {
		// TODO Auto-generated method stub
		con.addMP(lis);
	}

	@Override
	public void AddTreatment(ArrayList<Object> lis)
			throws SQLException, RemoteException {
		// TODO Auto-generated method stub
		con.AddTreatment(lis);
		
	}

	@Override
	public void addPrescription(ArrayList<Object> lis) throws SQLException,
			RemoteException {
		// TODO Auto-generated method stub
		con.addPrescription(lis);
		
	}

	@Override
	public ArrayList<String> findPatient(String str) throws SQLException,
			RemoteException {
		// TODO Auto-generated method stub
		return con.findPatient(str);
	}

	@Override
	public ArrayList<ArrayList<String>> viewTreatment(String cpr)
			throws SQLException, RemoteException {
		// TODO Auto-generated method stub
		return con.viewTreatment(cpr);
	}

	@Override
	public ArrayList<ArrayList<String>> viewPrescription(String cpr)
			throws SQLException, RemoteException {
		// TODO Auto-generated method stub
		return con.viewPrescription(cpr);
	}

	@Override
	public ArrayList<String> findMP(String id) throws SQLException,
			RemoteException {
		// TODO Auto-generated method stub
		return con.findMP(id);
	}

	@Override
	public ArrayList<String> findDisease(int d) throws SQLException,
			RemoteException {
		// TODO Auto-generated method stub
		return con.findDisease(d);
	}

	@Override
	public void editPatient(String cpr, String Adress,String name) throws SQLException,
			RemoteException {
		// TODO Auto-generated method stub
		con.editPatient(cpr, Adress,name);
		
	}


	@Override
	public void sayHi() {
		System.out.println("Hi");		
	}

}

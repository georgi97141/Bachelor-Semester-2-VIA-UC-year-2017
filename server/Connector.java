package server;

// 150 ����
//import java.sql.Statement;
import java.io.ObjectInputStream;

import org.postgresql.Driver;

import java.io.ObjectOutputStream;
import java.net.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.*;

// things to do view patients
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Connector implements ConnectorInterface {
	private Socket sock;
	private Connection conn;
	boolean runMe = true;
	private ObjectInputStream input;
	private ObjectOutputStream output;

	// dp get/ set string start from 0 or 1?????? ????
	public Connector() {
		conn = connect();
	}

	public Connection connect() {
		Driver driver = new Driver();
		try {
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/postgres", "postgres",
					"admin");
		} catch (SQLException e) {
			System.out.println("Failed to connect the SQL Database");
		}

		return conn;
	}


	public void initialize() {
		try {
			input = new ObjectInputStream(sock.getInputStream());
			output = new ObjectOutputStream(sock.getOutputStream());
		} catch (Exception e) {

		}
	}


	@Override
	public ArrayList<String> log_in(String Cpr) {

		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("SELECT * FROM login WHERE cpr = ?");
			stmt.setString(1, Cpr);

			ResultSet rs = stmt.executeQuery();
			rs.next();
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(1));
			ArrayList<String> str = new ArrayList<>();
			str.add(rs.getString(1));
			str.add(rs.getString(2));
			str.add(rs.getString(3));
			return str;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane j = new JOptionPane();
			j.showMessageDialog(null, "Incorrect input Data" , "error", JOptionPane.INFORMATION_MESSAGE);

			e.printStackTrace();
		}
		System.out.println("opa dilie");
		return null;
	}

	// /
	@Override
	public void deletePatient(String str) {
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("DELETE * FROM patient WHERE cpr =?");
			stmt.setString(1, str);
			stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane j = new JOptionPane();
			j.showMessageDialog(null, "Incorrect input Data" , "error", JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();

		}
	}

	// /
	@Override
	public void deleteMP(String str) {

		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("DELETE * FROM medicinepersonel WHERE id =?");
			stmt.setString(1, str);

			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane j = new JOptionPane();
			j.showMessageDialog(null, "Incorrect input Data" , "error", JOptionPane.INFORMATION_MESSAGE);

			e.printStackTrace();
			
		}
	}

	//
	@Override
	public void addPatient(ArrayList<Object> lis) {
		PreparedStatement stmt;
		try {
			if (((String) lis.get(0)).matches("^[0-9]*$")
					&& ((String) lis.get(1)).matches("[a-zA-Z\\s']+\\.?")
					&& ((String) lis.get(2)).matches("[a-zA-Z\\s']+\\.?")) {
				stmt = conn.prepareStatement("INSERT INTO Patient(CPR,Name,City) VALUES(?,?,?)");
				stmt.setString(1, (String) lis.get(0));
				stmt.setString(2, (String) lis.get(1));
				stmt.setString(3, (String) lis.get(2));
				stmt.executeUpdate();
			} else {
				System.out.print("Try again");
				
				JOptionPane j = new JOptionPane();
			j.showMessageDialog(null, "Incorrect input Data" , "error", JOptionPane.INFORMATION_MESSAGE);	
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane j = new JOptionPane();
			j.showMessageDialog(null, "Incorrect input Data" , "error", JOptionPane.INFORMATION_MESSAGE);

			e.printStackTrace();
			
		}
	}

	// /
	@Override
	public void addMP(ArrayList<Object> lis) {

		PreparedStatement stmt;
		try {
				stmt = conn.prepareStatement("INSERT INTO medicinepersonel(ID,Name,Speciality) VALUES(?,?,?)");
				stmt.setString(1, (String) lis.get(0));
				stmt.setString(2, (String) lis.get(1));
				stmt.setString(3, (String) lis.get(2));
				stmt.executeUpdate();
//
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane j = new JOptionPane();
			j.showMessageDialog(null, "Incorrect input Data" , "error", JOptionPane.INFORMATION_MESSAGE);

			e.printStackTrace();
			

		}
	}

	// /

	@Override
	public void AddTreatment(ArrayList<Object> lis) {
		PreparedStatement stmt;
		try {

				stmt = conn.prepareStatement("INSERT INTO treatment(CPR,Treatment,ID,TreatedOn) VALUES(?,?,?,?");
				stmt.setString(1, (String) lis.get(0));
				stmt.setString(2, (String) lis.get(1));
				stmt.setString(3, (String) lis.get(2));
				stmt.setDate(4, (Date) lis.get(3));

				stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		
			JOptionPane j = new JOptionPane();
			j.showMessageDialog(null, "Incorrect input Data" , "error", JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		}
	}

	//
	@Override
	public void addPrescription(ArrayList<Object> lis) {

		PreparedStatement stmt;

		try {
				stmt = conn.prepareStatement("INSERT INTO prescription(CPR,ID,DiseaseID,MedicalProcedure,Renewals,"
								+ "Continous,DatePrescribed) "
								+ "VALUES(?,?,?,?,?,?,?)");
				System.out.print(lis.get(2));
				stmt.setString(1, (String) lis.get(0));
				stmt.setString(2, (String) lis.get(1));
				stmt.setString(3, (String) lis.get(2));
				stmt.setString(4, (String) lis.get(3));
				stmt.setInt(5, (int) lis.get(4));
				stmt.setString(6,  (String) lis.get(5));
				stmt.setDate(7, (Date) lis.get(6));
				stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			JOptionPane j = new JOptionPane();
			j.showMessageDialog(null, "Incorrect input Data" , "error", JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		}
	}

	// does get string starts from 0 or 1 ,��??
	@Override
	public ArrayList<String> findPatient(String str) {
		// Patient P = new Patient(str, null, null);
		ArrayList<String> p = new ArrayList<>();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("SELECT * FROM patient WHERE cpr =?");
			stmt.setString(1, str);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			p.add(rs.getString(1));
			p.add(rs.getString(2));
			p.add(rs.getString(3));

			return p;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			JOptionPane j = new JOptionPane();
			j.showMessageDialog(null, "Incorrect input Data" , "error", JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		}
		return null;
	}

	// does get string starts from 0 or 1 ,��??
	@Override
	public ArrayList<ArrayList<String>> viewTreatment(String cpr) {
		ArrayList<ArrayList<String>> outer = new ArrayList<>();
		
		PreparedStatement stmt;
		try {
			stmt = conn
					.prepareStatement("SELECT * FROM treatment WHERE cpr =?");
			stmt.setString(1, cpr);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				ArrayList<String> inner = new ArrayList<>();
				//inner.add(rs.getString(2));
				inner.add(rs.getString(4));
				inner.add(rs.getString(3));
				inner.add(rs.getString(5));
				outer.add(inner);

			}
			return outer;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			JOptionPane j = new JOptionPane();
			j.showMessageDialog(null, "Incorrect input Data" , "error", JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		}
		return null;
	}

	// // view prescript
	@Override
	public ArrayList<ArrayList<String>> viewPrescription(String cpr) {
		try {
		
			// String cpr= p.getCPR();
			ArrayList<ArrayList<String>> outer = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM"
					+ " prescription WHERE cpr =?");
			stmt.setString(1, cpr);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				ArrayList<String> inner = new ArrayList<>();
				// Prescription dummy=new Prescription(cpr, 0, true, null, p);
//				inner.add(rs.getString(1));
				inner.add(rs.getString(5));
				inner.add(rs.getString(6));
				inner.add(rs.getString(7));
				inner.add(rs.getString(8));
				inner.add(rs.getString(3));
				inner.add(rs.getString(4));
//				inner.add(rs.getString(4));
//				inner.add(rs.getString(5));
//				inner.add(rs.getString(6));
//				inner.add(rs.getString(7));
//				inner.add(rs.getString(8));
				outer.add(inner);	
				//rs.next();

			}
			return outer;
		} catch (SQLException e) {
			
			JOptionPane j = new JOptionPane();
			j.showMessageDialog(null, "Incorrect input Data" , "error", JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		}
		return null;

	}

	// to do: this + display all patients
	@Override
	public ArrayList<String> findMP(String id) {
		ArrayList<String> mp = new ArrayList<>();
		PreparedStatement stmt;
		try {
			stmt = conn
					.prepareStatement("SELECT * FROM medicinepersonel WHERE id =?");
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			mp.add(rs.getString(1));
			mp.add(rs.getString(2));
			mp.add(rs.getString(3));
			return mp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		
			JOptionPane j = new JOptionPane();
			j.showMessageDialog(null, "Incorrect input Data" , "error", JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		}
		return null;

	};

	public ArrayList<String> findDisease(int d) {
		// Disease z= new Disease(d, null);
		ArrayList<String> str = new ArrayList();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("SELECT * FROM disease WHERE id =?");
			stmt.setInt(1, d);

			ResultSet rs = stmt.executeQuery();
			rs.next();

			str.add(rs.getString(1));
			str.add(rs.getString(2));
			return str;
		} catch (SQLException e) {
			JOptionPane j = new JOptionPane();
			j.showMessageDialog(null, "Incorrect input Data" , "error", JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		}
		return null;
	}

	// /
	@Override
	public void editPatient(String cpr, String Adress, String nome) {
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("Update  Patient set city= ?,name=? where cpr= ?");
			stmt.setString(1, Adress);
			stmt.setString(2, nome);
			stmt.setString(3, cpr);
			stmt.executeUpdate();
		} catch (SQLException e) {
			JOptionPane j = new JOptionPane();
			j.showMessageDialog(null, "Incorrect input Data" , "error", JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		}
	}

}

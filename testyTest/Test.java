package testyTest;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import model.Prescription;
import server.Connector;
public class Test {

	
	
	@org.junit.Test
	public void testFind() {
//		
Connector con= new Connector();
ArrayList<String> str= new ArrayList<>();
str.add("0987654321");
str.add("xD");
str.add("FlavortownX");
assertEquals(str,con.findPatient("0987654321"));


		
	}

//	@org.junit.Test
//	public void testViewpresc() {
////		
//Connector con= new Connector();
//ArrayList<ArrayList<String>> str= new ArrayList<>();
/////String medicinName, int renewals, String continous,
////Date prescripedOn, String patient, String prescriber, String disease
//Calendar currenttime = Calendar.getInstance();
//java.sql.Date sqldate = new Date((currenttime.getTime()).getTime());
//
//Prescription p = new Prescription("opa", 2, "n", sqldate, "1234543211", "abc", "kur");
//ArrayList<String> xd = new ArrayList<>();
//xd.add)
//;
//assertEquals(str,con.findPatient("0987654321"));
//
//
//		
//	}
//	
	
	
	
}

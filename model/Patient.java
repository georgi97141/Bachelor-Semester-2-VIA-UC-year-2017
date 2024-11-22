package model;

import java.util.ArrayList;

public class Patient
{
   private String CPR, Name, Adress;

   public String getCPR()
   {
      return CPR;
   }

   public void setCPR(String cPR)
   {
      CPR = cPR;
   }

   public String getName()
   {
      return Name;
   }

   public void setName(String name)
   {
      Name = name;
   }

   public String getAdress()
   {
      return Adress;
   }

   public void setAdress(String adress)
   {
      Adress = adress;
   }

   public Patient(String cPR, String name, String adress)
   {
      CPR = cPR;
      Name = name;
      Adress = adress;
   }
   
   public ArrayList<Object> toList(){
	   //CPR,Name,City
		ArrayList<Object> lis= new ArrayList<>();
		lis.add(CPR);
		lis.add(Name);
		lis.add(Adress);
		return lis;
		

	}

   
   
}

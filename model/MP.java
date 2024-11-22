package model;

import java.util.ArrayList;

public class MP
{
   private String ID, Name, Specialization;
   public String getID()
   {
      return ID;
   }

   public void setID(String iD)
   {
      ID = iD;
   }

   public String getName()
   {
      return Name;
   }

   public void setName(String name)
   {
      Name = name;
   }

   public String getSpecialization()
   {
      return Specialization;
   }

   public void setSpecialization(String specialization)
   {
      Specialization = specialization;
   }

   public MP(String iD, String name, String specialization)
   {
      ID = iD;
      Name = name;
      Specialization = specialization;
   }

 //ID,Name,Speciality
public ArrayList<Object> toList(){
	ArrayList<Object> lis= new ArrayList<>();
	lis.add(ID);
	lis.add(Name);
	lis.add(Specialization);
	return lis;
	

}
   
   
}

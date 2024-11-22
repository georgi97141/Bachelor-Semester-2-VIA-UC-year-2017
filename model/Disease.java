package model;

import java.util.ArrayList;

public class Disease
{
   private int ID;
   private String name;

   public int getID()
   {
      return ID;
   }

   public void setID(int iD)
   {
      ID = iD;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public Disease(int iD, String name)
   {
      ID = iD;
      this.name = name;
   }

   public ArrayList<Object> toList(){
		ArrayList<Object> lis= new ArrayList<>();
		lis.add(ID);
		lis.add(name);
		return lis;
		

	}
   
   
}

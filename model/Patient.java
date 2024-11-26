package model;

import java.util.ArrayList;

public class Patient {
    private String cpr, name, adress;

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cPR) {
        cpr = cPR;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Patient(String cpr, String name, String adress) {
        this.cpr = cpr;
        this.name = name;
        this.adress = adress;
    }

    public ArrayList<Object> toList() {
        //CPR,Name,City
        ArrayList<Object> lis = new ArrayList<>();
        lis.add(cpr);
        lis.add(name);
        lis.add(adress);
        return lis;
    }


}

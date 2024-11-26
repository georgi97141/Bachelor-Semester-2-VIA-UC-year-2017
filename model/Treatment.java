package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Treatment {
    private String treatment;
    private Date treatedOn;

    private String doctor;
    private String patient;


    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public Date getTreatedOn() {
        return treatedOn;
    }

    public void setTreatedOn(Date treatedOn) {
        this.treatedOn = treatedOn;
    }

    public Treatment(String treatment, Date treatedOn, String p, String mp) {
        this.treatment = treatment;
        this.treatedOn = treatedOn;
        this.patient = p;
        this.doctor = mp;
    }

    public ArrayList<Object> toList() {
        ArrayList<Object> lis = new ArrayList<>();
        lis.add(patient);
        lis.add(treatment);
        lis.add(doctor);
        lis.add(treatedOn);
        return lis;
    }


}

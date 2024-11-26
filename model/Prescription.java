package model;

import java.sql.Date;
import java.util.ArrayList;

public class Prescription {
    private String medicinName;
    private int renewals;
    private String continous;
    private Date prescripedOn;
    private String prescriber;
    private String patient;
    private String disease;
    //CPR,Treatment,ID,TreatedOn


    public String getPrescriber() {
        return prescriber;
    }

    public void setPrescriber(String prescriber) {
        this.prescriber = prescriber;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getMedicinName() {
        return medicinName;
    }

    public void setMedicinName(String medicinName) {
        this.medicinName = medicinName;
    }

    public int getRenewals() {
        return renewals;
    }

    public void setRenewals(int renewals) {
        this.renewals = renewals;
    }

    public String isContinous() {
        return continous;
    }

    public void setContinous(String continous) {
        this.continous = continous;
    }

    public Date getPrescripedOn() {
        return prescripedOn;
    }

    public void setPrescripedOn(Date prescripedOn) {
        this.prescripedOn = prescripedOn;
    }

    public Prescription(String medicinName, int renewals, String continous,
                        Date prescripedOn, String patient, String prescriber, String disease) {
        this.medicinName = medicinName;
        this.renewals = renewals;
        this.continous = continous;
        this.prescripedOn = prescripedOn;
        this.patient = patient;
        this.prescriber = prescriber;
        this.disease = disease;
    }

    //CPR,ID,DiseaseID,MedicalProcedure,Renewals,"
    //+"Continous,DatePrescribed) "
    public ArrayList<Object> toList() {
        //CPR,Name,City
        ArrayList<Object> lis = new ArrayList<>();
        lis.add(patient);
        lis.add(prescriber);
        lis.add(disease);
        lis.add(medicinName);
        lis.add(renewals);
        lis.add(continous);
        lis.add(prescripedOn);
        return lis;
    }


}

package model;

import java.util.ArrayList;

public class MP {
    private String id, name, sp;

    public String getId() {
        return id;
    }

    public void setId(String iD) {
        id = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

    public MP(String id, String name, String specialization) {
        this.id = id;
        this.name = name;
        sp = specialization;
    }

    //ID,Name,Speciality
    public ArrayList<Object> toList() {
        ArrayList<Object> lis = new ArrayList<>();
        lis.add(id);
        lis.add(name);
        lis.add(sp);
        return lis;

    }


}

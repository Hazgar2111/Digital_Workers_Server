package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class Prikazy implements Serializable {

    private int id;
    private String nomer;
    private String date;
    private String description;
    private String type;
    private ArrayList<String> naKogoPrikaz;
    private static final long serialVersionUID=1L;


    public Prikazy(int id, String nomer, String date, String description, String type, ArrayList<String> naKogoPrikaz) {
        this.id = id;
        this.nomer = nomer;
        this.date = date;
        this.description = description;
        this.type = type;
        this.naKogoPrikaz = naKogoPrikaz;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<String> getNaKogoPrikaz() {
        return naKogoPrikaz;
    }

    public void setNaKogoPrikaz(ArrayList<String> naKogoPrikaz) {
        this.naKogoPrikaz = naKogoPrikaz;
    }

    public Prikazy(String nomer, String date, String description, String type, ArrayList<String> naKogoPrikaz) {
        this.nomer = nomer;
        this.date = date;
        this.description = description;
        this.type = type;
        this.naKogoPrikaz = naKogoPrikaz;
    }
}
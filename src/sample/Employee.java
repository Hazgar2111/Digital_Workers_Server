package sample;

import java.io.Serializable;

public class Employee implements Serializable {
    private int id;
    private String name;
    private String middle_name;
    private String surname;
    private String phone_number;
    private String dolzhnost;
    private String datePriema;
    private String pass;
    private String login;
    private String trud_dogovor;
    private String email;
    private static final long serialVersionUID=1L;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getDolzhnost() {
        return dolzhnost;
    }

    public void setDolzhnost(String dolzhnost) {
        this.dolzhnost = dolzhnost;
    }

    public String getDatePriema() {
        return datePriema;
    }

    public void setDatePriema(String datePriema) {
        this.datePriema = datePriema;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getTrud_dogovor() {
        return trud_dogovor;
    }

    public void setTrud_dogovor(String trud_dogovor) {
        this.trud_dogovor = trud_dogovor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public  Employee() {

    }


    public Employee (int id, String name, String middle_name, String surname, String phone_number, String dolzhnost, String datePriema, String pass, String login, String trud_dogovor, String email) {
        this.id = id;
        this.name = name;
        this.middle_name = middle_name;
        this.surname = surname;
        this.phone_number = phone_number;
        this.dolzhnost = dolzhnost;
        this.datePriema = datePriema;
        this.pass = pass;
        this.login = login;
        this.trud_dogovor = trud_dogovor;
        this.email = email;
    }


    public Employee (String name, String middle_name, String surname, String phone_number, String dolzhnost, String datePriema, String pass, String login, String trud_dogovor, String email) {
        this.name = name;
        this.middle_name = middle_name;
        this.surname = surname;
        this.phone_number = phone_number;
        this.dolzhnost = dolzhnost;
        this.datePriema = datePriema;
        this.pass = pass;
        this.login = login;
        this.trud_dogovor = trud_dogovor;
        this.email = email;
    }
}

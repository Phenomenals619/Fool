package myPack;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class CheckerBean {

    private String name, age, hob, email, gender, error;

    public CheckerBean() {
        error = "";
    }

    public void setName(String n) {
        name = n;
    }

    public void setAge(String a) {
        age = a;
    }

    public void setHob(String h) {
        hob = h;
    }

    public void setEmail(String e) {
        email = e;
    }

    public void setGender(String g) {
        gender = g;
    }

    public void setError(String e) {
        error = e;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getHob() {
        return hob;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getError() {
        return error;
    }

    public boolean validate() {
        boolean res = true;
        if (name.trim().equals("")) {
            error += "<br>Enter First Name";
            res = false;
        }
        if (age.length() > 2) {
            error += "<br>Age Invalid";
            res = false;
        }
        return res;
    }
}

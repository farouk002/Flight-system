// Name :Farouk Kotob

import java.util.ArrayList;

public class Passenger {
    private String name, passportNum, seatNum;

    public Passenger(){
        name = "";
        passportNum = "";
        seatNum = "";
    }

    public Passenger(String name, String passportNum, String seatNum) {
        this.name = name;
        this.passportNum = passportNum;
        this.seatNum = seatNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportNum() {
        return passportNum;
    }

    public void setPassportNum(String passportNum) {
        this.passportNum = passportNum;
    }

    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }

    public String toString(){
        return "Name: " + name + "\tPassport Num: " + passportNum + "\tSeat Num: " + seatNum;
    }

    public boolean equals(Object other){
        if(this == other) return true;
        Passenger o = (Passenger)other;
        if(this.name.equals(o.name)) return true;
        if(this.passportNum.equals(o.passportNum)) return true;
        return false;
    }
}


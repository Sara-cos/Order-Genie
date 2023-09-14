package com.tesseract.ordergenie.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

public class LoggedInDetails {
    Employee e=new Employee();
    LocalDate date;
    boolean loggedIn;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }


}

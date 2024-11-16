package com.mehrana.entity;

import java.sql.Date;
import java.time.LocalDate;

public class Leave {

    private int id;

    private Date cancelEarlyDate;
    private Date startDate;
    private Date endDate;

    private Personnel personnel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCancelEarlyDate() {
        return cancelEarlyDate;
    }

    public void setCancelEarlyDate(Date cancelEarlyDate) {
        this.cancelEarlyDate = cancelEarlyDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "id=" + id +
                ", cancelEarlyDate=" + cancelEarlyDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", personnel=" + personnel +
                '}';
    }
}




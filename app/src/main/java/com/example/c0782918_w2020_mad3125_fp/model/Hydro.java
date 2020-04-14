package com.example.c0782918_w2020_mad3125_fp.model;

import java.util.Date;

public class Hydro extends Bill {

    private String agencyName;
    private String unitsConsumed;

    public Hydro(String billID, BillType billType, Date billDate, Double billTotal, String agencyName, String unitsConsumed) {
        super(billID, billType, billDate, billTotal);

        this.agencyName = agencyName;
        this.unitsConsumed = unitsConsumed;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getUnitsConsumed() {
        return unitsConsumed;
    }

    public void setUnitsConsumed(String unitsConsumed) {
        this.unitsConsumed = unitsConsumed;
    }
}

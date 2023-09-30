package com.as.drs.models;

import lombok.Data;

import java.util.Date;

@Data
public class MarginData {
    private Long dealerId;
    private double margin;
    private int points;
    private String startDate;
    private String endDate;


}

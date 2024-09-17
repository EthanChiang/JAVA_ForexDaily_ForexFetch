package com.example.dto;

public class CurrencyDto {
    private String date;
    private String usd;

    public CurrencyDto(String date, String usd) {
        this.date = date;
        this.usd = usd;
    }

    // Getters and setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUsd() {
        return usd;
    }

    public void setUsd(String usd) {
        this.usd = usd;
    }
}

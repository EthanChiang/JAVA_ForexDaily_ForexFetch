package com.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ForexResponse<T> {
    private StateCodeResponse error;
    private List<CurrencyDto> currency;

    public ForexResponse(StateCodeResponse error) {
        this.error = error;
    }
    public ForexResponse(StateCodeResponse error, List<CurrencyDto> currency) {
        this.error = error;
        this.currency = currency;
    }

    // Getters and setters
    public StateCodeResponse getError() {
        return error;
    }

    public void setError(StateCodeResponse error) {
        this.error = error;
    }

    public List<CurrencyDto> getCurrency() {
        return currency;
    }

    public void setCurrency(List<CurrencyDto> currency) {
        this.currency = currency;
    }
}

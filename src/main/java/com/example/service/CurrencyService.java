package com.example.service;

import com.example.dao.CurrencyDao;
import com.example.dto.CurrencyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CurrencyService {
    @Autowired
    CurrencyDao currencyDao;
    public List<CurrencyDto> getCurrencyData(LocalDate startDate, LocalDate endDate) {
        return currencyDao.getAllCurrency(startDate,endDate);
    }

}

package com.example.dao;

import com.example.dto.CurrencyDto;
import com.example.rowmapper.CurrencyRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CurrencyDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Integer createCurrency(String rate, String date) {
        String sql = "INSERT INTO exchange_rates(usd_to_ntd,record_time) " +
                "VALUES (:usd_to_ntd,:record_time)";
        Map<String, Object> map = new HashMap<>();
        map.put("usd_to_ntd",rate);
        map.put("record_time",date);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
        int currencyId = keyHolder.getKey().intValue();

        return currencyId;
    }

    public List<CurrencyDto> getAllCurrency(LocalDate startDate, LocalDate endDate) {
            String sql = "select usd_to_ntd,record_time from exchange_rates where record_time between :startDate and :endDate";
            Map<String, Object> map = new HashMap<>();
            map.put("startDate",startDate);
            map.put("endDate",endDate);

        return namedParameterJdbcTemplate.query(sql,map, new CurrencyRowMapper());
    }

}

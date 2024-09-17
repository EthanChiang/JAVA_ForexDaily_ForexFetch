package com.example.rowmapper;

import com.example.dto.CurrencyDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrencyRowMapper implements RowMapper<CurrencyDto> {

    @Override
    public CurrencyDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        // 這裡將 ResultSet 中的列值映射到 CurrencyDataResponse 對象

        String usd = rs.getString("usd_to_ntd");
        String date = rs.getString("record_time");
        return new CurrencyDto(date, usd);
    }
}

package com.example.controller;

import com.example.dto.*;
import com.example.service.ForexService;
import com.example.service.CurrencyService;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ApiController {

    @Autowired
    private ForexService forexService;

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/callApi")
    public void callExternalApi() throws JSONException {
        forexService.setJsonData(forexService.callApi());
        forexService.insertToDB();
    }

    @PostMapping("/getForexData")
    public ResponseEntity<ForexResponse<?>> fetchDataByTimeRange(@RequestBody ForexDto request) {
        // 校驗日期是否符合範圍（1年前到當下日期-1天）
        LocalDate startDate = LocalDate.parse(request.getStartDate(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        LocalDate endDate = LocalDate.parse(request.getEndDate(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        LocalDate oneYearAgo = LocalDate.now().minusYears(1);
        LocalDate yesterday = LocalDate.now().minusDays(1);


        if (startDate.isBefore(oneYearAgo) || endDate.isAfter(yesterday) || startDate.isAfter(endDate)) {
            // 如果日期不符合規則，回傳錯誤代碼
            StateCodeResponse errorResponse = new StateCodeResponse("E001", "日期區間不符");
            ForexResponse<StateCodeResponse> fail = new ForexResponse<>(errorResponse);
            System.out.println("111111111");
            return new ResponseEntity<>(fail, HttpStatus.BAD_REQUEST);
        } else {
            List<CurrencyDto> data= currencyService.getCurrencyData(startDate,endDate);
            System.out.println("222222222");
            // 日期格式转换
            List<CurrencyDto> convertedData = data.stream()
                    .map(currency -> {
                        // 解析原日期时间格式
                        DateTimeFormatter originalFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        LocalDateTime dateTime = LocalDateTime.parse(currency.getDate(), originalFormatter);

                        // 转换为新日期格式
                        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
                        String formattedDate = dateTime.toLocalDate().format(newFormatter);

                        // 创建新的 CurrencyDataResponse 实例
                        return new CurrencyDto(formattedDate, currency.getUsd());
                    })
                    .collect(Collectors.toList());
            convertedData.stream().forEach(System.out::println);



            StateCodeResponse successResponse = new StateCodeResponse("0000", "成功");
            ForexResponse<StateCodeResponse> success = new ForexResponse<>(successResponse, convertedData);
            return new ResponseEntity<>(success, HttpStatus.BAD_REQUEST);
        }
    }
}


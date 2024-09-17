package com.example.service;

import com.example.dao.CurrencyDao;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@Service
public class ForexService {

    @Autowired
    CurrencyDao currencyDao;

    private RestTemplate restTemplate = new RestTemplate();
    private String jsonData = "";

    public void insertToDB() throws JSONException {
        String rate;
        String date;

        JSONArray resultJsonArray = new JSONArray(getJsonData());
       //測試代碼
       // System.out.println("JSON Data: " + jsonData);
        //測試代碼
        //        for (int i = 0; i < resultJsonArray.length(); i++) {
        //            JSONObject jsonObject = resultJsonArray.getJSONObject(i);
        //            System.out.println("USD/NTD: " + jsonObject.getString("USD/NTD") + ": date:: " + jsonObject.getString("Date"));
        //        }
        rate = resultJsonArray.getJSONObject(resultJsonArray.length()-1).getString("USD/NTD");
        date = resultJsonArray.getJSONObject(resultJsonArray.length()-1).getString("Date");
        currencyDao.createCurrency(rate,date);
    }

    public String callApi() {
        String url = "https://openapi.taifex.com.tw/v1/DailyForeignExchangeRates";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }

    @Scheduled(cron = "0 0 18 * * ?")
    public void callExternalApiAt6PM() {
        try {
            // 呼叫 API 並轉換資料
            callApi();
            insertToDB();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }
}

package com.example.firstspringboot.service;

import com.example.dao.CurrencyDao;
import com.example.service.ForexService;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ForexServiceTests {

    @Mock
    private CurrencyDao currencyDao;

    @Mock
    private ForexService forexServiceMock;

    @InjectMocks
    private ForexService forexService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // 初始化 mock 物件
    }

    @Test
    public void ForexService_callExternalApiAt6PM_ReturnForxeData() throws JSONException {

// 模擬 callApi() 正常執行
//        when(forexService.callApi()).thenReturn("Mock API Response");

        // 模擬 insertToDB() 的行為
//        doNothing().when(forexServiceMock).insertToDB();
//
//        // 執行測試
//        forexService.callExternalApiAt6PM();


//       when()

    //    doNothing().when(currencyDao.createCurrency(Mockito.any())).insertToDB();

        // 執行測試並確認不會崩潰
        //assertDoesNotThrow(() -> forexService.callExternalApiAt6PM());

        verify(forexServiceMock, times(1)).callApi();
        verify(forexServiceMock, times(1)).insertToDB();
    }

}

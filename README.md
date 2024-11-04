1.提供一批次每日 18:00 呼叫 API，取得外匯成交資料，並將每日的美元/台幣
欄位(USD/NTD)資料與日期(yyyy-MM-dd HH:mm:ss) insert 至 table，

2.提供一 forex API，從 DB 取出日期區間內美元/台幣的歷史資料。
日期區間僅限 1 年前~當下日期-1 天，若日期區間不符規 則，response 需回 error code E001，一次僅查詢一種幣別，如:美元 usd。 API Method:POST
API request: {
"startDate": "2024/01/01", "endDate": "2024/01/01", " currency ": "usd"
}
API response: Success:
{
"error": {
"code": "0000", "message": "成功"
}, 
"currency": [
{
"date": "20240103", "usd": "31.01"
}, {
"date": "20240104",
" usd": "31.016" }
]}
Failed: {
"error": {
"code": "E001",
"message": "日期區間不符"
} }

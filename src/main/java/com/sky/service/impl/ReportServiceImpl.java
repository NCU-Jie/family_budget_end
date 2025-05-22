        //遍历查询结果，填充到turnoverList中
        if(resultList != null) {
            for (Map map1 : resultList) {
                java.sql.Date sqlDate = (java.sql.Date) map1.get("order_date");
                LocalDate orderDate = sqlDate.toLocalDate(); // 将 java.sql.Date 转换为 java.time.LocalDate
                int dateIndex = dateList.indexOf(orderDate);
                Double turnover = (Double) map1.get("daily_amount");
                turnoverList.set(dateIndex, turnover);
            }
        }
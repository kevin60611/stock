package com.example.stock.service;

import java.util.Calendar;
import java.util.Date;

import com.example.stock.dto.PurchaseDto;
import com.example.stock.entity.Purchase;

public class PurchaseService {
    // 其他方法...

    public void add(PurchaseDto purchaseDto) {
        Purchase purchase = modelMapper.map(purchaseDto, Purchase.class);

        // 計算預計到貨日期
        Date expectedArrivalDate = calculateExpectedArrivalDate(purchaseDto.getDate(), purchaseDto.getPurchaseItems());
        purchase.setExpectedArrivalDate(expectedArrivalDate);

        purchaseRepository.save(purchase);
    }

    private Date calculateExpectedArrivalDate(Date orderDate, Set<PurchaseItemDto> purchaseItems) {
        // 根據商品的進貨期計算預計到貨日期的邏輯
        // 這裡只是一個示例，實際邏輯可能需要更複雜的計算
        // 這個邏輯可能需要根據商品的進貨期、供應商的送貨時間等因素來計算
        // 這裡僅作參考，請根據您的業務邏輯進行調整
        // 下面的示例只是將預計到貨日期設為訂單日期的10天後
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(orderDate);
        calendar.add(Calendar.DATE, 10);
        return calendar.getTime();
    }
}

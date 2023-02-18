package com.xb.order.service;

import com.xb.feign.StockFeignClient;
import com.xb.feign.StockFeignDo;
import com.xb.order.domain.OrderDo;
import com.xb.order.dto.OrderDto;
import com.xb.order.mapper.OrderMapper;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Objects;

@Slf4j
@Service
@RefreshScope
public class BuyService {

    @Autowired
    private OrderService orderService;

   @Autowired
    StockFeignClient stockFeignClient;

   @Value("${sleep.time}")
   Long sleeptime;

    @GlobalTransactional
    public OrderDo buy(OrderDo data) {
        if(Objects.isNull(data)){
            return null;
        }

        OrderDo orderDo = orderService.create(data);
        this.deduct(orderDo.getGoodsNo());
        try {
            Thread.sleep(sleeptime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.deduct(123L);
        return orderDo;
    }

    public String deduct(Long goodsNo){
        StockFeignDo stockFeignDo=new StockFeignDo();
        String currentStock=null;
        try {
            stockFeignDo.setGoodsNo(goodsNo);
            stockFeignDo.setStockNum(1L);
             currentStock = stockFeignClient.update(stockFeignDo);
            log.info("stockFeignClient 库存:{}", currentStock);
        }catch (Exception ex){
            log.info("cuowu:",ex);
            throw ex;
        }
        return currentStock;
    }
}

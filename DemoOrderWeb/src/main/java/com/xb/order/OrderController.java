package com.xb.order;


import com.xb.order.domain.OrderDo;
import com.xb.order.service.BuyService;
import com.xb.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    BuyService buyService;

    @GetMapping("/getNo")
    public String getNo(Long no){
        log.info("getNo:{}",no);
        return "";
    }

    @PostMapping("/query")
    public String queryOrder(OrderDo orderDo){
        log.info("queryOrder:{}",orderDo);
        orderService.query(orderDo);
        return "hello";
    }

    @PostMapping("/buy")
    public String buy(@RequestBody  OrderDo orderDo){
        String resutl=buyService.buy(orderDo).toString();
        return resutl;
    }
}

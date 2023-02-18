package com.xb.stock;


import com.xb.stock.StockDo;
import com.xb.stock.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
@Slf4j
public class StockController {
    @Autowired
    StockService stockService;

    @GetMapping("/getNo")
    public String getNo(Long no){
        log.info("getNo:{}",no);
        return "";
    }

    @PostMapping("/getId")
    public String getId(Long id){
        log.info("getId:{}",id);
        stockService.getId(id);
        return "hello";
    }

    @PostMapping("/create")
    public String createStock(@RequestBody StockDo orderDo){
        String resutl= stockService.create(orderDo).toString();
        return resutl;
    }

    @PostMapping("/update")
    public String update(@RequestBody StockDo stockDo){
        String resutl= stockService.update( stockDo).toString();
        return resutl;
    }


}

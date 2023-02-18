package com.xb.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "demoStockWeb")
public interface StockFeignClient {
    @PostMapping("/stock/update")
    public String update(@RequestBody StockFeignDo stockFeignDo);
}

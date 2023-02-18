package com.xb.feign;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
public class StockFeignDo implements Serializable {

    private Long id;

    private Long stockNum;

    private Long goodsNo;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}

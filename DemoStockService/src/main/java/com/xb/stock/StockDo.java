package com.xb.stock;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


@Data
public class StockDo implements Serializable {

    private Long id;

    private Long stockNum;

    private Long goodsNo;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}

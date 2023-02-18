package com.xb.order.domain;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;


@Data
@ToString
public class OrderDo {

    private Long id;

    private Long orderNo;

    private BigDecimal price;

    private String name;

    private Long goodsNo;

    private Date createTime;

}

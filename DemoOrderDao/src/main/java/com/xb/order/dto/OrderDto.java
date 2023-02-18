package com.xb.order.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;


@Data
@Entity(name="tb_order")
public class OrderDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="order_no")
    private Long orderNo;

    @Column(name="price")
    private BigDecimal price;

    @Column(name="name")
    private String name;

    @Column(name="goods_no")
    private Long goodsNo;

    @Column(name="create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}

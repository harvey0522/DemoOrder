package com.xb.order.service;

import com.xb.order.domain.OrderDo;

import java.util.List;

public interface OrderService {

    public List<OrderDo> query(OrderDo data);

    public OrderDo create(OrderDo data);


}

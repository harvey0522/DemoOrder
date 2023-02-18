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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    StockFeignClient stockFeignClient;

    @Override
    public List<OrderDo> query(OrderDo data) {
        log.info("this is query:{}",data.toString());
        return null;
    }

    @Override
    public OrderDo create(OrderDo data) {
        if(Objects.isNull(data)){
            return null;
        }

        data.setCreateTime(new Date());

        OrderDto orderDto =new OrderDto();
        BeanUtils.copyProperties(data,orderDto);

        OrderDto save = orderMapper.save(orderDto);

        log.info("this is create:{}",save.toString());
        BeanUtils.copyProperties(save,data);
        return data;
    }
}

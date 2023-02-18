package com.xb.order.mapper;


import com.xb.order.dto.OrderDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper extends JpaRepository<OrderDto,Long> {

}

package com.xb.stock.mapper;


import com.xb.stock.dto.StockDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockMapper extends JpaRepository<StockDto,Long> {

}

package com.xb.stock;

import com.xb.stock.dto.StockDto;
import com.xb.stock.mapper.StockMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Service
public class StockService {

    @Resource
    StockMapper stockMapper;

    public StockDo getId(Long id){
        StockDo stockDo=new StockDo();
        Optional<StockDto> byId = stockMapper.findById(id);
        BeanUtils.copyProperties(byId.get(),stockDo);
        return stockDo;
    }

    public StockDo create(StockDo stockDo){

        StockDto stockDto=new StockDto();
        BeanUtils.copyProperties(stockDo,stockDto);
        stockDto.setCreateTime(new Date());
        StockDto save = stockMapper.save(stockDto);
        BeanUtils.copyProperties(save,stockDo);

        return stockDo;
    }

    public Long update(StockDo stockDo){
        StockDto stockDoQuery =new StockDto();
        stockDoQuery.setGoodsNo(stockDo.getGoodsNo());
        Example<StockDto> example = Example.of(stockDoQuery);

        Optional<StockDto> one = stockMapper.findOne(example);
        if(!one.isPresent()){
            return 0L;
        }
        StockDto query=one.get();
        Long stockNumDB = query.getStockNum();
        Long current=stockNumDB-stockDo.getStockNum();
        query.setStockNum(current);
        query.setCreateTime(new Date());
        Integer version =query.getVersion();

        query.setVersion(version++);

        StockDto save = stockMapper.save(query);
        return save.getStockNum();
    }
}

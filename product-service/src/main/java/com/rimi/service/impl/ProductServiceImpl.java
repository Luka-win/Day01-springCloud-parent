package com.rimi.service.impl;

import com.rimi.bean.Goods;
import com.rimi.mapper.ProductMapper;
import com.rimi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luka
 * @version V1.0
 * @date 2021 2021/7/28 0028 11:00
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Goods> findAll() {
        return productMapper.findAll();
    }

    @Override
    public Goods findById(Integer gid) {
        return productMapper.findById(gid).get();
    }
}

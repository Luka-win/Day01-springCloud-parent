package com.rimi.service;

import com.rimi.bean.Goods;

import java.util.List;

public interface ProductService {

    /**
     * 查询所有商品
     * @return
     */
    List<Goods> findAll();

    Goods findById(Integer gid);
}

package com.rimi.controller;

import com.rimi.bean.Goods;
import com.rimi.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author luka
 * @version V1.0
 * @date 2021 2021/7/28 0028 10:10
 */
@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public List<Goods> findProduct() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Goods> goodsList = productService.findAll();
        log.info("---商品查询成功{}",goodsList);
        return goodsList;
    }

    @GetMapping("/{gid}")
    public Goods getProductById(@PathVariable("gid") Integer gid) {

        if (gid == 1) {
            throw new RuntimeException("数据异常");
        }

        return productService.findById(gid);
    }

}

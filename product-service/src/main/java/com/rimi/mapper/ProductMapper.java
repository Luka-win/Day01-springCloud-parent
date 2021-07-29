package com.rimi.mapper;

import com.rimi.bean.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 只需要继承JpaRepository接口，指定泛型为表对应的实体类名称和主键类型
 */
public interface ProductMapper extends JpaRepository<Goods,Integer> {

}

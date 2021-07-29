package com.rimi.bean;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "goods")
public class Goods {

  @Id
  // 设置主键id的自增长模式
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer gid;
  //@Column(name = "gname")
  private String gname;
  private String gimg;
  private Double gprice;
  private Integer gstock;
  private Date maintaindate;
  private String classify;
  private String gdescribe;

}

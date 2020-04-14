package top.dengwq.springboot_crud.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by dengweiqiang on 2020/4/14
 */
@Data
@ToString
@EqualsAndHashCode
public class Account {
    private int id ;
    private String name ;
    private double money;
}

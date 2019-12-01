package com.yxycoding.mybatisplus.demo.auser.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * Spring Boot Demo Orm 系列示例表
 * </p>
 *
 * @author yangxy
 * @since 2019-11-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrmRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名
     */
//    @TableField(whereStrategy= FieldStrategy.NOT_EMPTY)
    private String name;


}

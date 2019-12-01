package com.yxycoding.mybatisplus.demo.generatorext.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 用户和对应角色一个sql查询出来
 * </p>
 *
 * @package:  com.yxycoding.mybatisplus.demo.generatorext.entity
 * @description: 用户和对应角色一个sql查询出来
 * @author: yangxya
 * @date: Created in 2019-12-01 18:51:27
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: yangxya
 */
@Data
@TableName("user_Role_rel")
//@ApiModel(description = "用户和对应角色一个sql查询出来")
@EqualsAndHashCode(callSuper = true)
public class UserRoleRel extends Model<UserRoleRel> {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
//    //@ApiModelProperty(value = " ")
    private Integer id;
    /**
     *
     */
    //@ApiModelProperty(value = " ")
    private String name;
    /**
     *
     */
    //@ApiModelProperty(value = " ")
    private String password;
    /**
     *
     */
    //@ApiModelProperty(value = " ")
    private String salt;
    /**
     *
     */
    //@ApiModelProperty(value = " ")
    private String email;
    /**
     *
     */
    //@ApiModelProperty(value = " ")
    private String phoneNumber;
    /**
     *
     */
    //@ApiModelProperty(value = " ")
    private Integer status;
    /**
     *
     */
    //@ApiModelProperty(value = " ")
    private Date createTime;
    /**
     *
     */
    //@ApiModelProperty(value = " ")
    private Date lastLoginTime;
    /**
     *
     */
    //@ApiModelProperty(value = " ")
    private Date lastUpdateTime;
    /**
     *
     */
    //@ApiModelProperty(value = " ")
    private Integer roleId;
    /**
     *
     */
    //@ApiModelProperty(value = " ")
    private String rolename;

}
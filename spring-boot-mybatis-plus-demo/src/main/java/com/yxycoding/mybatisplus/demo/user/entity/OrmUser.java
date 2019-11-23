package com.yxycoding.mybatisplus.demo.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * Spring Boot Demo Orm 系列示例表
 * </p>
 *
 * @author yangxy
 * @since 2019-11-23
 */
public class OrmUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 加密后的密码
     */
    private String password;

    /**
     * 加密使用的盐
     */
    private String salt;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 状态，-1：逻辑删除，0：禁用，1：启用
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 上次登录时间
     */
    private Date lastLoginTime;

    /**
     * 上次更新时间
     */
    private Date lastUpdateTime;

    public Integer getId() {
        return id;
    }

    public OrmUser setId(Integer id) {
        this.id = id;
        return this;
    }
    public String getName() {
        return name;
    }

    public OrmUser setName(String name) {
        this.name = name;
        return this;
    }
    public String getPassword() {
        return password;
    }

    public OrmUser setPassword(String password) {
        this.password = password;
        return this;
    }
    public String getSalt() {
        return salt;
    }

    public OrmUser setSalt(String salt) {
        this.salt = salt;
        return this;
    }
    public String getEmail() {
        return email;
    }

    public OrmUser setEmail(String email) {
        this.email = email;
        return this;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public OrmUser setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
    public Integer getStatus() {
        return status;
    }

    public OrmUser setStatus(Integer status) {
        this.status = status;
        return this;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public OrmUser setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public OrmUser setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
        return this;
    }
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public OrmUser setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }

    @Override
    public String toString() {
        return "OrmUser{" +
            "id=" + id +
            ", name=" + name +
            ", password=" + password +
            ", salt=" + salt +
            ", email=" + email +
            ", phoneNumber=" + phoneNumber +
            ", status=" + status +
            ", createTime=" + createTime +
            ", lastLoginTime=" + lastLoginTime +
            ", lastUpdateTime=" + lastUpdateTime +
        "}";
    }
}

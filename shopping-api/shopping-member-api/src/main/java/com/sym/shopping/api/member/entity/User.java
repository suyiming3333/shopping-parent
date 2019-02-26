package com.sym.shopping.api.member.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @ClassName: as
 * @Auther: Suyiming3333
 * @Date: 2019/2/26 0026 13:01
 * @Description:
 * @Version:
 */
@Getter
@Setter
public class User {

    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private Date created;
    private Date updated;
}

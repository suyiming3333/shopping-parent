package com.sym.shopping.api.member.controller;

import com.sym.shopping.api.member.entity.User;
import com.sym.shopping.base.ResponseResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName: MemberControllerI
 * @Auther: Suyiming3333
 * @Date: 2019/2/27 0027 13:14
 * @Description:
 * @Version:
 */

public interface MemberControllerI {

    @RequestMapping("/test")
    ResponseResult testMember();

    @RequestMapping(value = "/getUserById",produces = { "application/json;charset=UTF-8" })
    ResponseResult getUserById();

    @RequestMapping("/doRegister")
    ResponseResult register(@RequestBody User user, @RequestParam String token);
}

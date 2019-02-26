package com.sym.shopping.member.controller;

import com.sym.shopping.api.member.entity.User;
import com.sym.shopping.api.member.service.MemberService;
import com.sym.shopping.base.BaseController;
import com.sym.shopping.base.ResponseResult;
import com.sym.shopping.base.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class MemberController extends BaseController {
    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/test",produces = { "application/json;charset=UTF-8" })
    public ResponseResult testMember(){
        Map map = new HashMap();
        try{
            map = memberService.testRest();
            return setResultSuccess(map);
        }catch (Exception e){
            e.printStackTrace();
            return setResultError("接口调用失败");
        }
    }

    @RequestMapping(value = "/getUserById",produces = { "application/json;charset=UTF-8" })
    public ResponseResult getUserById(){
        User user = new User();
        try{
            user = memberService.getUserByUserId(1L);
            return setResultSuccess(user);
        }catch (Exception e){
            e.printStackTrace();
            return setResultError("接口调用失败");
        }
    }

    @RequestMapping(value = "/doRegister")
    public ResponseResult register(@RequestBody User user) {
        String passWord=user.getPassword();
        String newPassWord= MD5Util.MD5(passWord);
        user.setPassword(newPassWord);
        Integer insertUser = memberService.addUser(user);
        if (insertUser <= 0) {
            return setResultError("注册失败!");
        }
        return setResultSuccess();
    }
}

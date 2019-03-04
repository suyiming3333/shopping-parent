package com.sym.shopping.member.controller;

import com.sym.shopping.api.member.controller.MemberControllerI;
import com.sym.shopping.api.member.entity.User;
import com.sym.shopping.api.member.service.MemberService;
import com.sym.shopping.base.BaseController;
import com.sym.shopping.base.ResponseResult;
import com.sym.shopping.base.utils.MD5Util;
import com.sym.shopping.member.service.impl.MQMessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class MemberController extends BaseController implements MemberControllerI{
    @Autowired
    private MemberService memberService;

    @Autowired
    private MQMessageSender mqMessageSender;

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

    /**
     * 接收row data json格式的user对象字符串，可自动转回user对象
     * @param user
     * @param token
     * @return
     * 继承接口MemberControllerI @RequestParam可以再次声明，但RequestBody必须声明，否则接收不到参数
     */
    public ResponseResult register(@RequestBody User user, @RequestParam String token) throws Exception {
        String passWord=user.getPassword();
        String newPassWord= MD5Util.MD5(passWord);
        user.setPassword(newPassWord);
        Integer insertUser = memberService.addUser(user);
        if (insertUser <= 0) {
            return setResultError("注册失败!");
        }
        mqMessageSender.send(user.getUsername());
        return setResultSuccess();
    }
}

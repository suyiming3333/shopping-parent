package com.sym.shopping.member.controller;

import com.sym.shopping.api.member.MemberService;
import com.sym.shopping.base.BaseController;
import com.sym.shopping.base.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
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
}

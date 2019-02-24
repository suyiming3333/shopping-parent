package com.sym.shopping.member.service.impl;

import com.sym.shopping.api.member.MemberService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService {
    @Override
    public Map<String, Object> testRest() {
        Map map = new HashMap();
        map.put("name","suyiming");
        return map;
    }
}

package com.sym.shopping.member.service.impl;

import com.sym.shopping.api.member.service.MemberService;
import com.sym.shopping.api.member.entity.User;
import com.sym.shopping.member.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, Object> testRest() {
        Map map = new HashMap();
        map.put("name","suyiming");
        return map;
    }

    @Override
    public User getUserByUserId(Long userId){
        return userMapper.findByID(userId);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insertUser(user);
    }
}

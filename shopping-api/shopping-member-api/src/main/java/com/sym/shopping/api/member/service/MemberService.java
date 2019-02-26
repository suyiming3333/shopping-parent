package com.sym.shopping.api.member.service;

import com.sym.shopping.api.member.entity.User;

import java.util.Map;

public interface MemberService {
    Map<String, Object> testRest();

    User getUserByUserId(Long userId);

    int addUser(User user);
}

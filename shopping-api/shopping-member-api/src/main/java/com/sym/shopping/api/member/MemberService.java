package com.sym.shopping.api.member;

import com.sym.shopping.base.entity.UserEntity;

import java.util.Map;

public interface MemberService {
    Map<String, Object> testRest();

    UserEntity getUserByUserId(Long userId);
}

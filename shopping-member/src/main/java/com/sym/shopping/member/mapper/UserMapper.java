package com.sym.shopping.member.mapper;

import com.sym.shopping.api.member.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName: as
 * @Auther: Suyiming3333
 * @Date: 2019/2/26 0026 13:02
 * @Description:
 * @Version:
 */
@Mapper
public interface UserMapper {

    //@Select("select  id,username,password,phone,email,created,updated from mb_user where id =#{userId}")
    //User findByID(@Param("userId") Long userId);
    User findByID(Long userId);

    @Insert("INSERT  INTO `mb_user`  (username,password,phone,email,created,updated) VALUES (#{username}, #{password},#{phone},#{email},#{created},#{updated});")
    Integer insertUser(User user);
}

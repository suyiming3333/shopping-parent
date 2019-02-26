package com.sym.shoppingmybatis.mapper;

import com.sym.shoppingmybatis.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName: as
 * @Auther: Suyiming3333
 * @Date: 2019/2/26 0026 13:02
 * @Description:
 * @Version:
 */
@Mapper
public interface UserMapper {

    @Select("select  id,username,password,phone,email,created,updated from mb_user where id =#{userId}")
    UserEntity findByID(@Param("userId") Long userId);

    @Insert("INSERT  INTO `mb_user`  (username,password,phone,email,created,updated) VALUES (#{username}, #{password},#{phone},#{email},#{created},#{updated});")
    Integer insertUser(UserEntity userEntity);
}

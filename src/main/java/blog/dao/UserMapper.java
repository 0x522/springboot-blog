package blog.dao;

import blog.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
    @Select("select * from user where username = #{username}")
    User findUserByUsername(@Param("username") String username);

    @Insert("insert into user (username,encrypted_password,created_at,updated_at) " +
            "values(#{username},#{encryptedPassword},now(),now())")
    void save(@Param("username") String username, @Param("encryptedPassword") String encryptedPassword);
}

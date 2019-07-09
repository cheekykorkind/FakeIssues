package hello;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import hello.Member;

public interface UserMapper {
    public Member readUser(String username);
    public List<String> readAuthority(String username);
    public void insertUser(Member user);
}

package hello;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import hello.Member;
import hello.Issue;

public interface UserMapper {
    public Member readUser(String username);
    public List<String> readAuthority(String username);
    public void insertUser(Member user);
    public void deleteUser(Long id);
    public void createManyIssues(List<Issue> issues);
    public List<Issue> selectIssues(Long userId);
    public Member findIssuesByUserId(Long userId);
}

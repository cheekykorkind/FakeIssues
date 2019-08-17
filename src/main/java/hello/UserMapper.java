package hello;

import java.util.List;

import hello.Member;
import hello.Issue;

public interface UserMapper {
    // create
    public void create(Member user);

    // delete
    public void delete(long id);

    // update


    // select
    public Member findById(long id);
    public Member findByUsername(String username);
    public List<String> readAuthority(String username);
    public long lastId();
    public long length();


    // hasMany create
    public void createManyIssues(List<Issue> issues);
    

    // hasMany delete
    public void deleteManyIssues(long userId);
    

    // hasMany update
    public void updateManyIssues(Member user);

    // hasMany select
    public Member findIssuesByUserId(long userId);   
}

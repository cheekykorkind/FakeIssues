package hello;

import java.util.List;

import hello.Issue;

public interface IssueMapper {
    // create
    public void create(Issue issue);

    // delete
    public void delete(long id);

    // update


    // select
    public Issue findById(long id);
    public List<Issue> findByUserId(long userId);
    public long length();
    public long lastId();
    
}

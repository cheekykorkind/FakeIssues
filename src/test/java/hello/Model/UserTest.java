package hello;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;

import hello.Member;
import hello.Issue;
import hello.UserMapper;
import hello.IssueMapper;
import hello.ApplicationTest;

public class UserTest extends ApplicationTest
{
    private static final Logger LOG = LoggerFactory.getLogger(UserTest.class);

    @Autowired
    UserMapper userMapper;

    @Autowired
    IssueMapper issueMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void createTest() throws Exception
    {
        Member account = new Member();
        String name = "testUser";

        account.setUsername(name);
        account.setPassword(passwordEncoder.encode("testPassword"));
        account.setName("MyName");

        userMapper.create(account);

        long userId = userMapper.lastId();
        
        assertEquals(name, userMapper.findById(userId).getUsername());
    }

    @Test
    public void createManyIssuesTest() throws Exception
    {
        List<Issue> issues = new ArrayList<>();

        long beforeLength = issueMapper.length();
        
        Member account = new Member();
        String name = "testUser";

        account.setUsername(name);
        account.setPassword(passwordEncoder.encode("testPassword"));
        account.setName("MyName");

        userMapper.create(account);

        long userId = userMapper.lastId();

        for (long i = 0L; i < 3; i++) {
            Issue tempIssue = new Issue();
            tempIssue.setTitle("title" + String.valueOf(i));
            tempIssue.setContent("content" + String.valueOf(i));
            tempIssue.setUserId(userId);
            issues.add(tempIssue);
        }

        userMapper.createManyIssues(issues);

        assertEquals(beforeLength, issueMapper.length() - 3);

        userMapper.deleteManyIssues(userId);
        userMapper.delete(userId);
    }

    @Test
    public void findIssuesByUserIdTest() throws Exception
    {
        List<Issue> issues = new ArrayList<>();

        long beforeLength = issueMapper.length();
        
        Member account = new Member();
        String name = "testUser";

        account.setUsername(name);
        account.setPassword(passwordEncoder.encode("testPassword"));
        account.setName("MyName");

        userMapper.create(account);

        long userId = userMapper.lastId();

        for (long i = 0; i < 3; i++) {
            Issue tempIssue = new Issue();
            tempIssue.setTitle("title" + String.valueOf(i));
            tempIssue.setContent("content" + String.valueOf(i));
            tempIssue.setUserId(userId);
            issues.add(tempIssue);
        }

        userMapper.createManyIssues(issues);

        Member m = userMapper.findIssuesByUserId(userId);
        for (int i = 0; i < 3; i++) {
            assertEquals(issues.get(i).getTitle(), m.getIssues().get(i).getTitle());
        }
    }

    @Test
    public void updateManyIssuesTest() throws Exception
    {
        List<Issue> issues = new ArrayList<>();

        long beforeLength = issueMapper.length();
        
        Member account = new Member();
        String name = "testUser";

        account.setUsername(name);
        account.setPassword(passwordEncoder.encode("testPassword"));
        account.setName("MyName");

        userMapper.create(account);

        long userId = userMapper.lastId();

        for (long i = 0; i < 3; i++) {
            Issue tempIssue = new Issue();
            tempIssue.setTitle("title" + String.valueOf(i));
            tempIssue.setContent("content" + String.valueOf(i));
            tempIssue.setUserId(userId);
            issues.add(tempIssue);
        }

        userMapper.createManyIssues(issues);

        List<Issue> updates = new ArrayList<>();
        Member m = userMapper.findIssuesByUserId(userId);
        
        for (Issue issue : m.getIssues()) {
            long issueId = issue.getId();
            issue.setTitle("fix3Title" + String.valueOf(issueId));
            issue.setContent("fix3Content" + String.valueOf(issueId));
            updates.add(issue);
        }
        m.setIssues(updates);
        
        userMapper.updateManyIssues(m);

        Member newM = userMapper.findIssuesByUserId(userId);
        for (Issue issue : newM.getIssues()) {
            long issueId = issue.getId();
            issue.setTitle("fix3Title" + String.valueOf(issueId));
            issue.setContent("fix3Content" + String.valueOf(issueId));

            assertEquals(issue.getTitle(), "fix3Title" + String.valueOf(issueId));
            assertEquals(issue.getContent(), "fix3Content" + String.valueOf(issueId));
        }
    }
}

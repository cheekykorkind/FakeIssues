package hello;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hello.Issue;
import hello.UserMapper;
import hello.ApplicationTest;

public class IssueTest extends ApplicationTest
{
    private static final Logger LOG = LoggerFactory.getLogger(IssueTest.class);

    @Autowired
    UserMapper userMapper;

    @Test
    public void createManyTest() throws Exception
    {
        List<Issue> list1 = new ArrayList<>();
        LOG.debug("================================");

        for (Long i = 0L; i < 3; i++) {
            Issue tempIssue = new Issue();
            tempIssue.setTitle("title" + String.valueOf(i));
            tempIssue.setContent("content" + String.valueOf(i));
            tempIssue.setUserId(i);
            list1.add(tempIssue);
        }

        for (Issue issue : list1) {
            System.out.println(issue.getTitle());
            System.out.println(issue.getContent());
            System.out.println(issue.getUserId());
        }

        System.out.println(list1);

        LOG.debug("================================");

        userMapper.createManyIssues(list1);
    }
}

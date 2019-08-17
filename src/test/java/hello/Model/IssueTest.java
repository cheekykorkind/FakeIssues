package hello;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hello.Issue;
import hello.IssueMapper;
import hello.ApplicationTest;

public class IssueTest extends ApplicationTest
{
    private static final Logger LOG = LoggerFactory.getLogger(IssueTest.class);

    @Autowired
    IssueMapper issueMapper;

    @Test
    public void findByUserIdTest() throws Exception
    {
        List<Issue> issues = new ArrayList<>();

        long userId = 9999;

        long loopCounter = 0;
        for (; loopCounter < 3; loopCounter++) {
            Issue tempIssue = new Issue();
            tempIssue.setTitle("title" + String.valueOf(loopCounter));
            tempIssue.setContent("content" + String.valueOf(loopCounter));
            tempIssue.setUserId(userId);
            issueMapper.create(tempIssue);
        }

        issues = issueMapper.findByUserId(userId);
        assertEquals(loopCounter, issues.size());

        for (Issue issue : issues) {
            issueMapper.delete(issue.getId());
        }
    }
}

package hello;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hello.UserMapper;
import hello.RepositoriesMapper;
import hello.Repositories;
import hello.RepositoriesDao;
import hello.RepositoriyUsersMapper;
import hello.ApplicationTest;


public class RepositoriesTest extends ApplicationTest
{
    private static final Logger LOG = LoggerFactory.getLogger(RepositoriesTest.class);
    // LOG.info(String.format("%d", 3344));

    @Autowired
    RepositoriesMapper repositoriesMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    RepositoriesDao repositoriesDao;

    @Autowired
    RepositoriyUsersMapper repositoriyUsersMapper;

    @Test
    public void createTest() throws Exception
    {
        String name = "repositoryName";
        String description = "description";
        int type = 1;

        Repositories repositories = new Repositories();
        repositories.setName(name);
        repositories.setDescription(description);
        repositories.setType(type);

        long beforeRepositoriyUsersLength = repositoriyUsersMapper.length();

        repositoriesDao.create(userMapper.lastId(), repositories);

        assertEquals(name, repositoriesMapper.findById(repositoriesMapper.lastId()).getName());
        assertEquals(beforeRepositoriyUsersLength, repositoriyUsersMapper.length() - 1);
    }
}

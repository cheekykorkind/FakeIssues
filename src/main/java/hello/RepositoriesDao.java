package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hello.RepositoriesMapper;
import hello.Repositories;

@Repository
public class RepositoriesDao
{
    @Autowired
    RepositoriesMapper repositoriesMapper;

    @Transactional
    public boolean create(long userId, Repositories repository){
        repositoriesMapper.create(repository);

        repositoriesMapper.createRepositoryUsers(userId, repositoriesMapper.lastId());

        return true;
    }
}

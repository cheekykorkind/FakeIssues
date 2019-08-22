package hello;

import java.util.List;

import hello.Repositories;

public interface RepositoriesMapper {
    // create
    public void create(Repositories repository);
    public void createRepositoryUsers(long userId, long repositoryId);


    // delete
    public void delete(long id);

    // update


    // select
    public Repositories findById(long id);
    public long length();
    public long lastId();
}

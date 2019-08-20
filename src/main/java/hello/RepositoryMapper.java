package hello;

import java.util.List;

import hello.Repository;

public interface RepositoryMapper {
    // create
    public void create(Repository repository);

    // delete
    public void delete(long id);

    // update


    // select
    public Issue findById(long id);
    public long length();
    public long lastId();
}

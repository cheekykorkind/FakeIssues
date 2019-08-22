package hello;

import java.util.List;

import hello.RepositoriyUser;

public interface RepositoriyUsersMapper {
    // create
    public void create(RepositoriyUser repositoriyUser);

    // delete
    public void delete(long id);

    // update


    // select
    public Repositories findById(long id);
    public long length();
    public long lastId();
}

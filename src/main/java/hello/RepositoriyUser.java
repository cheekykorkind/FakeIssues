package hello;

public class RepositoriyUser
{
    protected long id;

    protected long userId;

    protected long repositoryId;

    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return this.userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRepositoryId() {
        return this.repositoryId;
    }
    public void setRepositoryId(long repositoryId) {
        this.repositoryId = repositoryId;
    }
}

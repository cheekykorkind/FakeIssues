package hello;

public class Repositories
{
    private long id;

    private String name;

    private String description;

    private int type;

    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getType() {
        return this.type;
    }
    public void setType(int type) {
        this.type = type;
    }
}

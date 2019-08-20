package hello;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RepositoryRequest
{
    private long id;

    @NotNull(message = "입력은 필수입니다")
    @Size(min=8, max=100, message = "리포지토리의 길이가 부적절합니다")
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

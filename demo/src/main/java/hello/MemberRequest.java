package hello;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MemberRequest {

    @NotNull(message = "입력은 필수입니다")
    @Size(min=8, max=30, message = "유저아이디의 길이가 부적절합니다")
    private String username;

    @NotNull(message = "입력은 필수입니다")
    @Min(value=8, message = "비밀번호의 길이가 부적절합니다")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

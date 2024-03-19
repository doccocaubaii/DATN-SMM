package edu.hust.shadowmiddleman.dto.account;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginDTO {

    @NotNull(message = "Không được bỏ trống")
    @Size(min = 1, max = 50, message = "Username phải từ 1-50 ký tự")
    private String username;
    @NotNull(message = "Không được bỏ trống")
    @Size(min = 4, max = 100, message = "Password phải từ 4-50 ký tự")
    private String password;

    private boolean rememberMe;

    // prettier-ignore
    @Override
    public String toString() {
        return "LoginVM{" +
                "username='" + username + '\'' +
                ", rememberMe=" + rememberMe +
                '}';
    }
}

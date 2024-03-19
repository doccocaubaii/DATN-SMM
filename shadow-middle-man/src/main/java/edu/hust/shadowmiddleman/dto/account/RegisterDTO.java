package edu.hust.shadowmiddleman.dto.account;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterDTO {
    private Integer id;

    @NotNull
    private String username;

    @NotNull
    private String fullname;
    
    private String avatarUrl;
    
    private String accountNumber;

    @NotNull
    private String role;

    @NotNull
    private String password;
    
    private Integer status;
}

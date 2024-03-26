package edu.hust.shadowmiddleman.dto.account;

import edu.hust.shadowmiddleman.common.enumpackage.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Integer id;

    private String username;

    private String fullname;

    private String avatarUrl;

    private String accountNumber;

    private RoleEnum role;

    private Integer status;

    private String jwt;

    private Double balance;
}

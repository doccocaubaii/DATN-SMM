package edu.hust.shadowmiddleman.dto.account;

import edu.hust.shadowmiddleman.common.enumpackage.GenderEnum;
import edu.hust.shadowmiddleman.common.enumpackage.RoleEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProfileDTO {

    @NotNull
    private String fullname;

    private String avatarUrl;

    private String accountNumber;

    @NotNull
    private RoleEnum role;

    private GenderEnum gender;
}

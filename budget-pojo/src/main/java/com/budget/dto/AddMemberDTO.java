package com.budget.dto;

import lombok.Data;

@Data
public class AddMemberDTO {

    private Long id;

    private String username;

    private String name;

    private String password;

    private String sex;

}

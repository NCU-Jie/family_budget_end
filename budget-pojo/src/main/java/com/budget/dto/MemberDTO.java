package com.budget.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MemberDTO implements Serializable {

    private Long id;

    private String username;

    private String name;

    private String password;

    private String sex;

}

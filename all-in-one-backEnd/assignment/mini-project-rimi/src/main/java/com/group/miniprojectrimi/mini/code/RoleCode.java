package com.group.miniprojectrimi.mini.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleCode {

    MANAGER("MANAGER","매니저"),
    MEMBER("MEMBER","멤버");

    private final String code;
    private final String name;

}

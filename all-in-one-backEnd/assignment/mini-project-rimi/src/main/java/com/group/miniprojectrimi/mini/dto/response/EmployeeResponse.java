package com.group.miniprojectrimi.mini.dto.response;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeResponse {

    /**
     * 사원명
     */
    private String name;
    /**
     * 역할
     */
    private String role;
    /**
     * 소속 팀 이름
     */
    private String teamName;
    /**
     * 생년월일
     */
    private LocalDate birthday;
    /**
     * 입사날짜
     */
    private LocalDate wordStartDate;

}

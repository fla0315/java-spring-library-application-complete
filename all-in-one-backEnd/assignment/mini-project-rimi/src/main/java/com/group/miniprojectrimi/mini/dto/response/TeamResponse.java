package com.group.miniprojectrimi.mini.dto.response;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TeamResponse {

    /**
     * 팀명
     */
    private String name;
    /**
     * 매니저
     */
    private Boolean manager;
    /**
     * 팀 인원 수
     */
    private Long memberCount;

}

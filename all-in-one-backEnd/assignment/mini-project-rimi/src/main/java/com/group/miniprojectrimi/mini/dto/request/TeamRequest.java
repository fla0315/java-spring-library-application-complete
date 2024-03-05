package com.group.miniprojectrimi.mini.dto.request;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TeamRequest {

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

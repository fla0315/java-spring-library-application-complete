package com.group.miniprojectrimi.mini.controller;

import com.group.miniprojectrimi.mini.dto.request.TeamRequest;
import com.group.miniprojectrimi.mini.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    //팀 등록
    @PostMapping("/team/save")
    public void saveTeamInfo(@RequestBody TeamRequest request) {
        teamService.saveTeamInfo(request);
    }


}

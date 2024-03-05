package com.group.miniprojectrimi.mini.controller;

import com.group.miniprojectrimi.mini.dto.request.TeamRequest;
import com.group.miniprojectrimi.mini.dto.response.TeamResponse;
import com.group.miniprojectrimi.mini.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @PostMapping("/team/save")
    public void saveTeamInfo(@RequestBody TeamRequest request) {
        teamService.saveTeamInfo(request);
    }

    @GetMapping("/team/inquiry")
    public List<TeamResponse> inquiryTeamInfos() {
        return teamService.inquiryTeamInfos();
    }

}

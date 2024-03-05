package com.group.miniprojectrimi.mini.service;

import com.group.miniprojectrimi.mini.domain.team.Team;
import com.group.miniprojectrimi.mini.domain.team.TeamRepository;
import com.group.miniprojectrimi.mini.dto.request.TeamRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    @Transactional
    public void saveTeamInfo(TeamRequest request) {
        teamRepository.save(Team.builder()
                                .name(request.getName())
                                .manager(ObjectUtils.defaultIfNull(request.getManager(),false))
                                .memberCount(ObjectUtils.defaultIfNull(request.getMemberCount(), 0L))
                                .build());
    }

}

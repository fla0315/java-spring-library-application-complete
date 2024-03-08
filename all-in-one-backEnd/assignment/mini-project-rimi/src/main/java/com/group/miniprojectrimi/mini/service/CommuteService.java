
package com.group.miniprojectrimi.mini.service;

import com.group.miniprojectrimi.mini.domain.commute.Commute;
import com.group.miniprojectrimi.mini.domain.commute.CommuteRepository;
import com.group.miniprojectrimi.mini.domain.employee.Employee;
import com.group.miniprojectrimi.mini.domain.employee.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommuteService {

    private final CommuteRepository commuteRepository;
    private final EmployeeRepository employeeRepository;

    //직원 출근
    @Transactional
    public void commuteEmployee(Long id) {
        //1. 직원이 출근 카드를 찍는다.
        //2. 출근 기록이 출근 테이블에 저장된다.
        //3. 만약 출근을 했는데 다시 찍으면 이미 출근한 직원입니다. 를 반환한다.
        //4. 퇴근을 하는 경우 출근 상태가 퇴근 상태로 바뀐다.
        //5. 다시 출근을 하는 경우 이력이 쌓이며 다시 출근 기록을 활성화한다.
        //6. 근무시간은 9 to 6를 기준으로 하며 근무시간 단위는 분당으로 계산한다.

        Employee employeeInfo
                = employeeRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        var commute = commuteRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        log.debug("날짜 비교 = {}", commute.getCommuteDate().compareTo(LocalDate.now()));
        AtomicLong commuteSeq = new AtomicLong();

        commuteRepository.save(Commute.builder()
                                      .employeeId(employeeInfo.getId())
                                      .commuteSeq(3)
                                      .commuteYn(true)
                                      .commuteDate(LocalDate.now())
                                      .build());


    }

}

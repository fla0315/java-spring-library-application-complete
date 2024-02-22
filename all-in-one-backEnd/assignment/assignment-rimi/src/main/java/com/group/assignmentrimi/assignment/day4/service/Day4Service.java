package com.group.assignmentrimi.assignment.day4.service;

import com.group.assignmentrimi.assignment.day4.dto.request.FruitRequest;
import com.group.assignmentrimi.assignment.day4.dto.response.FruitResponse;
import com.group.assignmentrimi.assignment.day4.repository.fruit.FruitJdbcRepository;
import com.group.assignmentrimi.assignment.day4.vo.FruitVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@Service
@Slf4j
public class Day4Service {

    private final FruitJdbcRepository fruitJdbcRepository;

    public Day4Service(FruitJdbcRepository fruitJdbcRepository) {
        this.fruitJdbcRepository = fruitJdbcRepository;
    }

    /**
     * 과일정보를 저장한다.
     *
     * @param fruitInfo 과일 정보
     */
    public void saveFruitInfo(FruitRequest fruitInfo) {
        fruitJdbcRepository.saveFruitInfo(FruitVo.builder().name(fruitInfo.getName())
                .warehousingData(fruitInfo.getWarehousingDate())
                .price(fruitInfo.getPrice())
                .build());
    }

    /**
     * 팔린 과일 정보를 업데이트 한다.
     *
     * @param fruitInfo 팔린 과일 id
     */
    public void salesFruitById(FruitRequest fruitInfo) {
        if (fruitInfo.getId() == null) {
            throw new IllegalArgumentException("id is null");
        }
        fruitJdbcRepository.salesFruitById(FruitVo.builder().id(fruitInfo.getId())
                .build());


    }

    /**
     * 특정 과일 기준으로 팔린 금액, 팔리지 않는 금액을 조회한다.
     *
     * @param fruitName 과일 이름
     * @return 금액 정보
     */
    public FruitResponse findFruitAmountByFruitName(String fruitName) {

        if (ObjectUtils.isEmpty(fruitName)) {
            throw new IllegalArgumentException("name is null");
        }

        return fruitJdbcRepository.findFruitAmountByFruitName(fruitName);
    }
}

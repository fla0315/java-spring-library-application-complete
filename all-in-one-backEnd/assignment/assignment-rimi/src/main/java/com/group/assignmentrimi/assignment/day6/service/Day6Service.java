package com.group.assignmentrimi.assignment.day6.service;

import com.group.assignmentrimi.assignment.day6.dto.request.FruitRequest;
import com.group.assignmentrimi.assignment.day6.dto.response.FruitResponse;
import com.group.assignmentrimi.assignment.day6.repository.fruit.FruitRepository;
import com.group.assignmentrimi.assignment.day6.vo.FruitVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@Slf4j
public class Day6Service {

    private final FruitRepository fruitRepository;

    public Day6Service(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    /**
     * 과일정보를 저장한다.
     *
     * @param fruitInfo 과일 정보
     */
    public void saveFruitInfo(FruitRequest fruitInfo) {
        fruitRepository.saveFruitInfo(FruitVo.builder().name(fruitInfo.getName())
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
        fruitRepository.salesFruitById(FruitVo.builder().id(fruitInfo.getId())
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

        return fruitRepository.findFruitAmountByFruitName(fruitName);
    }
}

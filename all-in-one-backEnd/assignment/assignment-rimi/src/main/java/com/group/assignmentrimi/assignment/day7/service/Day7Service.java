package com.group.assignmentrimi.assignment.day7.service;

import com.group.assignmentrimi.assignment.day7.dto.request.FruitRequest;
import com.group.assignmentrimi.assignment.day7.dto.response.FruitCountResponse;
import com.group.assignmentrimi.assignment.day7.repository.fruit.FruitRepository;
import com.group.assignmentrimi.assignment.day7.vo.FruitVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

@Slf4j
@Service
@Configuration
public class Day7Service {

    private final FruitRepository fruitRepository;

    public Day7Service(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    /**
     * 과일정보를 저장한다.
     *
     * @param fruitInfo 과일 정보
     */
    public void saveFruitInfo(FruitRequest fruitInfo) {

        fruitRepository.save(FruitVo.builder()
                                    .name(fruitInfo.getName())
                                    .salesYn(fruitInfo.getSalesYn())
                                    .warehousingDate(fruitInfo.getWarehousingDate())
                                    .price(fruitInfo.getPrice())
                                    .build());
    }

    /**
     * 팔린 과일 정보를 업데이트 한다.
     *
     * @param fruitInfo 팔린 과일 id
     */
    public void updateFruitInfo(FruitRequest fruitInfo) {
        if (fruitInfo.getId() == null) {
            throw new IllegalArgumentException("id is null");
        }

        var fruit = fruitRepository.findById(fruitInfo.getId())
                .orElseThrow(IllegalArgumentException::new);

        fruitRepository.save(FruitVo.builder()
                .name(fruit.getName())
                .price(fruit.getPrice())
                .warehousingDate(LocalDate.now())
                .id(fruit.getId())
                .salesYn("1")
                .build());

    }

    public FruitCountResponse countFruitInfo(String fruitName) {
        if (ObjectUtils.isEmpty(fruitName)) {
            throw new IllegalArgumentException("fruitName is null");
        }

        return FruitCountResponse.builder()
                .count(fruitRepository.countByName(fruitName))
                .build();
    }
}

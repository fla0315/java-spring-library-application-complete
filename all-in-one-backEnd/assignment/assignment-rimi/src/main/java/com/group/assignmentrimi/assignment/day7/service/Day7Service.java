package com.group.assignmentrimi.assignment.day7.service;

import com.group.assignmentrimi.assignment.day7.code.Option;
import com.group.assignmentrimi.assignment.day7.dto.request.FruitRequest;
import com.group.assignmentrimi.assignment.day7.dto.response.FruitCountResponse;
import com.group.assignmentrimi.assignment.day7.dto.response.FruitResponse;
import com.group.assignmentrimi.assignment.day7.repository.fruit.FruitRepository;
import com.group.assignmentrimi.assignment.day7.vo.FruitVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<FruitResponse> getFruitInfoList(String option, Long price) {
        //ex) compare = GTE select * from fruit where price >= xxxx and salesYn = 0; GreaterThanEqual
        //ex) compare = LTE select * from fruit where price <= xxxx and salesYn = 0; LessThanEqual

        List<FruitVo> result = new ArrayList<>();
        if (Option.GTE.getCode().equals(option)) {
            result = fruitRepository.findAllByPriceGreaterThanEqualAndSalesYn(price, "1");
        }
        if (Option.LTE.getCode().equals(option)) {
            result = fruitRepository.findAllByPriceLessThanEqualAndSalesYn(price, "1");
        }

        return result.stream()
                .map(fruitVo -> FruitResponse.builder()
                        .name(fruitVo.getName())
                        .warehousingDate(fruitVo.getWarehousingDate())
                        .price(fruitVo.getPrice())
                        .build())
                .toList();
    }
}

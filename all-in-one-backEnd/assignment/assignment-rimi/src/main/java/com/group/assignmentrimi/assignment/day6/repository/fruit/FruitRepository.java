package com.group.assignmentrimi.assignment.day6.repository.fruit;

import com.group.assignmentrimi.assignment.day6.dto.response.FruitResponse;
import com.group.assignmentrimi.assignment.day6.vo.FruitVo;
import org.springframework.jdbc.core.JdbcTemplate;

public interface FruitRepository {

    /**
     * 과일정보 저장
     * @param vo 과일 정보
     */
    public void saveFruitInfo(FruitVo vo);

    /**
     * 과일정보 수정
     * @param vo 과일 수정
     */
    public void salesFruitById(FruitVo vo);

    /**
     * 과일 이름
     * @param fruitName 과일 이름
     * @return 상태별 판매 금액
     */
    public FruitResponse findFruitAmountByFruitName(String fruitName);
}

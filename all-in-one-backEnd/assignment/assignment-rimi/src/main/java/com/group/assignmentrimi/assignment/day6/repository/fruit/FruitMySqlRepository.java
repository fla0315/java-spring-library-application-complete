package com.group.assignmentrimi.assignment.day6.repository.fruit;

import com.group.assignmentrimi.assignment.day6.dto.response.FruitResponse;
import com.group.assignmentrimi.assignment.day6.vo.FruitVo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Repository
public class FruitMySqlRepository implements FruitRepository {

    private final JdbcTemplate jdbcTemplate;

    public FruitMySqlRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 과일정보 저장
     * @param vo 과일 정보
     */
    public void saveFruitInfo(FruitVo vo) {
        String sql = "INSERT INTO fruit (name, warehousingDate, price) VALUES(:name, :warehousingDate, :price)";

        Map<String, Object> params = new HashMap<>();
        params.put("name", vo.getName());
        params.put("warehousingDate", vo.getWarehousingData());
        params.put("price", vo.getPrice());

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(Objects.requireNonNull(jdbcTemplate.getDataSource()));
        namedParameterJdbcTemplate.update(sql, params);

    }

    /**
     * 과일정보 수정
     * @param vo 과일 수정
     */
    public void salesFruitById(FruitVo vo) {
        String sql = "UPDATE fruit SET salesYn='1' WHERE id = :id";

        Map<String, Object> params = new HashMap<>();
        params.put("id", vo.getId());

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(Objects.requireNonNull(jdbcTemplate.getDataSource()));
        namedParameterJdbcTemplate.update(sql, params);
    }

    /**
     * 과일 이름
     * @param fruitName 과일 이름
     * @return 상태별 판매 금액
     */
    public FruitResponse findFruitAmountByFruitName(String fruitName) {
        //1. 조회 후 GroupBy
        //2. 쿼리에서 GroupBy
        String sql = "select " +
                "sum(select price from fruit where salesYn = '1') as salseAmount" +
                ", sum(select price from fruit where salesYn = '0') as notSalseAmount  " +
                "from fruit where name = ? group by salesYn";

        Map<String, Object> result = jdbcTemplate.queryForMap(sql, fruitName);

        return FruitResponse.builder()
                .salesAmount((Long) result.get("salesAmount"))
                .notSalesAmount((Long) result.get("notSalesAmount"))
                .build();
    }

}

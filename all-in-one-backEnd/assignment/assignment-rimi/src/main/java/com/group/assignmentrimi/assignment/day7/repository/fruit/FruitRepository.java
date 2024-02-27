package com.group.assignmentrimi.assignment.day7.repository.fruit;

import com.group.assignmentrimi.assignment.day7.dto.response.FruitResponse;
import com.group.assignmentrimi.assignment.day7.vo.FruitVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FruitRepository extends JpaRepository<FruitVo ,Long> {

    FruitVo findByName(String name);

    //List<FruitResponse> findAll(String name);

    Long countByName(String name);

}

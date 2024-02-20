package com.group.assignmentrimi.assignment.day2.dto.request;

import com.group.assignmentrimi.assignment.day2.domain.Numbers;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NumbersRequest {

    private List<Numbers> numbers = new ArrayList<>();

}
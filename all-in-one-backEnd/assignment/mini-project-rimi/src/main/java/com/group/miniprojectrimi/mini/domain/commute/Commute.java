package com.group.miniprojectrimi.mini.domain.commute;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "commute")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Commute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long employeeId;
    private long commuteSeq;
    private boolean commuteYn;
    private LocalDate commuteDate;

}

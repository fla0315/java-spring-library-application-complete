package com.group.miniprojectrimi.mini.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "role")
    @NonNull
    private String role;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "birthday")
    @NonNull
    private LocalDate birthday;

    @Column(name = "work_start_date")
    private LocalDate wordStartDate;

}

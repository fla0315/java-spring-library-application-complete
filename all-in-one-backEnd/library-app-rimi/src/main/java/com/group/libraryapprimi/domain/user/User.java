package com.group.libraryapprimi.domain.user;

import com.group.libraryapprimi.dto.user.loanhistory.UserLoanHistory;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User {
    @Id
    //Auto increment라 identity임
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false, length = 20, name = "name")
    private String name;

    //name은 같으면 생략 가능
    @Column(nullable = false, length = 255)
    private Integer age;

    //mappedBy = "user" 를 통해서 연관관계 주인을 설정해줘야함
    // ?? foreign-key를 가진 쪽이 연관관계의 주인이다? 라고 이해하면 되는지 확인
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserLoanHistory> userLoanHistory = new ArrayList<>();

    //JPA 사용을 위한 기본 생성자
    protected User() {

    }

    public User(String name, Integer age) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다", name));
        }
        this.name = name;
        this.age = age;
    }

    public void updateName(String name) {
        this.name = name;
    }

    //domain 계층에 비즈니스 로직 추가
    public void loanBook(String bookName) {
        this.userLoanHistory.add(new UserLoanHistory(this, bookName));
    }

    public void returnBook(String bookName) {
        UserLoanHistory targetHistory = this.userLoanHistory.stream()
                                                            .filter(history -> history.getBookName().equals(bookName))
                                                            .findFirst()
                                                            .orElseThrow();
        targetHistory.doReturn();
    }


}

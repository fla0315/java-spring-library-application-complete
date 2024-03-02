package com.group.libraryapprimi.dto.user.loanhistory;

import com.group.libraryapprimi.domain.user.User;
import jakarta.persistence.*;

@Entity
public class UserLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    //private long userId; -> 더 나은 객체지향을 위해 User user로 변경

    //N:1 관계 ex) 학생 N : 교실 1ㄴ
    @ManyToOne //내가 다수 이고 너가 하나일 때 사용하는 어노테이션
    private User user;

    private String bookName;

    private boolean isReturn;

    protected UserLoanHistory() {

    }

    public UserLoanHistory(User user, String bookName) {
        this.user = user;
        this.bookName = bookName;
        this.isReturn = false;
    }

    public void doReturn() {
        this.isReturn = true;
    }

}

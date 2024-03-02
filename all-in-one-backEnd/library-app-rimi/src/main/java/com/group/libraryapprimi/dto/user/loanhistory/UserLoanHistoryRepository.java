package com.group.libraryapprimi.dto.user.loanhistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory, Long> {

    //select * from user_loan_history where book_name = ? and is_return = ?;
    boolean existsByBookNameAndIsReturn(String name, boolean isReturn);

}

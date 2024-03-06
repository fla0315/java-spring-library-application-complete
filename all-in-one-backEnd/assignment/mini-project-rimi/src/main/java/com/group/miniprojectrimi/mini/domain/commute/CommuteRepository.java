
package com.group.miniprojectrimi.mini.domain.commute;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommuteRepository extends JpaRepository<Commute, Long> {

}

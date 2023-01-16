package com.company.socialmediaapp.repository;

import com.company.socialmediaapp.model.Mword;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mehul jain
 */

@Repository
public interface MwordRepository extends JpaRepository<Mword, Long> {
    
    Optional<Mword> findByName(String mwordName);
}

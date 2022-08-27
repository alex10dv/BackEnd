
package com.myporfolio.ADV.Repository;

import com.myporfolio.ADV.Entity.HySSkills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHySSkillsRepository extends JpaRepository<HySSkills, Integer> {
    
    public Optional<HySSkills> findByTitle(String title);
    public boolean existsByTitle(String title);
   
}
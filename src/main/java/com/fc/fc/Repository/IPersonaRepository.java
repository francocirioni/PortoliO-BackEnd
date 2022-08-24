
package com.fc.fc.Repository;

import com.fc.fc.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IPersonaRepository extends JpaRepository <Persona , Long> {
    
}


package com.fc.fc.Repository;

import com.fc.fc.Entity.Kys;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RKys extends JpaRepository<Kys, Integer> {
    
    public Optional<Kys> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
    
}

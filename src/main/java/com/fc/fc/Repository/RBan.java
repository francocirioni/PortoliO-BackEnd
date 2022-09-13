
package com.fc.fc.Repository;


import com.fc.fc.Entity.Ban;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 


public interface RBan extends JpaRepository <Ban, Integer> {
     public Optional<Ban> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
    
}

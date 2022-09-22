
package com.fc.fc.Repository;


import com.fc.fc.Entity.Redes;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RRedes extends JpaRepository <Redes, Integer>{
     public Optional<Redes> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
    
    
}

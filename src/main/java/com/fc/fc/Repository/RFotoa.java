
package com.fc.fc.Repository;

import com.fc.fc.Entity.Fotoa;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository 

public interface RFotoa extends JpaRepository <Fotoa, Integer> {
     public Optional<Fotoa> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
}


package com.fc.fc.Repository;

import com.fc.fc.Entity.fotopro;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository 
public interface RFotopro extends JpaRepository <fotopro, Integer>{
    
    public Optional<fotopro> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
    
}

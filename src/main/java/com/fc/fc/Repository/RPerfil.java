
package com.fc.fc.Repository;



import com.fc.fc.Entity.Perfil;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository 

public interface RPerfil extends JpaRepository<Perfil, Integer> {
  public Optional<Perfil> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
    
}

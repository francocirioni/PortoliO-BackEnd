
package com.fc.fc.Service;


import com.fc.fc.Entity.Perfil;
import com.fc.fc.Repository.RPerfil;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional


public class SPerfil {
     @Autowired
     
     RPerfil rPerfil;
     
       
      public List<Perfil> list(){  
    
        return rPerfil.findAll();
    }
    
      
     public Optional<Perfil> getOne(int id){
         return rPerfil.findById(id);
     }
     
     public Optional<Perfil> getByNombreE(String nombreE){
         return rPerfil.findByNombreE(nombreE);
     }
     
     public void save(Perfil expe){
         rPerfil.save(expe);
     }
     
     public void delete(int id){
         rPerfil.deleteById(id);
     }
     
     public boolean existsById(int id){
         return rPerfil.existsById(id);
     }
     
     public boolean existsByNombreE(String nombreE){
         return rPerfil.existsByNombreE(nombreE);
     }
      
    
     
     
     
     
     
     
     
     
     
     
     
     
     
     
}

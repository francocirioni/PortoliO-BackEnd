
package com.fc.fc.Service;


import com.fc.fc.Entity.Kys;
import com.fc.fc.Repository.RKys;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional




public class SKys {
    
    @Autowired
    RKys rKys;
    
     public List<Kys> list(){  
    
        return rKys.findAll();
    }
    
      
     public Optional<Kys> getOne(int id){
         return rKys.findById(id);
     }
     
     public Optional<Kys> getByNombreE(String nombreE){
         return rKys.findByNombreE(nombreE);
     }
    
     public void save(Kys ky){
         rKys.save(ky);
     }
     
     public void delete(int id){
         rKys.deleteById(id);
     }
     
     public boolean existsById(int id){
         return rKys.existsById(id);
     }
     
     public boolean existsByNombreE(String nombreE){
         return rKys.existsByNombreE(nombreE);
     }
    
}

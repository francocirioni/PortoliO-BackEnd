
package com.fc.fc.Service;

import com.fc.fc.Entity.Fotoa;
import com.fc.fc.Repository.RFotoa;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional

public class SFotoa {
    
    
    
    
     @Autowired
     
     RFotoa rFotoa;
     
     
       public List<Fotoa> list(){  
    
        return rFotoa.findAll();
    }
    
      
     public Optional<Fotoa> getOne(int id){
         return rFotoa.findById(id);
     }
     
     public Optional<Fotoa> getByNombreE(String nombreE){
         return rFotoa.findByNombreE(nombreE);
     }
     
     public void save(Fotoa foto){
         rFotoa.save(foto);
     }
     
     public void delete(int id){
         rFotoa.deleteById(id);
     }
     
     public boolean existsById(int id){
         return rFotoa.existsById(id);
     }
     
     public boolean existsByNombreE(String nombreE){
         return rFotoa.existsByNombreE(nombreE);
     }
     
    
    
    
    
    
    
    
    
    
}

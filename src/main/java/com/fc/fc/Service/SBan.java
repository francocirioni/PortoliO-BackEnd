
package com.fc.fc.Service;

import com.fc.fc.Entity.Ban;
import com.fc.fc.Repository.RBan;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional


public class SBan {
    
    
    
     @Autowired
     
     RBan rBan;
     
     
       public List<Ban> list(){  
    
        return rBan.findAll();
    }
    
      
     public Optional<Ban> getOne(int id){
         return rBan.findById(id);
     }
     
     public Optional<Ban> getByNombreE(String nombreE){
         return rBan.findByNombreE(nombreE);
     }
     
     public void save(Ban ban){
         rBan.save(ban);
     }
     
     public void delete(int id){
         rBan.deleteById(id);
     }
     
     public boolean existsById(int id){
         return rBan.existsById(id);
     }
     
     public boolean existsByNombreE(String nombreE){
         return rBan.existsByNombreE(nombreE);
     }
     
    
    
}

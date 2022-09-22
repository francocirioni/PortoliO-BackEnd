
package com.fc.fc.Service;




import com.fc.fc.Entity.Redes;

import com.fc.fc.Repository.RRedes;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional




public class SRedes {
    
    @Autowired
    RRedes rRedes;
    
    public List<Redes> list(){  
    
        return rRedes.findAll();
    }
    
      
     public Optional<Redes> getOne(int id){
         return rRedes.findById(id);
     }
     
     public Optional<Redes> getByNombreE(String nombreE){
         return rRedes.findByNombreE(nombreE);
     }
     
     public void save(Redes red){
         rRedes.save(red);
     }
     
     public void delete(int id){
         rRedes.deleteById(id);
     }
     
     public boolean existsById(int id){
         return rRedes.existsById(id);
     }
     
     public boolean existsByNombreE(String nombreE){
         return rRedes.existsByNombreE(nombreE);
     }
      
    
    
}

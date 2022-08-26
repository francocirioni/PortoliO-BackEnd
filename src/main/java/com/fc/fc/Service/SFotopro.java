
package com.fc.fc.Service;


import com.fc.fc.Entity.fotopro;
import com.fc.fc.Repository.RFotopro;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@Transactional

public class SFotopro {
    
     @Autowired
    RFotopro rFotopro;
     
     
     
     
     public List<fotopro> list(){  
    
        return rFotopro.findAll();
    }
    
      
     public Optional<fotopro> getOne(int id){
         return rFotopro.findById(id);
     }
     
     public Optional<fotopro> getByNombreE(String nombreE){
         return  rFotopro.findByNombreE(nombreE);
     }
     
     public void save(fotopro expe){
          rFotopro.save(expe);
     }
     
     public void delete(int id){
          rFotopro.deleteById(id);
     }
     
     public boolean existsById(int id){
         return  rFotopro.existsById(id);
     }
     
     public boolean existsByNombreE(String nombreE){
         return  rFotopro.existsByNombreE(nombreE);
     }
}

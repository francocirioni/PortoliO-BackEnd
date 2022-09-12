
package com.fc.fc.Controller;


import com.fc.fc.Dto.dtoAcercade;
import com.fc.fc.Entity.Acercade;
import com.fc.fc.Security.Controller.Mensaje;
import com.fc.fc.Service.SAcercade;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/acercade")
@CrossOrigin(origins = "http://localhost:4200")



public class CAcercade {
    
    
    
     @Autowired
    SAcercade sAcercade;
    
    
     @GetMapping("/lista")
    public ResponseEntity<List<Acercade>> list(){
        List<Acercade> list = sAcercade.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
     @GetMapping("/detail/{id}")
    public ResponseEntity<Acercade> getById(@PathVariable("id") int id){
        if(!sAcercade.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Acercade experiencia = sAcercade.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
        @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sAcercade.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sAcercade.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
    
    
    
    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoAcercade dtoexp){      
        if(StringUtils.isBlank(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sAcercade.existsByNombreE(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
        
        
        Acercade experiencia = new Acercade (dtoexp.getNombreE(), dtoexp.getDescripcionE(), dtoexp.getimagenE() );
        sAcercade.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
        
    }
    
    
     @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoAcercade dtoexp){
        //Validamos si existe el ID
        if(!sAcercade.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(sAcercade.existsByNombreE(dtoexp.getNombreE()) && sAcercade.getByNombreE(dtoexp.getNombreE()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Acercade proyectos = sAcercade.getOne(id).get();
        proyectos.setNombreE(dtoexp.getNombreE());
        proyectos.setimagenE(dtoexp.getimagenE());
        proyectos.setDescripcionE((dtoexp.getDescripcionE()));
        
       
        
        sAcercade.save(proyectos);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
             
    }
    
    
    
}

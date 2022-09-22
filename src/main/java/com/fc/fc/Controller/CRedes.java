
package com.fc.fc.Controller;





import com.fc.fc.Dto.dtoRedes;
import com.fc.fc.Entity.Redes;
import com.fc.fc.Security.Controller.Mensaje;
import com.fc.fc.Service.SRedes;

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
@RequestMapping("/redes")
@CrossOrigin(origins = "http://localhost:4200")



public class CRedes {
    
       @Autowired
    SRedes sRedes;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Redes>> list(){
        List<Redes> list = sRedes.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Redes> getById(@PathVariable("id") int id){
        if(!sRedes.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Redes redes = sRedes.getOne(id).get();
        return new ResponseEntity(redes, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sRedes.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sRedes.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoRedes dtored){      
        if(StringUtils.isBlank(dtored.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sRedes.existsByNombreE(dtored.getNombreE()))
            return new ResponseEntity(new Mensaje("Esa red existe"), HttpStatus.BAD_REQUEST);
        
        Redes redes = new Redes(dtored.getNombreE(), dtored.getDescripcionE(), dtored.getDescripcionE2(), dtored.getDescripcionE3(), dtored.getDescripcionE4());
        sRedes.save(redes);
        
        return new ResponseEntity(new Mensaje("Red agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoRedes dtored){
        //Validamos si existe el ID
        if(!sRedes.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de 
        if(sRedes.existsByNombreE(dtored.getNombreE()) && sRedes.getByNombreE(dtored.getNombreE()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa Red ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtored.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Redes redes = sRedes.getOne(id).get();
        redes.setNombreE(dtored.getNombreE());
        redes.setDescripcionE(dtored.getDescripcionE());
        redes.setDescripcionE2(dtored.getDescripcionE2());
        redes.setDescripcionE3(dtored.getDescripcionE3()); 
        redes.setDescripcionE4((dtored.getDescripcionE4()));
        
        sRedes.save(redes);
        return new ResponseEntity(new Mensaje("actualizada"), HttpStatus.OK);
             
    }
    
    
}

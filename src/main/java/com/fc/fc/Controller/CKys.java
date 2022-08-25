
package com.fc.fc.Controller;

import com.fc.fc.Dto.dtoKys;
import com.fc.fc.Entity.Kys;
import com.fc.fc.Security.Controller.Mensaje;

import com.fc.fc.Service.SKys;
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
@RequestMapping("/kys")
@CrossOrigin(origins = "http://localhost:4200")

public class CKys {
    
    
    @Autowired
    SKys sKys;
    
    
    @GetMapping("/lista")
    public ResponseEntity<List<Kys>> list(){
        List<Kys> list = sKys.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Kys> getById(@PathVariable("id") int id){
        if(!sKys.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Kys kys = sKys.getOne(id).get();
        return new ResponseEntity(kys, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sKys.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sKys.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoKys dtokys){      
        if(StringUtils.isBlank(dtokys.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sKys.existsByNombreE(dtokys.getNombreE()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
        Kys kys = new Kys(dtokys.getNombreE(), dtokys.getDescripcionE2(), dtokys.getDescripcionE3(), dtokys.getDescripcionE4(), dtokys.getDescripcionE5(), dtokys.getDescripcionE6(), dtokys.getDescripcionE());
        sKys.save(kys);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    
    
    
     @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoKys dtokys){
        //Validamos si existe el ID
        if(!sKys.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(sKys.existsByNombreE(dtokys.getNombreE()) && sKys.getByNombreE(dtokys.getNombreE()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtokys.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Kys kys = sKys.getOne(id).get();
        kys.setNombreE(dtokys.getNombreE());
        kys.setDescripcionE((dtokys.getDescripcionE()));
        
        sKys.save(kys);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
             
    }
    
    
    
    
    
    
    
    
}
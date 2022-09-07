
package com.fc.fc.Controller;

import com.fc.fc.Dto.dtoFotoa;
import com.fc.fc.Entity.Fotoa;
import com.fc.fc.Security.Controller.Mensaje;
import com.fc.fc.Service.SFotoa;
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
@RequestMapping("/fotoa")
@CrossOrigin(origins = "http://localhost:4200")

public class CFotoa {
     @Autowired
     SFotoa sFotoa;
        
     
     
     @GetMapping("/lista")
    public ResponseEntity<List<Fotoa>> list(){
        List<Fotoa> list = sFotoa.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Fotoa> getById(@PathVariable("id") int id){
        if(!sFotoa.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Fotoa experiencia = sFotoa.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    
     
     @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sFotoa.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sFotoa.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoFotoa dtofot){      
        if(StringUtils.isBlank(dtofot.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sFotoa.existsByNombreE(dtofot.getNombreE()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
        Fotoa fotoa = new Fotoa(dtofot.getNombreE());
        
        sFotoa.save(fotoa);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
     
     
     @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoFotoa dtofot){
        //Validamos si existe el ID
        if(!sFotoa.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(sFotoa.existsByNombreE(dtofot.getNombreE()) && sFotoa.getByNombreE(dtofot.getNombreE()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtofot.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Fotoa fotoa = sFotoa.getOne(id).get();
        fotoa.setNombreE(dtofot.getNombreE());
        
        
        sFotoa.save(fotoa);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
             
    }
     
     
     
     
     
     
     
     
     
     
}

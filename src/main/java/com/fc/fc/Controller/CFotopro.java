
package com.fc.fc.Controller;

import com.fc.fc.Dto.dtoFotopro;
import com.fc.fc.Entity.fotopro;
import com.fc.fc.Security.Controller.Mensaje;
import com.fc.fc.Service.SFotopro;
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
@RequestMapping("/fotopro")
@CrossOrigin(origins = "http://localhost:4200")
public class CFotopro {
    
      @Autowired
    SFotopro sFotopro;
      
       @GetMapping("/lista")
    public ResponseEntity<List<fotopro>> list(){
        List<fotopro> list = sFotopro.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
      @GetMapping("/detail/{id}")
    public ResponseEntity<fotopro> getById(@PathVariable("id") int id){
        if(!sFotopro.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        fotopro experiencia = sFotopro.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sFotopro.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sFotopro.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoFotopro dtofot){      
        if(StringUtils.isBlank(dtofot.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sFotopro.existsByNombreE(dtofot.getNombreE()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
        fotopro fotopr = new fotopro(dtofot.getNombreE());
        sFotopro.save(fotopr);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
     @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoFotopro dtofot){
        //Validamos si existe el ID
        if(!sFotopro.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(sFotopro.existsByNombreE(dtofot.getNombreE()) && sFotopro.getByNombreE(dtofot.getNombreE()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtofot.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        fotopro fotopr = sFotopro.getOne(id).get();
        fotopr.setNombreE(dtofot.getNombreE());
        
        
        sFotopro.save(fotopr);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
             
    }
}

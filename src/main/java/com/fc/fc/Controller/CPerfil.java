
package com.fc.fc.Controller;

import com.fc.fc.Dto.dtoPerfil;
import com.fc.fc.Entity.Perfil;
import com.fc.fc.Service.SPerfil;
import com.fc.fc.Security.Controller.Mensaje;
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
@RequestMapping("/perfil")
@CrossOrigin(origins = "http://localhost:4200")


public class CPerfil {
    
      @Autowired
    SPerfil sPerfil;
    
    
     @GetMapping("/lista")
    public ResponseEntity<List<Perfil>> list(){
        List<Perfil> list = sPerfil.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Perfil> getById(@PathVariable("id") int id){
        if(!sPerfil.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Perfil perfil = sPerfil.getOne(id).get();
        return new ResponseEntity(perfil, HttpStatus.OK);
        
        
    }
    
       @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sPerfil.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sPerfil.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    
    
     @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPerfil dtoper){      
        if(StringUtils.isBlank(dtoper.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sPerfil.existsByNombreE(dtoper.getNombreE()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
        Perfil perfil = new Perfil(dtoper.getNombreE());
        sPerfil.save(perfil);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPerfil dtoper){
        //Validamos si existe el ID
        if(!sPerfil.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(sPerfil.existsByNombreE(dtoper.getNombreE()) && sPerfil.getByNombreE(dtoper.getNombreE()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoper.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Perfil perfil = sPerfil.getOne(id).get();
        perfil.setNombreE(dtoper.getNombreE());
       
        
        sPerfil.save(perfil);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    
    
}
    }

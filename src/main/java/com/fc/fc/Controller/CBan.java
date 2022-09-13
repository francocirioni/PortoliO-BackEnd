package com.fc.fc.Controller;


import com.fc.fc.Entity.Ban;
import com.fc.fc.Dto.dtoBan;
import com.fc.fc.Security.Controller.Mensaje;
import com.fc.fc.Service.SBan;
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
@RequestMapping("/ban")
@CrossOrigin(origins = "http://localhost:4200")
public class CBan {
    
    
    @Autowired
     SBan sBan;
        
     
     
     @GetMapping("/lista")
    public ResponseEntity<List<Ban>> list(){
        List<Ban> list = sBan.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Ban> getById(@PathVariable("id") int id){
        if(!sBan.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Ban experiencia = sBan.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    
     
     @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sBan.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sBan.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    

     
     
     @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoBan dtoban){
        //Validamos si existe el ID
        if(!sBan.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(sBan.existsByNombreE(dtoban.getNombreE()) && sBan.getByNombreE(dtoban.getNombreE()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoban.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Ban ban = sBan.getOne(id).get();
        ban.setNombreE(dtoban.getNombreE());
        
        
        sBan.save(ban);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
             
    }
     
    
}

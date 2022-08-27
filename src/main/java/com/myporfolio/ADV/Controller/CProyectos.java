
package com.myporfolio.ADV.Controller;


import com.myporfolio.ADV.Dto.dtoProyectos;
import com.myporfolio.ADV.Entity.Proyectos;
import com.myporfolio.ADV.Security.Controller.Mensaje;
import com.myporfolio.ADV.Service.SProyectos;
 
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/proyectos")
@CrossOrigin(origins = "http://localhost:4200")
public class CProyectos {
    @Autowired
    SProyectos sProyectos;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){ // lista que trae todos los proyectos
        List<Proyectos> list = sProyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')") 
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje("no existe el proyecto"), HttpStatus.NOT_FOUND);
        Proyectos proyectos = sProyectos.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')") 
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe el proyecto"), HttpStatus.NOT_FOUND);
        }
        sProyectos.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')") 
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtopro){      
        if(StringUtils.isBlank(dtopro.getNombreE()))
            return new ResponseEntity(new Mensaje("Nombre requerido !! Es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sProyectos.existsByNombreE(dtopro.getNombreE()))
            return new ResponseEntity(new Mensaje("El Proyecto existe"), HttpStatus.BAD_REQUEST);
        
        Proyectos proyectos = new Proyectos(dtopro.getNombreE(), dtopro.getDescripcionE(), dtopro.getUrlimg());
        sProyectos.save(proyectos);
        
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')") 
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtopro){
        //Validacion si existe el Id
        if(!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no!! existe"), HttpStatus.BAD_REQUEST);
        //Aca se compara nombre del proycto
        if(sProyectos.existsByNombreE(dtopro.getNombreE()) && sProyectos.getByNombreE(dtopro.getNombreE()).get().getId() != id)
            return new ResponseEntity(new Mensaje("El proyecto ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtopro.getNombreE()))
            return new ResponseEntity(new Mensaje("Nombre requerido es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyectos proyectos = sProyectos.getOne(id).get();
        proyectos.setNombreE(dtopro.getNombreE());
        proyectos.setDescripcionE((dtopro.getDescripcionE()));
        proyectos.setUrlimg((dtopro.getUrlimg()));
        
        sProyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto actualizado con exito !!!"), HttpStatus.OK);
             
    }
}

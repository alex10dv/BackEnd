package com.myporfolio.ADV.Interface;

// interface del servicio de persona

import com.myporfolio.ADV.Entity.Persona;
import java.util.List;

public interface IPersonaService {
 //para traer una lista de personas
  public List<Persona> getPersona();
    
 //guardar una persona
  public void savePersona(Persona persona);
    
 //eliminar una persona, se pone tipo de dato y el nombre del campo en este caso Id por la 
 //cual va a ser buscada
  public void deletePersona(long id);
      
  //buscar una persona por id
   public Persona findPersona(long id);
}

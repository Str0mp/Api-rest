package com.martini.api.controller;


import com.martini.api.entity.User;
import com.martini.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController //SE AÑADE NOTACIÓN PARA INDICAR QUE ES UN REST CONTROLLER
@RequestMapping("/api") //PRIMERA RUTA DE ACCESO PARA ACCEDER A LA API
public class UserRestController {

    @Autowired
    UserRepository userRepository; //OBJETO DEL REPOSITORY QUE CONTIENE TODAS LAS QUERYS PARA LA BD

    @GetMapping("/users") //POR GET RETORNARÁ TODOS LOS USUARIOS
    public List<User> getAllUsers(){
        return userRepository.findAll();    //MÉTODO DEL REPOSITORY PARA OBTENER TODOS LOS USUARIOS
    }

    @PostMapping("/createUser") //POR POST ENVIARÁ UN USUARIO
    public User createUser(@Valid @RequestBody User user) { //VALIDA Y OBTIENE LOS DATOS PASADOS POR JSON
        return userRepository.save(user);   //MÉTODO DEL REPOSITORY PARA INGRESAR UN USUARIO
    }

    @GetMapping("/users/{id}")  //POR GET OBTENDRÁ LOS USUARIOS POR ID
    public User getUserById(@PathVariable(value = "id") Long id){   //CON PATHVARIABLE OBTIENE EL ID INGRESADO EN EL ENDPOINT LO GUARDA EN "id"
        return userRepository.findById(id).orElse(null); //MÉTODO DEL REPOSITORY PARA BUSCAR POR ID
    }

    @PutMapping("/updateUser/{id}") //POR PUT ACTUALIZA USUARIOS
    public User updateUser(@PathVariable(value = "id") Long id, @Valid @RequestBody User userDetails){ //CON PATHVARIABLE OBTIENE EL ID DEL ENDPOINT Y LO GUARDA EN "id" Y ADEMÁS OBTIENE UN USUARIO QUE SE ENVÍA POR JSON
        User user = userRepository.findById(id).orElse(null); //A UN OBJETO USER SE LLENA DESDE EL MÉTODO DEL REPOSITORY QUE BUSCA POR ID
        user.setName(userDetails.getName());    //EL MISMO OBJETO LLENADO CON LOS DATOS, SE MÓDIFICA CON LOS DATOS CAPTURADOS POR JSON
        user.setUsername(userDetails.getUsername());    //EL MISMO OBJETO LLENADO CON LOS DATOS, SE MÓDIFICA CON LOS DATOS CAPTURADOS POR JSON
        User updateNote = userRepository.save(user);    //SE CREA OTRO OBJETO DEL TIPO USER EL CUAL LLAMA AL MÉTODO SAVE DEL REPOSITORY, ESTE RETORNARÁ UN OBJETO USUARIO QUE SE VERÁ COMO RESPUESTA AL SERVICIO
        return updateNote;
    }
    @DeleteMapping("/deleteUser/{id}") //POR DELETE SE ELIMINA UN USUARIO POR ID
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long id){ //SE OBTIENE EL ID CON PATHVARIABLE Y LO GUARDA EN "id"
        User note = userRepository.findById(id).orElse(null); //SE GUARDA LA RESPUESTA DE UN USUARIO CON EL MÉTODO FINBYID DEL REPOS
        userRepository.delete(note); //SE LLAMA AL REPOSITORY AL MÉTODO DELETE Y SE ENVÍA EL OBJETO YA ENCONTRADO
        return ResponseEntity.ok().build(); //RETORNA LA RESPUESTA LUEGO DE ELIMINAR
    }




}

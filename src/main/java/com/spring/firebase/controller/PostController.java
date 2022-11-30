package com.spring.firebase.controller;
import com.spring.firebase.entities.PostDTO;
import com.spring.firebase.logic.PostManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/post")
public class PostController {
@Autowired
private PostManagementService service;
    @GetMapping(value = "/greet/{name}")
    public String greet(@PathVariable(value = "name")String name){
        return "hello, "+name;
    }

    //metodo=listar, definimos un estado a la peticion
    @GetMapping(value = "/list")
    public ResponseEntity list(){
        return new ResponseEntity(service.list(), HttpStatus.OK);
    }

    //metodo=guardar, se utiliza post utiliza un request body para
    //transforma el objeto json y lo mapea en un obj java
    @PostMapping(value = "/add")
    public ResponseEntity add (@RequestBody PostDTO post) throws ExecutionException, InterruptedException {
        return new  ResponseEntity (service.add(post), HttpStatus.OK);
    }

    //metodo=actualizar
    @PutMapping(value = "/{id}/update")
    public ResponseEntity edit(@PathVariable(value = "id") String id, @RequestBody PostDTO post){
    return  new ResponseEntity(service.edit(id, post), HttpStatus.OK);
    }

    //metodo- eliminar
    @DeleteMapping(value = "/{id}/delete")
    public ResponseEntity delete(@PathVariable(value = "id") String id){
        return  new ResponseEntity(service.delete(id), HttpStatus.OK);
    }


}

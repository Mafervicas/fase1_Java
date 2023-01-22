/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.codejava.controller;

import java.util.List;
import java.util.Optional;
import net.codejava.entity.Imc;
import net.codejava.services.ImcApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mafer Vicas
 */
@RestController
@RequestMapping("/obtenerImc")
public class RequestController {
    
    @Autowired
    ImcApiService service;
    
    @GetMapping()
    public List<Imc> listAll(){
        return service.listAll();
    }
    
    @PostMapping()
    public Imc save(@RequestBody Imc imc){
        return this.service.save(imc);
    }
   
    @GetMapping(path="/{id}")
    public Optional<Imc> findById(@PathVariable("imc") Long id){
        return this.service.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        boolean ok= this.service.delete(id);
        if(ok){
            return "Se eliminó usuario con id " + id; 
        }else{
           return "No se puedo eliminar el usuario con id " + id; 
    }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.codejava.services;

import java.util.List;
import java.util.Optional;
import net.codejava.entity.Imc;
import net.codejava.repositories.ImcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mafer Vicas
 */
@Service
public class ImcApiService {
    @Autowired
    ImcRepository repo;
    
    public List<Imc> listAll() {
		return repo.findAll();
	}
	
	public Imc save(Imc imc) {
		return repo.save(imc);
	}
	
	public Optional<Imc> findById(long id) {
		return repo.findById(id);
	}
	
	public boolean delete(long id) {
            try{
		repo.deleteById(id);
                return true;
            }catch(Exception err){
            return false;
        }
	}
    
}

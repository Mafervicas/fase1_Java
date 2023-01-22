/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codejava.services;

import java.util.List;
import net.codejava.entity.Imc;
import net.codejava.entity.Product;
import net.codejava.repositories.ImcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jajimenez
 */
@Service
@Transactional
public class ImcService {

    @Autowired
    private ImcRepository imcRepo;

    public void save(Imc imc) {
        imcRepo.save(imc);
    }
    public List<Imc> listAll() {
		return imcRepo.findAll();
	}
	
	public Imc get(long id) {
		return imcRepo.findById(id).get();
	}
	
	public void delete(long id) {
		imcRepo.deleteById(id);
	}
    

}

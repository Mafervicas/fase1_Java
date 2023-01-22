/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codejava.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

/**
 *
 * @author jajimenez
 */
@Entity
public class Imc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="nombre_persona")
    private String nombrePersona;
    
    @Column(name="sexo")
    private String sexo;
    
    @Column(name="edad")
    private String edad;
    
    @Column(name="peso")
    private Double peso;
    
    @Column(name="altura")
    private Double altura;
    
    @Column(name="calorias")
    private Integer calorias;
    
    @Column(name="fecha_alta")
    private Date fechaAlta;
    
    @Column(name="imc_f")
    private Double imcF;

    public Imc() {
    }

    public Imc(Long id, String nombrePersona, String sexo, String edad, Double peso, Double altura, Integer calorias) {
        this.id = id;
        this.nombrePersona = nombrePersona;
        this.sexo = sexo;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.calorias = calorias;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    
 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Integer getCalorias() {
        return calorias;
    }

    public void setCalorias(Integer calorias) {
        this.calorias = calorias;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Double getImcF() {
        return imcF;
    }

    public void setImcF(Double imcF) {
        this.imcF = imcF;
    }
    
    
    
    @PrePersist
    public void antesPersistir(){
        this.fechaAlta = new Date();
    }
    
    @PostPersist
    public void despuesPersistir(){
        this.imcF = peso / (altura * altura) ;
    }
    

}

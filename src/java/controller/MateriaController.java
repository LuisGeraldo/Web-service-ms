/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entidades.Materia;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;

/**
 *
 * @author luis
 */
public class MateriaController {
    public String codigo;
    public String nombre;
    public String descripcion;
    
    EntityManager em;
    EntityManagerFactory emf;
    Materia materia;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    
    public MateriaController(){
        materia = new Materia();
        emf = javax.persistence.Persistence.createEntityManagerFactory("WebServicesSPPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();   
    }
    
    public boolean Crear(String codigo, String nombre, String descripcion){
        materia.setIdcodigo(codigo);
        materia.setNombre(nombre);
        materia.setDescripcion(descripcion);
        
        try{
            em.persist(materia);
            em.getTransaction().commit();
            
            return true;
                
        }catch(RollbackException ex){
         
            return false;
         
        }
    }
    
    public String Buscar(String codigo){
        materia = em.find(Materia.class, codigo);
        
        if(materia != null){
            descripcion = materia.getDescripcion();
            nombre = materia.getNombre();
        
            return nombre +"/"+descripcion;
            
        }else{
            
           return "No se encontro la materia";
        }
    } 
   
    public boolean Borrar(String codigo){
        materia = em.find(Materia.class, codigo);
        
        if(materia != null){
            em.remove(materia);
            em.getTransaction().commit();  
          
            return true;
        
        }else{
            
           return false;
        }
    } 
       
    public boolean Actualizar(String codigo, String nombre, String descripcion){  
         materia = em.find(Materia.class, codigo);
        
        if(materia != null){
             materia.setNombre(nombre);
             materia.setDescripcion(descripcion);
             em.merge(materia);
             em.getTransaction().commit();
          
             return true;
        
        }else{
            
          return false;
        }
    }
}

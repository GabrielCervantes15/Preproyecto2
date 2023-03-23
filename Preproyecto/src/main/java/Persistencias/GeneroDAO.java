/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencias;

import Entidades.Genero;
import Entidades.Videojuegos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Gabriel
 */
public class GeneroDAO implements IGeneroDAO{
    
    private EntityManager entity;

    public GeneroDAO(IConexionBD c) {
        this.entity = c.crearConexion();
    }

    @Override
    public boolean agregaLista(List<Genero> lista) {

        try {
            entity.getTransaction().begin();
            for (Genero gen : lista) {
                entity.persist(gen);
            }
            entity.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

        return true;
    }


   
}

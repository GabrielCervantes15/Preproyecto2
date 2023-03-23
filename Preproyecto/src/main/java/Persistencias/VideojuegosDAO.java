/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencias;

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
public class VideojuegosDAO implements IVideojuegosDAO {

    private EntityManager entity;

    public VideojuegosDAO(IConexionBD c) {
        this.entity = c.crearConexion();
    }

    @Override
    public boolean agregaLista(List<Videojuegos> lista) {

        try {
            entity.getTransaction().begin();
            for (Videojuegos video : lista) {
                entity.persist(video);
            }
            entity.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

        return true;
    }

    @Override
    public List<Videojuegos> Lista() {

        entity.getTransaction().begin();
        String queryBuscar = "SELECT v FROM Videojuegos v";
        TypedQuery<Videojuegos> query = entity.createQuery(queryBuscar, Videojuegos.class);
        List<Videojuegos> lista = query.getResultList();
        entity.getTransaction().commit();

        return lista;
    }

    @Override
    public List<Videojuegos> ListaFiltro(int limite, String filtro, int con) {
        entity.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entity.getCriteriaBuilder();
        CriteriaQuery<Videojuegos> con1 = criteriaBuilder.createQuery(Videojuegos.class);
        con1.distinct(true);
        Root<Videojuegos> raiz = con1.from(Videojuegos.class);

        con1.where(
                criteriaBuilder.or(
                        criteriaBuilder.like(raiz.get("nombre"), "%" + filtro + "%"),
                        criteriaBuilder.like(raiz.get("clasificacion"), "%" + filtro + "%")
                )
        );

        TypedQuery<Videojuegos> query = entity.createQuery(con1);
        query.setFirstResult(con);
        query.setMaxResults(limite);

        List<Videojuegos> lstvideo = query.getResultList();

        entity.getTransaction().commit();

        return lstvideo;
    }

    @Override
    public List<Videojuegos> ListaFiltro(String filtro) {
        entity.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entity.getCriteriaBuilder();
        CriteriaQuery<Videojuegos> con1 = criteriaBuilder.createQuery(Videojuegos.class);
        con1.distinct(true);
        Root<Videojuegos> raiz = con1.from(Videojuegos.class);

        con1.where(
                criteriaBuilder.or(
                        criteriaBuilder.like(raiz.get("nombre"), "%" + filtro + "%"),
                        criteriaBuilder.like(raiz.get("clasificacion"), "%" + filtro + "%")
                )
        );

        TypedQuery<Videojuegos> query = entity.createQuery(con1);

        List<Videojuegos> lstvideo = query.getResultList();

        entity.getTransaction().commit();

        return lstvideo;
    }

}

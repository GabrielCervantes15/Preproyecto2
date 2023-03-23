/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Gabriel
 */
@Entity
@Table(name = "videojuegos")
public class Videojuegos implements Serializable {

    private static final long serialVersionUID = 1L;
    public Videojuegos(){
        
    }

    public Videojuegos(Integer id, String nombre, String clasificacion) {
        this.id = id;
        this.nombre = nombre;
        this.clasificacion = clasificacion;
    }

    public Videojuegos(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Videojuegos(Integer id) {
        this.id = id;
    }

    @Id
    @Column(name = "idEmpleado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombres", length = 60, nullable = false)
    private String nombre;

    @Column(name = "clasificacion", length = 10, nullable = false)
    private String clasificacion;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "idgenero", nullable = false)
    private Genero genero;

    public Videojuegos(String nombre, String clasificacion, Genero genero) {
        this.nombre = nombre;
        this.clasificacion = clasificacion;
        this.genero = genero;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Videojuegos)) {
            return false;
        }
        Videojuegos other = (Videojuegos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Videojuegos[ id=" + id + " ]";
    }

}

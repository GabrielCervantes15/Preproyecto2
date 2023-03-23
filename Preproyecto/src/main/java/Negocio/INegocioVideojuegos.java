/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import Entidades.Videojuegos;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface INegocioVideojuegos {
    public List<Videojuegos> agregaLista(List<Videojuegos> video);
    public List<Videojuegos> obtenerLista();
    public List<Videojuegos> obtenerListaFiltro(String filtro);
    public List<Videojuegos> obtenerListaFiltro(int limite,String filtro,int con);
}

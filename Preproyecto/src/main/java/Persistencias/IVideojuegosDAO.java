/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencias;

import Entidades.Videojuegos;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface IVideojuegosDAO {

    public List<Videojuegos> Lista();
    public List<Videojuegos> ListaFiltro(int limite,String filtro,  int con);
    public List<Videojuegos> ListaFiltro(String filtro);
    public boolean agregaLista(List<Videojuegos> video);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entidades.Videojuegos;
import java.util.List;
import Persistencias.IVideojuegosDAO;

/**
 *
 * @author Gabriel
 */
public class NegocioVideojuegos implements INegocioVideojuegos {

    private IVideojuegosDAO VideojuegosDAO;

    public NegocioVideojuegos(IVideojuegosDAO VideoDao) {
        this.VideojuegosDAO = VideoDao;
    }

    @Override
    public List<Videojuegos> agregaLista(List<Videojuegos> list) {
        if (!VideojuegosDAO.agregaLista(list)) {
            return null;
        }
        return list;
    }

    @Override
    public List<Videojuegos> obtenerLista() {
        List<Videojuegos> list = VideojuegosDAO.Lista();
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public List<Videojuegos> obtenerListaFiltro(int limite, String filtro, int con) {
        List<Videojuegos> list = VideojuegosDAO.ListaFiltro(limite, filtro, con);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public List<Videojuegos> obtenerListaFiltro(String filtro) {
        List<Videojuegos> list = VideojuegosDAO.ListaFiltro(filtro);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

}

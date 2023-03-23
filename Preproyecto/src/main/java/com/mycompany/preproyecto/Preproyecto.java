/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.preproyecto;

import Negocio.NegocioVideojuegos;
import Persistencias.VideojuegosDAO;
import Persistencias.ConexionBD;
import Persistencias.IConexionBD;
import forms.frmPantalla;
import Negocio.INegocioVideojuegos;
import Persistencias.IVideojuegosDAO;

/**
 *
 * @author Gabriel
 */
public class Preproyecto {

    public static void main(String[] args) {
        IConexionBD cone = new ConexionBD();
        IVideojuegosDAO animedao = new VideojuegosDAO(cone);
        INegocioVideojuegos animeNegocio = new NegocioVideojuegos(animedao);
        frmPantalla a = new frmPantalla(animeNegocio);
        a.setVisible(true);
    }
}

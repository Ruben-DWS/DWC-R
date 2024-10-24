package com.proyecto3.arquetipo.basic;

import servicios.ConexionFuncionalidad;
import servicios.InterfazConexion;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
       InterfazConexion cn = new ConexionFuncionalidad();
       
       cn.generarConexion();
    }
}

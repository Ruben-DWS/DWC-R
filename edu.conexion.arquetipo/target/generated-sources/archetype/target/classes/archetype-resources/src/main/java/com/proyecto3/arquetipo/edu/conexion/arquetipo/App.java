#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package com.proyecto3.arquetipo.${artifactId};

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

package Clases;

import java.util.ArrayList;

public class TestBD {
public static void main(String[] args) {
	ConexionMySQL pr = new ConexionMySQL();
	ArrayList<String> lista = pr.inicioSesion("prueba@prueba.com", "prueba");
	System.out.println(lista.toString());
}
}

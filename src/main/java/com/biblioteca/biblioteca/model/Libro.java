package com.biblioteca.biblioteca.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//1- Llamar lombok para ecribir menos código repetitivo
@Data//Permite que lombok acceda a los datos de la clase Libro.
@NoArgsConstructor//Agregando un constructor vacío.
@AllArgsConstructor//Agregando un constructor que recibe argumentos.

public class Libro {
    //Atributos de mi clase
    private int idLibro;
    private String ISBN;
    private String titulo;
    private String editorial;
    private int anioPublicacion;
    private String autor;
}

package com.biblioteca.biblioteca.repository;

//CRUD
import com.biblioteca.biblioteca.model.Libro;
import org.springframework.stereotype.Repository;

//2 importaciones
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

//3
import java.util.stream.Collectors;
@Repository
//A la clase
public class LibroRepository {

    //4. Agregar una lista interna que almacene los libros en este caso vacía.
    private List<Libro> listaLibros = new ArrayList<>();

    //Constructor que se inicialice automaticamente y me cree 10 libros en mi lista
    public LibroRepository(){
        //Agregar los Libros
        listaLibros.add(new Libro(1, "8908303707002", "Fuego y Sangre", "Penguin Random House Grupo Editorial", 2018, "George R R Martin"));
        listaLibros.add(new Libro(2, "9788497593793", "El Código Da Vinci", "Editorial Planeta", 2003, "Dan Brown"));
        listaLibros.add(new Libro(3, "9780307346605", "La Sombra del Viento", "Editorial Planeta", 2001, "Carlos Ruiz Zafón"));
        listaLibros.add(new Libro(4, "9780061120084", "Matar a un ruiseñor", "Harper Perennial Modern Classics", 1960, "Harper Lee"));
        listaLibros.add(new Libro(5, "9780345535528", "Juego de Tronos", "Bantam Books", 1996, "George R R Martin"));
        listaLibros.add(new Libro(6, "9788408172173", "Patria", "Tusquets Editores", 2016, "Fernando Aramburu"));
        listaLibros.add(new Libro(7, "9788466321181", "Los pilares de la Tierra", "DeBolsillo", 1989, "Ken Follett"));
        listaLibros.add(new Libro(8, "9788498383621", "El niño con el pijama de rayas", "Salamandra", 2006, "John Boyne"));
        listaLibros.add(new Libro(9, "9780142437230", "1984", "Penguin Books", 1949, "George Orwell"));
        listaLibros.add(new Libro(10, "9788420412148", "Cien años de soledad", "Editorial Sudamericana", 1967, "Gabriel García Márquez"));
    }


    //7- Metodo para obtener la cantidad total de libros
    public int totalLibros(){
        return listaLibros.size();//10
    }

    //8- Buscar un libro por su ISBN y va a retornar la primera coincidencia
    public Optional<Libro> buscarPorIsbn(String isbn){
        return listaLibros.stream().filter(Libro -> Libro.getISBN().equals(isbn)).findFirst();
    }
    //9- Metodo que cuenta los libros de un año especifico
    public Long contarPorAnio(int anio){
        return listaLibros.stream().filter(Libro -> Libro.getAnioPublicacion() == anio).count();
    }

    //10- Buscar todos los libros de un autor especifico
    public  List<Libro> buscarPorAutor(String autor){
        return listaLibros.stream().filter(Libro -> Libro.getAutor().equalsIgnoreCase(autor)).collect(Collectors.toList());
    }

    //11- Encontrar el libro con menor año de publicacion y obtiene el minimo por año
    public Optional<Libro> libroMasAntiguo(){
        return listaLibros.stream()
                .min(Comparator.comparingInt(Libro::getAnioPublicacion));
    }

    //12- Encontrar el libro con el año mas reciente
    public Optional<Libro> libroMasNuevo(){
        return  listaLibros.stream()
                .max(Comparator.comparingInt(Libro::getAnioPublicacion));
    }


    //13- Devolver lista completa ordenada por año ascendente
    public List<Libro> listarOrdenadosPorAnio(){
        return listaLibros.stream()
                .sorted(Comparator.comparingInt(Libro::getAnioPublicacion))
                .collect(Collectors.toList());
    }
}

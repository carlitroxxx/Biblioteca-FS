package com.biblioteca.biblioteca.service;


import com.biblioteca.biblioteca.model.Libro;
import com.biblioteca.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public int obtenerTotalLibros(){
        return libroRepository.totalLibros();
    }

    public Optional<Libro> buscarLibroPorIsbn(String isbn){
        return libroRepository.buscarPorIsbn(isbn);
    }

    public long contarLibrosPorAnio(int anio){
        return libroRepository.contarPorAnio(anio);
    }
    public List<Libro> buscarLibrosPorAutor(String autor){
        return libroRepository.buscarPorAutor(autor);
    }

    public Optional<Libro> buscarLibroMasAntiguo(){
        return libroRepository.libroMasAntiguo();
    }

    public Optional<Libro> buscarLibroMasNuevo(){
        return libroRepository.libroMasNuevo();
    }

    public List<Libro> listarOrdenadosPorAnio(){
        return libroRepository.listarOrdenadosPorAnio();
    }

}

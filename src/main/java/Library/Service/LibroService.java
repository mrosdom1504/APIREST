package Library.Service;

import Library.Entity.Libro;
import Library.Repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }
    public List<Libro> listarTodos() {
        return libroRepository.findAll();
    }
    public Libro guardar(Libro libro) {
        return libroRepository.save(libro);
    }
    public Libro buscarPorId(int id) {
        return libroRepository.findById(id).orElse(null);
    }
    public void eliminar(int id) {
        libroRepository.deleteById(id);
    }
}

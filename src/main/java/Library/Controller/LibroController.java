package Library.Controller;

import Library.Entity.Libro;
import Library.Service.LibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {
    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }
    @GetMapping
    public List<Libro> listarLibros() {
        return libroService.listarTodos();
    }

    @PostMapping
    public Libro crearLibro(@RequestBody Libro libro) {
        return libroService.guardar(libro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerLibro(@PathVariable int id) {
        Libro libro = libroService.buscarPorId(id);
        return libro != null ? ResponseEntity.ok(libro) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable int id, @RequestBody Libro nuevoLibro) {
        Libro existente = libroService.buscarPorId(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        existente.setTitulo(nuevoLibro.getTitulo());
        existente.setFechaPublicacion(nuevoLibro.getFechaPublicacion());
        return ResponseEntity.ok(libroService.guardar(existente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable int id) {
        libroService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

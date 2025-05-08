package Library.Controller;

import Library.Entity.Autor;
import Library.Service.AutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<Autor> listarAutores() {
        return autorService.listarTodos();
    }

    @PostMapping
    public Autor crearAutor(@RequestBody Autor autor) {
        return autorService.guardar(autor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> obtenerAutor(@PathVariable int id) {
        Autor autor = autorService.buscarPorId(id);
        return autor != null ? ResponseEntity.ok(autor) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> actualizarAutor(@PathVariable int id, @RequestBody Autor nuevoAutor) {
        Autor existente = autorService.buscarPorId(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        existente.setNombre(nuevoAutor.getNombre());
        existente.setApellido(nuevoAutor.getApellido());
        existente.setEmail(nuevoAutor.getEmail());
        return ResponseEntity.ok(autorService.guardar(existente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAutor(@PathVariable int id) {
        autorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}


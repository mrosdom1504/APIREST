package Library.Controller;

import Library.Entity.Autor;
import Library.Service.AutorRestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorRestService autorRestService;

    public AutorController(AutorRestService autorRestService) {
        this.autorRestService = autorRestService;
    }

    @GetMapping
    public List<Autor> listarAutores() {
        return autorRestService.obtenerAutores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> obtenerAutor(@PathVariable int id) {
        Autor autor = autorRestService.obtenerAutorPorId(id);
        return autor != null ? ResponseEntity.ok(autor) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Autor crearAutor(@RequestBody Autor autor) {
        return autorRestService.crearAutor(autor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarAutor(@PathVariable int id, @RequestBody Autor autor) {
        autorRestService.actualizarAutor(id, autor);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAutor(@PathVariable int id) {
        autorRestService.eliminarAutor(id);
        return ResponseEntity.noContent().build();
    }
}

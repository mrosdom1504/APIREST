package Library.Controller;

import Library.Entity.Editorial;
import Library.Service.EditorialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/editoriales")
public class EditorialController {
    private final EditorialService editorialService;
    public EditorialController(EditorialService editorialService) {
        this.editorialService = editorialService;
    }

    @GetMapping
    public String listarEditoriales() {
        return "Lista de editoriales";
    }
    @PostMapping
    public Editorial crearEditorial(@RequestBody Editorial editorial) {
        return editorialService.guardar(editorial);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Editorial> obtenerEditorial(@PathVariable int id) {
        Editorial editorial = editorialService.buscarPorId(id);
        return editorial != null ? ResponseEntity.ok(editorial) : ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Editorial> actualizarEditorial(@PathVariable int id, @RequestBody Editorial nuevoEditorial) {
        Editorial existente = editorialService.buscarPorId(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        existente.setNombre(nuevoEditorial.getNombre());
        existente.setDireccion(nuevoEditorial.getDireccion());
        return ResponseEntity.ok(editorialService.guardar(existente));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEditorial(@PathVariable int id) {
        editorialService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

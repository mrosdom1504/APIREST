package Library.Controller;

import Library.Service.SolicitudesHttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudesController {

    @Autowired
    private SolicitudesHttpService solicitudesHttpService;

    @GetMapping("/datos")
    public String obtenerDatos() {
        return solicitudesHttpService.obtenerDatos();
    }

    @PostMapping("/enviar")
    public String enviarDatos(@RequestBody Object datos) {
        return solicitudesHttpService.enviarDatos(datos);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarRecurso(@PathVariable Long id) {
        solicitudesHttpService.eliminarRecurso(id);
    }
}
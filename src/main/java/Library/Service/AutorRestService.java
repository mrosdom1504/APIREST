package Library.Service;

import Library.Entity.Autor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class AutorRestService {

    private final RestTemplate restTemplate;

    // URL base del servicio externo
    private static final String BASE_URL = "http://api.externa.com/autores";

    public AutorRestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Método GET para obtener todos los autores
    public List<Autor> obtenerAutores() {
        return restTemplate.getForObject(BASE_URL, List.class);
    }

    // Método GET para obtener un autor por su ID
    public Autor obtenerAutorPorId(int id) {
        String url = BASE_URL + "/" + id;
        return restTemplate.getForObject(url, Autor.class);
    }

    // Método POST para crear un nuevo autor
    public Autor crearAutor(Autor autor) {
        return restTemplate.postForObject(BASE_URL, autor, Autor.class);
    }

    // Método PUT para actualizar un autor
    public void actualizarAutor(int id, Autor autor) {
        String url = BASE_URL + "/" + id;
        restTemplate.put(url, autor);
    }

    // Método DELETE para eliminar un autor por su ID
    public void eliminarAutor(int id) {
        String url = BASE_URL + "/" + id;
        restTemplate.delete(url);
    }

    // Ejemplo de uso de parámetros en la URL con GET
    public List<Autor> obtenerAutoresConFiltro(String apellido) {
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .queryParam("apellido", apellido)
                .toUriString();
        return restTemplate.getForObject(url, List.class);
    }
}

package Library.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@Service
public class SolicitudesHttpService {

    @Autowired
    private RestTemplate restTemplate;

    // Realizar una solicitud GET
    public String obtenerDatos() {
        String url = "https://api.exaple.com/data";
        return restTemplate.getForObject(url, String.class);  // Devuelve los datos como String
    }

    // Realizar una solicitud POST
    public String enviarDatos(Object datos) {
        String url = "https://api.exaple.com/submit";
        return restTemplate.postForObject(url, datos, String.class);  // Envía datos y recibe la respuesta como String
    }

    // Solicitud POST con ResponseEntity
    public ResponseEntity<String> enviarDatosConRespuesta(Object datos) {
        String url = "https://api.exaple.com/submit";
        return restTemplate.postForEntity(url, datos, String.class);  // Devuelve un ResponseEntity con los datos
    }

    // Solicitud DELETE
    public void eliminarRecurso(Long id) {
        String url = "https://api.exaple.com/resource/" + id;
        restTemplate.delete(url);  // Elimina el recurso en la URL especificada
    }
}
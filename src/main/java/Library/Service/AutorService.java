package Library.Service;

import Library.Entity.Autor;
import Library.Repository.AutorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    public Autor guardar(Autor autor) {
        return autorRepository.save(autor);
    }

    public Autor buscarPorId(int id) {
        return autorRepository.findById(id).orElse(null);
    }

    public void eliminar(int id) {
        autorRepository.deleteById(id);
    }
}


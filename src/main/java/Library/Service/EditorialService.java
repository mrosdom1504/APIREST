package Library.Service;

import Library.Entity.Editorial;
import Library.Repository.EditorialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditorialService {
    private final EditorialRepository editorialRepository;

    public EditorialService(EditorialRepository editorialRepository) {
        this.editorialRepository = editorialRepository;
    }

    public List<Editorial> listarTodos() {
        return editorialRepository.findAll();
    }
    public Editorial guardar(Editorial editorial) {
        return editorialRepository.save(editorial);
    }
    public Editorial buscarPorId(int id) {
        return editorialRepository.findById(id).orElse(null);
    }
    public void eliminar(int id) {
        editorialRepository.deleteById(id);
    }
}

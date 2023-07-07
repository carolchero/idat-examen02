package idat.dw.practica02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/api/curso")
public class MainController {

    @Autowired
    private CursoRepository cursoRepository;

/*    @Autowired
    private JdbcTemplate jdbcTemplate;*/

    @PostMapping(path="/nuevo") // Map ONLY POST Requests
    public @ResponseBody String addNewCurso (@RequestParam String nombre, @RequestParam Integer creditos) {
        Curso c = new Curso();
        c.setNombre(nombre);
        c.setCreditos(creditos);
        cursoRepository.save(c);
        return "Saved";
    }

    @GetMapping(path="/listar")
    public @ResponseBody Iterable<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    @DeleteMapping(path="/eliminar")
    public @ResponseBody String delUser (@RequestParam Integer id) {
        Curso c = new Curso();
        c.setId(id);
        cursoRepository.delete(c);
        return "Deleted";
    }

}

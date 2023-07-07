package idat.dw.practica02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="")
public class MainController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping(path="")
    public @ResponseBody String getNombreCodigo() {
        return "PI47694351 - COTOS SULLON ROSAURA";
    }

    @GetMapping(path="/idat/codigo")
    public @ResponseBody String getCodigo() {
        return "PI47694351";
    }

    @GetMapping(path="/idat/nombre-completo")
    public @ResponseBody String getNombre() {
        return "COTOS SULLON ROSAURA";
    }

    @PostMapping(path="/api/curso/nuevo") // Map ONLY POST Requests
    public @ResponseBody String addNewCurso (@RequestParam String nombre, @RequestParam Integer creditos) {
        Curso c = new Curso();
        c.setNombre(nombre);
        c.setCreditos(creditos);
        cursoRepository.save(c);
        return "Saved";
    }

    @GetMapping(path="/api/curso/listar")
    public @ResponseBody Iterable<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    @DeleteMapping(path="/api/curso/eliminar")
    public @ResponseBody String delUser (@RequestParam Integer id) {
        Curso c = new Curso();
        c.setId(id);
        cursoRepository.delete(c);
        return "Deleted";
    }

}

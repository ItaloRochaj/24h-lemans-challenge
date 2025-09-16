package lemans_challenge.controller;

import lemans_challenge.dto.CarroDTO;
import lemans_challenge.dto.CarroHibridoDTO;
import lemans_challenge.service.CarroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carros")
public class CarroController {
    private final CarroService service;

    public CarroController(CarroService service) {
        this.service = service;
    }

    @GetMapping
    public List<CarroDTO> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public CarroDTO buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<CarroDTO> criar(@RequestBody CarroDTO dto) {
        CarroDTO criado = service.criar(dto);
        return ResponseEntity.status(201).body(criado);
    }

    @PutMapping("/{id}")
    public CarroDTO atualizar(@PathVariable Long id, @RequestBody CarroDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoints para carros híbridos
    @GetMapping("/hibridos")
    public List<CarroHibridoDTO> listarHibridos() {
        return service.listarTodosHibridos();
    }

    @GetMapping("/hibridos/{id}")
    public CarroHibridoDTO buscarHibrido(@PathVariable Long id) {
        return service.buscarHibridoPorId(id);
    }

    @PostMapping("/hibridos")
    public ResponseEntity<CarroHibridoDTO> criarHibrido(@RequestBody CarroHibridoDTO dto) {
        CarroHibridoDTO criado = service.criarHibrido(dto);
        return ResponseEntity.status(201).body(criado);
    }

    @PutMapping("/hibridos/{id}")
    public CarroHibridoDTO atualizarHibrido(@PathVariable Long id, @RequestBody CarroHibridoDTO dto) {
        return service.atualizarHibrido(id, dto);
    }

    @DeleteMapping("/hibridos/{id}")
    public ResponseEntity<Void> deletarHibrido(@PathVariable Long id) {
        service.deletarHibrido(id);
        return ResponseEntity.noContent().build();
    }
}
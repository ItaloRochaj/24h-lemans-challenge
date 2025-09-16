package lemans_challenge.controller;

import lemans_challenge.dto.PilotoDTO;
import lemans_challenge.service.PilotoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pilotos")
public class PilotoController {
    private final PilotoService service;

    public PilotoController(PilotoService service) {
        this.service = service;
    }

    @GetMapping
    public List<PilotoDTO> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public PilotoDTO buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<PilotoDTO> criar(@RequestBody PilotoDTO dto) {
        PilotoDTO criado = service.criar(dto);
        return ResponseEntity.status(201).body(criado);
    }

    @PutMapping("/{id}")
    public PilotoDTO atualizar(@PathVariable Long id, @RequestBody PilotoDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

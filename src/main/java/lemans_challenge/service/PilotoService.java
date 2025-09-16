package lemans_challenge.service;

import lemans_challenge.dto.PilotoDTO;

import java.util.List;

public interface PilotoService {
    List<PilotoDTO> listarTodos();
    PilotoDTO buscarPorId(Long id);
    PilotoDTO criar(PilotoDTO pilotoDTO);
    PilotoDTO atualizar(Long id, PilotoDTO pilotoDTO);
    void deletar(Long id);
}
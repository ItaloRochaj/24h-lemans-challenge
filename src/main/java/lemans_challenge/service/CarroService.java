package lemans_challenge.service;

import lemans_challenge.dto.CarroDTO;
import lemans_challenge.dto.CarroHibridoDTO;

import java.util.List;

public interface CarroService {
    List<CarroDTO> listarTodos();
    CarroDTO buscarPorId(Long id);
    CarroDTO criar(CarroDTO carroDTO);
    CarroDTO atualizar(Long id, CarroDTO carroDTO);
    void deletar(Long id);

    // Métodos para carros híbridos
    List<CarroHibridoDTO> listarTodosHibridos();
    CarroHibridoDTO buscarHibridoPorId(Long id);
    CarroHibridoDTO criarHibrido(CarroHibridoDTO carroHibridoDTO);
    CarroHibridoDTO atualizarHibrido(Long id, CarroHibridoDTO carroHibridoDTO);
    void deletarHibrido(Long id);
}
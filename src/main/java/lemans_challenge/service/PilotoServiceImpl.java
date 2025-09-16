package lemans_challenge.service;

import lemans_challenge.dto.PilotoDTO;
import lemans_challenge.entity.Piloto;
import lemans_challenge.exception.ResourceNotFoundException;
import lemans_challenge.mapper.PilotoMapper;
import lemans_challenge.repository.PilotoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PilotoServiceImpl implements PilotoService {

    private static final String PILOTO_NAO_ENCONTRADO = "Piloto não encontrado";
    private final PilotoRepository pilotoRepo;

    public PilotoServiceImpl(PilotoRepository pilotoRepo) {
        this.pilotoRepo = pilotoRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PilotoDTO> listarTodos() {
        return pilotoRepo.findAll()
                .stream()
                .map(PilotoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public PilotoDTO buscarPorId(Long id) {
        Piloto piloto = pilotoRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(PILOTO_NAO_ENCONTRADO));
        return PilotoMapper.toDTO(piloto);
    }

    @Override
    @Transactional
    public PilotoDTO criar(PilotoDTO dto) {
        Piloto piloto = PilotoMapper.toEntity(dto);
        return PilotoMapper.toDTO(pilotoRepo.save(piloto));
    }

    @Override
    @Transactional
    public PilotoDTO atualizar(Long id, PilotoDTO dto) {
        Piloto existente = pilotoRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(PILOTO_NAO_ENCONTRADO));
        existente.setNome(dto.getNome());
        existente.setHabilidade(dto.getHabilidade());
        existente.setIdade(dto.getIdade());
        return PilotoMapper.toDTO(pilotoRepo.save(existente));
    }

    @Override
    @Transactional
    public void deletar(Long id) {
        Piloto piloto = pilotoRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(PILOTO_NAO_ENCONTRADO));
        pilotoRepo.delete(piloto);
    }
}

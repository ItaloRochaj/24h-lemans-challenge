package lemans_challenge.service;

import lemans_challenge.dto.CarroDTO;
import lemans_challenge.dto.CarroHibridoDTO;
import lemans_challenge.entity.Carro;
import lemans_challenge.entity.CarroHibrido;
import lemans_challenge.entity.Piloto;
import lemans_challenge.exception.ResourceNotFoundException;
import lemans_challenge.mapper.CarroHibridoMapper;
import lemans_challenge.mapper.CarroMapper;
import lemans_challenge.repository.CarroHibridoRepository;
import lemans_challenge.repository.CarroRepository;
import lemans_challenge.repository.PilotoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarroServiceImpl implements CarroService {
    private static final String CARRO_NAO_ENCONTRADO = "Carro não encontrado";
    private static final String CARRO_HIBRIDO_NAO_ENCONTRADO = "Carro híbrido não encontrado";

    private final CarroRepository carroRepo;
    private final PilotoRepository pilotoRepo;
    private final CarroHibridoRepository carroHibridoRepo;

    public CarroServiceImpl(CarroRepository carroRepo, PilotoRepository pilotoRepo, CarroHibridoRepository carroHibridoRepo) {
        this.carroRepo = carroRepo;
        this.pilotoRepo = pilotoRepo;
        this.carroHibridoRepo = carroHibridoRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CarroDTO> listarTodos() {
        return carroRepo.findAll()
                .stream()
                .map(CarroMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CarroDTO buscarPorId(Long id) {
        Carro carro = carroRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(CARRO_NAO_ENCONTRADO));
        return CarroMapper.toDTO(carro);
    }

    @Override
    @Transactional
    public CarroDTO criar(CarroDTO dto) {
        Piloto piloto = pilotoRepo.findById(dto.getPilotoId())
                .orElseThrow(() -> new ResourceNotFoundException("Piloto não encontrado"));
        Carro carro = CarroMapper.toEntity(dto, piloto);
        return CarroMapper.toDTO(carroRepo.save(carro));
    }

    @Override
    @Transactional
    public CarroDTO atualizar(Long id, CarroDTO dto) {
        Carro existente = carroRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(CARRO_NAO_ENCONTRADO));
        Piloto piloto = pilotoRepo.findById(dto.getPilotoId())
                .orElseThrow(() -> new ResourceNotFoundException("Piloto não encontrado"));
        existente.setModelo(dto.getModelo());
        existente.setMotor(dto.getMotor());
        existente.setPneus(dto.getPneus());
        existente.setCombustivel(dto.getCombustivel());
        existente.setPiloto(piloto);
        return CarroMapper.toDTO(carroRepo.save(existente));
    }

    @Override
    @Transactional
    public void deletar(Long id) {
        Carro carro = carroRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(CARRO_NAO_ENCONTRADO));
        carroRepo.delete(carro);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CarroHibridoDTO> listarTodosHibridos() {
        return carroHibridoRepo.findAll()
                .stream()
                .map(CarroHibridoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CarroHibridoDTO buscarHibridoPorId(Long id) {
        CarroHibrido carro = carroHibridoRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(CARRO_HIBRIDO_NAO_ENCONTRADO));
        return CarroHibridoMapper.toDTO(carro);
    }

    @Override
    @Transactional
    public CarroHibridoDTO criarHibrido(CarroHibridoDTO dto) {
        Piloto piloto = pilotoRepo.findById(dto.getPilotoId())
                .orElseThrow(() -> new ResourceNotFoundException("Piloto não encontrado"));
        CarroHibrido carro = CarroHibridoMapper.toEntity(dto, piloto);
        return CarroHibridoMapper.toDTO(carroHibridoRepo.save(carro));
    }

    @Override
    @Transactional
    public CarroHibridoDTO atualizarHibrido(Long id, CarroHibridoDTO dto) {
        CarroHibrido carro = carroHibridoRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(CARRO_HIBRIDO_NAO_ENCONTRADO));
        Piloto piloto = pilotoRepo.findById(dto.getPilotoId())
                .orElseThrow(() -> new ResourceNotFoundException("Piloto não encontrado"));
        carro.setModelo(dto.getModelo());
        carro.setMotor(dto.getMotor());
        carro.setPneus(dto.getPneus());
        carro.abastecer(dto.getCombustivel());
        carro.setPiloto(piloto);
        carro.setEnergiaEletrica(dto.getEnergiaEletrica());
        return CarroHibridoMapper.toDTO(carroHibridoRepo.save(carro));
    }

    @Override
    @Transactional
    public void deletarHibrido(Long id) {
        CarroHibrido carro = carroHibridoRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(CARRO_HIBRIDO_NAO_ENCONTRADO));
        carroHibridoRepo.delete(carro);
    }
}

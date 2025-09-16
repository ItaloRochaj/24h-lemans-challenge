package lemans_challenge.mapper;

import lemans_challenge.dto.CarroHibridoDTO;
import lemans_challenge.entity.CarroHibrido;
import lemans_challenge.entity.Piloto;

public class CarroHibridoMapper {
    private CarroHibridoMapper() {}

    public static CarroHibridoDTO toDTO(CarroHibrido carro) {
        CarroHibridoDTO dto = new CarroHibridoDTO();
        dto.setId(carro.getId());
        dto.setModelo(carro.getModelo());
        dto.setMotor(carro.getMotor());
        dto.setPneus(carro.getPneus());
        dto.setCombustivel(carro.getCombustivel());
        dto.setPilotoId(carro.getPiloto() != null ? carro.getPiloto().getId() : null);
        dto.setEnergiaEletrica(carro.getEnergiaEletrica());
        return dto;
    }

    public static CarroHibrido toEntity(CarroHibridoDTO dto, Piloto piloto) {
        CarroHibrido carro = new CarroHibrido();
        carro.setId(dto.getId());
        carro.setModelo(dto.getModelo());
        carro.setMotor(dto.getMotor());
        carro.setPneus(dto.getPneus());
        carro.abastecer(dto.getCombustivel());
        carro.setPiloto(piloto);
        carro.setEnergiaEletrica(dto.getEnergiaEletrica());
        return carro;
    }
}


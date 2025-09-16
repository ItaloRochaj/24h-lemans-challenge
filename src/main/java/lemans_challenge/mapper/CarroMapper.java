package lemans_challenge.mapper;


import lemans_challenge.dto.CarroDTO;
import lemans_challenge.entity.Carro;
import lemans_challenge.entity.Piloto;

public class CarroMapper {
    private CarroMapper() {}

        public static CarroDTO toDTO(Carro carro) {
            CarroDTO dto = new CarroDTO();
            dto.setId(carro.getId());
            dto.setModelo(carro.getModelo());
            dto.setMotor(carro.getMotor());
            dto.setPneus(carro.getPneus());
            dto.setCombustivel(carro.getCombustivel());
            dto.setPilotoId(carro.getPiloto() != null ? carro.getPiloto().getId() : null);
            return dto;
        }

        public static Carro toEntity(CarroDTO dto, Piloto piloto) {
            Carro carro = new Carro();
            carro.setId(dto.getId());
            carro.setModelo(dto.getModelo());
            carro.setMotor(dto.getMotor());
            carro.setPneus(dto.getPneus());
            carro.setCombustivel(dto.getCombustivel());
            carro.setPiloto(piloto);
            return carro;
        }
}

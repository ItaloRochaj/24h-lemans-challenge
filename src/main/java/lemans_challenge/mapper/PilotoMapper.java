package lemans_challenge.mapper;


import lemans_challenge.dto.PilotoDTO;
import lemans_challenge.entity.Piloto;

public class PilotoMapper {
    private PilotoMapper() {}

        public static PilotoDTO toDTO(Piloto piloto) {
            PilotoDTO dto = new PilotoDTO();
            dto.setId(piloto.getId());
            dto.setNome(piloto.getNome());
            dto.setHabilidade(piloto.getHabilidade());
            dto.setIdade(piloto.getIdade());
            return dto;
        }

        public static Piloto toEntity(PilotoDTO dto) {
            Piloto piloto = new Piloto();
            piloto.setId(dto.getId());
            piloto.setNome(dto.getNome());
            piloto.setHabilidade(dto.getHabilidade());
            piloto.setIdade(dto.getIdade());
            return piloto;
        }
}

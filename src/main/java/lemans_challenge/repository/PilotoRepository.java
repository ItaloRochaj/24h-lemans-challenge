package lemans_challenge.repository;

import lemans_challenge.entity.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PilotoRepository extends JpaRepository<Piloto, Long> {

}

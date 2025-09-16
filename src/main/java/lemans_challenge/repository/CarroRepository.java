package lemans_challenge.repository;

import lemans_challenge.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  CarroRepository extends JpaRepository<Carro, Long>  {

}

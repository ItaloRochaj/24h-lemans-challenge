package lemans_challenge.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("HIBRIDO")
public class CarroHibrido extends Carro {
    private Double energiaEletrica = 100.0;

    public CarroHibrido() {
        super();
    }

    public CarroHibrido(String modelo, String motor, String pneus, Double combustivel, Piloto piloto, Double energiaEletrica) {
        super();
        setModelo(modelo);
        setMotor(motor);
        setPneus(pneus);
        abastecer(combustivel);
        setPiloto(piloto);
        this.energiaEletrica = energiaEletrica;
    }

    public Double getEnergiaEletrica() {
        return energiaEletrica;
    }

    public void setEnergiaEletrica(Double energiaEletrica) {
        this.energiaEletrica = energiaEletrica;
    }

    @Override
    public void realizarPitStop() {
        super.realizarPitStop();
        recarregarEnergia();
    }

    public void recarregarEnergia() {
        this.energiaEletrica = 100.0;
    }
}

package lemans_challenge.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "carros")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_carro", discriminatorType = DiscriminatorType.STRING)
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;
    private String motor;
    private String pneus;
    private Double combustivel;

    @OneToOne
    @JoinColumn(name = "piloto_id")
    private Piloto piloto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getPneus() {
        return pneus;
    }

    public void setPneus(String pneus) {
        this.pneus = pneus;
    }

    public Double getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Double combustivel) {
        this.combustivel = combustivel;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public void abastecer(Double quantidade) {
        if (quantidade != null && quantidade > 0) {
            if (this.combustivel == null) this.combustivel = 0.0;
            this.combustivel += quantidade;
        }
    }

    public void realizarPitStop() {
        // Operação padrão de pit stop para carros convencionais
        abastecer(50.0); // exemplo de abastecimento
    }
}

package energy.viridis.exercicio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity(name = "equipamento")
public class Equipamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O Equipamento deve ter um nome.")
    @Column
    private String nome;

    public Equipamento withId(Long id) {
        this.id = id;
        return this;
    }

    public Equipamento withNome(String nome) {
        this.nome = nome;
        return this;
    }
}

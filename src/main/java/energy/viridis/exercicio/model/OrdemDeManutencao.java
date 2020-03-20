package energy.viridis.exercicio.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity(name = "ordem_de_manutencao")
public class OrdemDeManutencao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "A ordem de manutenção deve estar associada a um equipamento existente.")
    @ManyToOne
    @JoinColumn(name = "equipamento_id", referencedColumnName = "id")
    private Equipamento equipamento;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm")
    @NotNull(message = "A ordem de manutenção deve ter uma data de agendamento.")
    @Column(name = "data_agendada")
    private Date dataAgendada;
}

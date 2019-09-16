package energy.viridis.exercicio.dto;

import java.util.Date;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class OrdemDeManutencaoDTO {

    @Nullable
    private Long equipamentoId;

    @Nullable
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm")
    private Date dataAgendada;
}

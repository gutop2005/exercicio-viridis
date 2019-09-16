package energy.viridis.exercicio.service;

import java.util.List;

import energy.viridis.exercicio.dto.OrdemDeManutencaoDTO;
import energy.viridis.exercicio.model.OrdemDeManutencao;

public interface OrdemDeManutencaoService {

    OrdemDeManutencao create(OrdemDeManutencaoDTO ordemDeManutencaoDTO);

    OrdemDeManutencao update(OrdemDeManutencaoDTO ordemDeManutencaoDTO, Long id);

    OrdemDeManutencao get(Long id);

    List<OrdemDeManutencao> getAll();

}

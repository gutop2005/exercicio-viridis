package energy.viridis.exercicio.service;

import java.util.List;

import energy.viridis.exercicio.model.Equipamento;

public interface EquipamentoService {

    Equipamento get(Long id);

    List<Equipamento> getAll();
}

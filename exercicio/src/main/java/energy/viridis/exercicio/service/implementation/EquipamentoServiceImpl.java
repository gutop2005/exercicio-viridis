package energy.viridis.exercicio.service.implementation;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import energy.viridis.exercicio.model.Equipamento;
import energy.viridis.exercicio.repository.EquipamentoRepository;
import energy.viridis.exercicio.service.EquipamentoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EquipamentoServiceImpl implements EquipamentoService {

    @Autowired
    EquipamentoRepository equipamentoRepository;

    @Override
    public Equipamento get(Long id) {

        log.info("Recuperando Equipamento - id: {}", id);

        return equipamentoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Equipamento não encontrado."));
    }

    @Override
    public List<Equipamento> getAll() {

        log.info("Listando todas os Equipamentos");

        return equipamentoRepository.findAll();
    }

}

package energy.viridis.exercicio.service.implementation;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import energy.viridis.exercicio.dto.OrdemDeManutencaoDTO;
import energy.viridis.exercicio.model.OrdemDeManutencao;
import energy.viridis.exercicio.repository.OrdemDeManutencaoRepository;
import energy.viridis.exercicio.service.EquipamentoService;
import energy.viridis.exercicio.service.OrdemDeManutencaoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrdemDeManutencaoServiceImpl implements OrdemDeManutencaoService {

    @Autowired
    private EquipamentoService equipamentoService;

    @Autowired
    OrdemDeManutencaoRepository ordemDeManutencaoRepository;

    @Override
    public OrdemDeManutencao create(OrdemDeManutencaoDTO ordemDeManutencaoDTO) {

        log.info("Criando Ordem de Manutenção...");

        return ordemDeManutencaoRepository.save(convertToEntity(ordemDeManutencaoDTO));
    }

    @Override
    public OrdemDeManutencao update(OrdemDeManutencaoDTO ordemDeManutencaoDTO, Long id) {

        OrdemDeManutencao ordemDeManutencao = ordemDeManutencaoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Ordem de Manutenção não encontrada."));

        log.info("Atualizando Ordem de Manutenção - id: {}", ordemDeManutencao.getId());

        return ordemDeManutencaoRepository.save(updateLocal(ordemDeManutencao, ordemDeManutencaoDTO));
    }

    @Override
    public OrdemDeManutencao get(Long id) {

        log.info("Recuperando Ordem de Manutenção - id: {}", id);

        return ordemDeManutencaoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Ordem de Manutenção não encontrada."));
    }

    @Override
    public List<OrdemDeManutencao> getAll() {

        log.info("Listando todas as Ordens de Manutenção...");

        return ordemDeManutencaoRepository.findAll();
    }

    private OrdemDeManutencao convertToEntity(OrdemDeManutencaoDTO ordemDeManutencaoDTO) {

        OrdemDeManutencao ordemDeManutencao = new OrdemDeManutencao();

        if (ordemDeManutencaoDTO.getEquipamentoId() != null) {
            ordemDeManutencao.setEquipamento(equipamentoService.get(ordemDeManutencaoDTO.getEquipamentoId()));
        }

        if (ordemDeManutencaoDTO.getDataAgendada() != null) {
            ordemDeManutencao.setDataAgendada(ordemDeManutencaoDTO.getDataAgendada());
        }

        return ordemDeManutencao;
    }

    private OrdemDeManutencao updateLocal(OrdemDeManutencao ordemDeManutencao,
            OrdemDeManutencaoDTO ordemDeManutencaoDTO) {

        if (ordemDeManutencaoDTO.getEquipamentoId() != null) {
            ordemDeManutencao.setEquipamento(equipamentoService.get(ordemDeManutencaoDTO.getEquipamentoId()));
        }

        if (ordemDeManutencaoDTO.getDataAgendada() != null) {
            ordemDeManutencao.setDataAgendada(ordemDeManutencaoDTO.getDataAgendada());
        }

        return ordemDeManutencao;
    }
}

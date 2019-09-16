package energy.viridis.exercicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import energy.viridis.exercicio.model.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {

}

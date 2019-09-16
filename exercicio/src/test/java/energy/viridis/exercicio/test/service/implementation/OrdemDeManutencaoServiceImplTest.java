package energy.viridis.exercicio.test.service.implementation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import energy.viridis.exercicio.model.Equipamento;
import energy.viridis.exercicio.model.OrdemDeManutencao;
import energy.viridis.exercicio.repository.OrdemDeManutencaoRepository;
import energy.viridis.exercicio.service.EquipamentoService;
import energy.viridis.exercicio.service.OrdemDeManutencaoService;
import energy.viridis.exercicio.service.implementation.OrdemDeManutencaoServiceImpl;

@RunWith(SpringRunner.class)
public class OrdemDeManutencaoServiceImplTest {

    @TestConfiguration
    static class OrdemDeManutencaoServiceImplTestTestContextConfiguration {

        @Bean
        public OrdemDeManutencaoService ordemDeManutencaoService() {
            return new OrdemDeManutencaoServiceImpl();
        }
    }

    @Autowired
    private OrdemDeManutencaoService ordemDeManutencaoService;

    @MockBean
    private OrdemDeManutencaoRepository ordemDeManutencaoRepository;

    @MockBean
    private EquipamentoService equipamentoService;

    private Long idOrdemDeManutencao1 = 1L;

    private Date dataOdM = new Date();

    private Long idEquipamento1 = 1L;

    private Long idOrdemDeManutencao2 = 2L;

    private Long idEquipamento2 = 2L;

    private List<OrdemDeManutencao> ordensDeManutencao = new ArrayList<>();

    @Before
    public void setUp() {

        Equipamento equipamento1 = new Equipamento().withId(idEquipamento1).withNome("Equipamento 1");

        OrdemDeManutencao ordemDeManutencao1 = new OrdemDeManutencao();
        ordemDeManutencao1.setId(idOrdemDeManutencao1);
        ordemDeManutencao1.setEquipamento(equipamento1);
        ordemDeManutencao1.setDataAgendada(dataOdM);

        OrdemDeManutencao ordemDeManutencao2 = new OrdemDeManutencao();
        ordemDeManutencao2.setId(idOrdemDeManutencao2);
        ordemDeManutencao2.setEquipamento(new Equipamento().withId(idEquipamento2).withNome("Equipamento 2"));
        ordemDeManutencao2.setDataAgendada(dataOdM);

        ordensDeManutencao.add(ordemDeManutencao1);
        ordensDeManutencao.add(ordemDeManutencao2);

        when(equipamentoService.get(idEquipamento1)).thenReturn(equipamento1);

        when(ordemDeManutencaoRepository.findById(ordemDeManutencao1.getId()))
                .thenReturn(Optional.of(ordemDeManutencao1));

        when(ordemDeManutencaoRepository.findAll()).thenReturn(ordensDeManutencao);
    }

    @Test
    public void givenOrdemDeManutencao_whenGet_ReturnOrdemDeManutencao() {

        OrdemDeManutencao ordemDeManutencaoBuscada = ordemDeManutencaoService.get(idOrdemDeManutencao1);

        assertThat(ordemDeManutencaoBuscada.getId(), equalTo(idOrdemDeManutencao1));
        assertThat(ordemDeManutencaoBuscada.getEquipamento().getId(), equalTo(idEquipamento1));
    }

    @Test(expected = NoSuchElementException.class)
    public void givenOrdemDeManutencaoIdInvalido_whenGet_ThrowNoSuchElementException() {
        ordemDeManutencaoService.get(0L);
    }

    @Test
    public void givenListaOrdemDeManutencaos_whenGetAll_ReturnListaOrdemDeManutencaos() {

        List<OrdemDeManutencao> ordemDeManutencaosBuscadas = ordemDeManutencaoRepository.findAll();

        assertThat(ordemDeManutencaosBuscadas.size(), equalTo(2));
    }
}

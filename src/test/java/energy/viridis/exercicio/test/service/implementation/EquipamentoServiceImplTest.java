package energy.viridis.exercicio.test.service.implementation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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
import energy.viridis.exercicio.repository.EquipamentoRepository;
import energy.viridis.exercicio.service.EquipamentoService;
import energy.viridis.exercicio.service.implementation.EquipamentoServiceImpl;
import junit.framework.TestCase;

@RunWith(SpringRunner.class)
public class EquipamentoServiceImplTest extends TestCase {

    @TestConfiguration
    static class EquipamentoServiceImplTestTestContextConfiguration {

        @Bean
        public EquipamentoService equipamentoService() {
            return new EquipamentoServiceImpl();
        }
    }

    @Autowired
    private EquipamentoService equipamentoService;

    @MockBean
    private EquipamentoRepository equipamentoRepository;

    private Long idEquipamento1 = 1L;

    private String nomeEquipamento1 = "Equipamento 1";

    private Long idEquipamento2 = 2L;

    private String nomeEquipamento2 = "Equipamento 2";

    private List<Equipamento> equipamentos = new ArrayList<>();

    @Before
    public void setUp() {

        Equipamento equipamento1 = new Equipamento();
        equipamento1.setId(idEquipamento1);
        equipamento1.setNome(nomeEquipamento1);

        Equipamento equipamento2 = new Equipamento();
        equipamento2.setId(idEquipamento2);
        equipamento2.setNome(nomeEquipamento2);

        equipamentos.add(equipamento1);
        equipamentos.add(equipamento2);

        when(equipamentoRepository.findById(equipamento1.getId())).thenReturn(Optional.of(equipamento1));

        when(equipamentoRepository.findAll()).thenReturn(equipamentos);
    }

    @Test
    public void givenEquipamento_whenGet_ReturnEquipamento() {

        Equipamento equipamentoBuscado = equipamentoService.get(idEquipamento1);

        assertThat(equipamentoBuscado.getId(), equalTo(idEquipamento1));
        assertThat(equipamentoBuscado.getNome(), equalTo(nomeEquipamento1));
    }

    @Test(expected = NoSuchElementException.class)
    public void givenEquipamentoIdInvalido_whenGet_ThrowNoSuchElementException() {
        equipamentoService.get(0L);
    }

    @Test
    public void givenListaEquipamentos_whenGetAll_ReturnListaEquipamentos() {

        List<Equipamento> equipamentosBuscados = equipamentoRepository.findAll();

        assertThat(equipamentosBuscados.size(), equalTo(2));
    }
}

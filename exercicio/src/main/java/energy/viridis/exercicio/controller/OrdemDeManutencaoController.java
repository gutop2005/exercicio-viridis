package energy.viridis.exercicio.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import energy.viridis.exercicio.dto.OrdemDeManutencaoDTO;
import energy.viridis.exercicio.model.OrdemDeManutencao;
import energy.viridis.exercicio.service.OrdemDeManutencaoService;

@RestController
@RequestMapping("/api/ordem-de-manutencao")
public class OrdemDeManutencaoController {

    @Autowired
    private OrdemDeManutencaoService ordemDeManutencaoService;

    @PostMapping
    public ResponseEntity<OrdemDeManutencaoDTO> create(@RequestBody OrdemDeManutencaoDTO ordemDeManutencaoDTO) {

        OrdemDeManutencao ordemDeManutencao = ordemDeManutencaoService.create(ordemDeManutencaoDTO);

        return ResponseEntity.created(URI.create(ordemDeManutencao.getId().toString())).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdemDeManutencao> update(@PathVariable("id") Long id,
            @RequestBody OrdemDeManutencaoDTO ordemDeManutencaoDTO) {
        return ResponseEntity.ok().body(ordemDeManutencaoService.update(ordemDeManutencaoDTO, id));
    }

    @GetMapping
    public ResponseEntity<List<OrdemDeManutencao>> getAll() {
        return ResponseEntity.ok().body(ordemDeManutencaoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdemDeManutencao> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(ordemDeManutencaoService.get(id));
    }
}

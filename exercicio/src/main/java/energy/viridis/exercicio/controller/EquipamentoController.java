package energy.viridis.exercicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import energy.viridis.exercicio.model.Equipamento;
import energy.viridis.exercicio.service.EquipamentoService;

@RestController
@RequestMapping("/api/equipamento")
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;

    @GetMapping
    public ResponseEntity<List<Equipamento>> getAll() {
        return ResponseEntity.ok().body(equipamentoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipamento> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(equipamentoService.get(id));
    }
}

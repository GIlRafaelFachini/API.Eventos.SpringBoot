package br.com.projeto.show.controllers;

import br.com.projeto.show.dto.EventoDto;
import br.com.projeto.show.service.interfaces.IEventoCrudService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EventoController {

    private IEventoCrudService eventoCrudService;

    public EventoController(IEventoCrudService alunoCrudService) {

        this.eventoCrudService = alunoCrudService;
    }

    @PostMapping("/")
    public EventoDto createEvento(
            @Validated
            @RequestBody EventoDto eventoDto) {
        return this.eventoCrudService.createEvento (eventoDto);
    }

    @GetMapping()
    public List<EventoDto> listEventos() {
        return this.eventoCrudService.listEventos ();
    }

    @PutMapping("/{id}")
    public void updateEvento(@PathVariable Long id,
                             @Validated
                             @RequestBody EventoDto eventoDto) {
        this.eventoCrudService.updateEvento (id, eventoDto);
    }

    @GetMapping("/{id}")
    public EventoDto getEvento(@PathVariable Long id) {
        return this.eventoCrudService.getEvento (id);
    }

    @DeleteMapping("/{id}")
    public void deleteEvento(@PathVariable Long id) {
        this.eventoCrudService.deleteEvento (id);
    }

}

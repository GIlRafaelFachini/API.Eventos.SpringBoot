package br.com.projeto.show.service;


import br.com.projeto.show.dto.EventoDto;
import br.com.projeto.show.model.Evento;
import br.com.projeto.show.repository.EventoRepository;
import br.com.projeto.show.service.interfaces.IEventoCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventoCrudCrudService implements IEventoCrudService {
    @Autowired
    private EventoRepository eventoRepository;

    public EventoDto createEvento(EventoDto eventoDto) {
        Evento evento = new Evento ();
        evento.setNomeDoEvento (eventoDto.getNomeDoEvento ());
        evento = eventoRepository.save (evento);

        eventoDto = new EventoDto (evento);
        return eventoDto;
    }

    public List<EventoDto> listEventos() {
        List<EventoDto> eventosDtos = new ArrayList<EventoDto> ();
        List<Evento> eventos = eventoRepository.findAll ();

        for (Evento evento : eventos) {
            EventoDto eventoDto = new EventoDto (evento);
            eventosDtos.add (eventoDto);
        }
        return eventosDtos;
    }

    public void updateEvento(Long id, EventoDto eventoDto) {

        Optional<Evento> eventoOptional = this.eventoRepository.findById (id);

        if (eventoOptional.isEmpty ()) {
            throw new ResponseStatusException (HttpStatus.NOT_FOUND, "Identificador não encontrado. Id:" + id); //retorna NotFound ('Não encontrado para a url');
        }

        Evento evento = eventoOptional.get ();
        evento.setNomeDoEvento (eventoDto.getNomeDoEvento ());
        this.eventoRepository.save (evento);
    }

    public EventoDto getEvento(Long id) {

        Optional<Evento> eventoOptional = this.eventoRepository.findById (id);

        if (eventoOptional.isEmpty ()) {
            throw new ResponseStatusException (HttpStatus.NOT_FOUND, "Identificador não encontrado. Id:" + id); //retorna NotFound ('Não encontrado para a url');
        }
        Evento evento = eventoOptional.get ();
        EventoDto eventoDto = new EventoDto (evento);
        return eventoDto;
    }

    public void deleteEvento(Long id) {

        Optional<Evento> eventoOptional = this.eventoRepository.findById (id);

        if (eventoOptional.isEmpty ()) {
            throw new ResponseStatusException (HttpStatus.NOT_FOUND, "Identificador não encontrado. Id:" + id); //retorna NotFound ('Não encontrado para a url');
        }
        Evento evento = eventoOptional.get ();
        this.eventoRepository.delete (evento);
    }
}

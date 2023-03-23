package br.com.projeto.show.dto;

import br.com.projeto.show.model.Evento;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventoDto {

    private Long codigo;
    @Size(min = 5, max = 30, message = "Campo deve ter entre 5 e 30 caracteres")
    private String nomeDoEvento;
    @Size(min = 5, max = 30, message = "Campo deve ter entre 5 e 30 caracteres")
    private String nomeDoPatrocinador;
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy - MM - dd")
    private Date dataDoEvento;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy - MM - dd")
    private Date dataDeCriacao;

    private String local;
    @Size(min = 5, max = 30, message = "Campo deve ter entre 5 e 30 caracteres")
    private String nomeDoArtista;
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date horarioDoInicio;
    @Max(value = 300, message = "A duração máxima do evento é de 5 horas.")
    private Integer duracao; // minutos
    private Integer lotacaoMaxima;

    public EventoDto(Evento evento) {
        this.codigo = evento.getCodigo ();
        this.nomeDoEvento = evento.getNomeDoEvento ();
        this.nomeDoPatrocinador = evento.getNomeDoPatrocinador ();
        this.dataDoEvento = evento.getDataDoEvento ();
        this.dataDeCriacao = evento.getDataDeCriacao ();
        this.local = evento.getLocal ();
        this.nomeDoArtista = evento.getNomeDoArtista ();
        this.horarioDoInicio = evento.getHorarioDoInicio ();
        this.duracao = evento.getDuracao ();
        this.lotacaoMaxima = evento.getLotacaoMaxima ();
    }
}

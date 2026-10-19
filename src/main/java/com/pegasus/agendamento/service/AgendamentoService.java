package com.pegasus.agendamento.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pegasus.agendamento.model.Agendamento;
import com.pegasus.agendamento.repository.AgendamentoRepository;

@Service 
public class AgendamentoService {
    
    @Autowired 
    private AgendamentoRepository agendamentoRepository;

    public Agendamento salvar(Agendamento agendamento){
        LocalDateTime horaFim = agendamento.getDataHora().plusHours(1);
        Agendamento agendado = agendamentoRepository.findByServicoAndDataHoraBetween(agendamento.getServico(), agendamento.getDataHora(), horaFim);
        if(Objects.nonNull(agendado)){
            throw new RuntimeException("Horario ja esta agendado!");
        }
        return agendamentoRepository.save(agendado);
    }

    public void excluir(LocalDateTime dataHora, String cliente){
        agendamentoRepository.deleteByDataHoraAndCliente(dataHora, cliente);
    }

    public List<Agendamento> buscarAgendamentosDia(LocalDate data){
        LocalDateTime primeiraHoraDia = data.atStartOfDay();
        LocalDateTime ultimaHoraDia = data.atTime(23,59,59);
        return agendamentoRepository.findByDataHoraBetween(primeiraHoraDia, ultimaHoraDia);
    }

    public Agendamento alterarAgendamento(Agendamento agendamento, String cliente, LocalDateTime dataHora){
        Agendamento agenda = agendamentoRepository.findByDataHoraAndCliente(dataHora, cliente);
        if(Objects.isNull(agenda)){
            throw new RuntimeException("Horario não esta disponivel!");
        }
        agendamento.setId(agenda.getId());
        
        return agendamentoRepository.save(agendamento);
    }
}

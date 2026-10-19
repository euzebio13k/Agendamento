package com.pegasus.agendamento.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.pegasus.agendamento.model.Agendamento;

public interface  AgendamentoRepository extends JpaRepository<Agendamento,Long>{

    Agendamento findByServicoAndDataHoraBetween(String servico, LocalDateTime dataHoraInicial, LocalDateTime dataHoraFinal);
    @Transactional 
    void deleteByDataHoraAndCliente(LocalDateTime dataHora, String Cliente);
    List<Agendamento> findByDataHoraBetween(LocalDateTime dataHoraInicial, LocalDateTime dataHoraFinal);
    Agendamento findByDataHoraAndCliente(LocalDateTime dataHora, String Cliente);
}

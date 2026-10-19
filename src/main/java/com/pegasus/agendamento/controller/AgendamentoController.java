package com.pegasus.agendamento.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pegasus.agendamento.model.Agendamento;
import com.pegasus.agendamento.service.AgendamentoService;

@RestController 
@RequestMapping ("/agendamentos")
public class AgendamentoController {

    @Autowired 
    private AgendamentoService agendamentoService;
    
    @PostMapping ("/salvar")
    public ResponseEntity<Agendamento> cadastrar(@RequestBody Agendamento agendamento){
        return ResponseEntity.accepted().body(agendamentoService.salvar(agendamento));
    }
    @DeleteMapping ("/excluir")
    public ResponseEntity<Void> excluir(@RequestParam String cliente, @RequestParam LocalDateTime dataHora){
        agendamentoService.excluir(dataHora, cliente);
        return ResponseEntity.noContent().build();
    }
    @GetMapping ("/listar")
    public ResponseEntity<List<Agendamento>> listar(@RequestParam LocalDate data){
        return ResponseEntity.ok().body(agendamentoService.buscarAgendamentosDia(data));
    }
    @PutMapping ("/alterar")
    public ResponseEntity<Agendamento> alterar(@RequestBody Agendamento agendamento, @RequestParam String cliente, @RequestParam LocalDateTime dataHora){
        
        return ResponseEntity.accepted().body(agendamentoService.alterarAgendamento(agendamento, cliente, dataHora));
    }

}

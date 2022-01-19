package com.example.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.dto.PedidoCreditoDTO;
import com.example.app.entity.Pedido;
import com.example.app.entity.Pessoa;
import com.example.app.repository.PedidoRepository;
import com.example.app.repository.PessoaRepository;
import com.example.app.service.PedidoService;
import com.example.app.service.PessoaService;

@RestController
@RequestMapping("/")
public class AnaliseCreditoController {
    
    @Autowired
    PedidoService pedidoService;
    @Autowired
    PessoaService pessoaService;
    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    PedidoRepository pedidoRepository;
    
    @PostMapping(value = "analise")
    public Pedido Post(@RequestBody PedidoCreditoDTO pedidoDTO) {
        Pessoa pessoa = pessoaService.parsePessoa(pedidoDTO);
        pessoa = pessoaRepository.saveAndFlush(pessoa);
        
        Pedido pedido = pedidoService.realizaPedidoEmprestimo(pessoa, pedidoDTO.getValorRequerido());
        pedido = pedidoRepository.saveAndFlush(pedido);
        
        return pedido;
    }
    
    @GetMapping(value="pedidos")
    public List<Pedido> getPedidos() {
        return pedidoRepository.findAll();
    }
}

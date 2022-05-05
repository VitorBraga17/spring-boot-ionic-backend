package com.bragavitor.cursospringb.services;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

import javax.transaction.Transactional;

import com.bragavitor.cursospringb.domain.ItemPedido;
import com.bragavitor.cursospringb.domain.PagamentoComBoleto;
import com.bragavitor.cursospringb.domain.Pedido;
import com.bragavitor.cursospringb.domain.enums.EstadoPagamento;
import com.bragavitor.cursospringb.repositories.ClienteRepository;
import com.bragavitor.cursospringb.repositories.ItemPedidoRepository;
import com.bragavitor.cursospringb.repositories.PagamentoRepository;
import com.bragavitor.cursospringb.repositories.PedidoRepository;
import com.bragavitor.cursospringb.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    @Autowired
    private BoletoService boletoService;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Pedido find(Integer id) {
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }

    @Transactional
    public Pedido insert(Pedido obj) {
        obj.setId(null);
        obj.setInstante(new Date());
        if(clienteRepository.findById(obj.getCliente().getId()).isPresent())
            obj.setCliente((clienteRepository.findById(obj.getCliente().getId()).get()));
        obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
        obj.getPagamento().setPedido(obj);
        if (obj.getPagamento() instanceof PagamentoComBoleto) {
            PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
            boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
        }
        obj = repo.save(obj);
        pagamentoRepository.save(obj.getPagamento());
        for(ItemPedido ip : obj.getItens()){
            ip.setDesconto(0.0);
            ip.setProduto(produtoService.find(ip.getProduto().getId()));
			ip.setPreço(ip.getProduto().getPreco());
            ip.setPedido(obj);
        }
        itemPedidoRepository.saveAll(obj.getItens());
        System.out.println(obj);
        return obj;
    }

}

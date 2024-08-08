package br.gov.ufg.controller;

import br.gov.ufg.dto.PedidoDTO;
import br.gov.ufg.entity.Pedido;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private List<Pedido> pedidos = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> getAllPedidos() {
        List<PedidoDTO> pedidoDTOs = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            pedidoDTOs.add(convertToDto(pedido));
        }
        return new ResponseEntity<>(pedidoDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> getPedidoById(@PathVariable int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getIdPedido() == id) {
                return new ResponseEntity<>(convertToDto(pedido), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> createPedido(@RequestBody PedidoDTO pedidoDTO) {
        Pedido pedido = convertToEntity(pedidoDTO);
        pedidos.add(pedido);
        return new ResponseEntity<>(convertToDto(pedido), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> updatePedido(@PathVariable int id, @RequestBody PedidoDTO updatedPedidoDTO) {
        for (Pedido pedido : pedidos) {
            if (pedido.getIdPedido() == id) {
                pedido.setDataPedido(updatedPedidoDTO.getDataPedido());
                pedido.setStatus(updatedPedidoDTO.getStatus());
                return new ResponseEntity<>(convertToDto(pedido), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getIdPedido() == id) {
                pedidos.remove(pedido);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    private PedidoDTO convertToDto(Pedido pedido) {
        return new PedidoDTO(pedido.getIdPedido(), pedido.getDataPedido(), pedido.getStatus());
    }

    private Pedido convertToEntity(PedidoDTO pedidoDTO) {
        return new Pedido(pedidoDTO.getIdPedido(), pedidoDTO.getDataPedido(), pedidoDTO.getStatus());
    }
}

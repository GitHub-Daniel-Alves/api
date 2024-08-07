package br.gov.ufg.controller;

import br.gov.ufg.dto.ClienteDTO;
import br.gov.ufg.entity.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin
@RestController
public class ClienteController {

    @PostMapping("/registrarCliente")
    public ResponseEntity<Cliente> registrarCliente(@RequestBody Cliente novoCliente) {
        List<Cliente> clientes;
        try {
            clientes = ClienteDTO.lerClientesDoArquivo();
        } catch (URISyntaxException | IOException e) {
            System.out.println("Erro ao ler o arquivo de clientes: " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        // Adiciona o novo cliente à lista
        clientes.add(novoCliente);

        try {
            // Salva a lista atualizada no arquivo
            ClienteDTO.escreverClientesNoArquivo(clientes);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo de clientes: " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }
}

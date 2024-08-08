package br.gov.ufg.controller;

import br.gov.ufg.dto.ClientePessoaFisicaDTO;
import br.gov.ufg.entity.ClientePessoaFísica;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/clientes/pessoafisica")
public class ClientePessoaFisicaController {
    private List<ClientePessoaFísica> clientes = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<ClientePessoaFisicaDTO>> getAllClientes() {
        List<ClientePessoaFisicaDTO> clienteDTOs = new ArrayList<>();
        for (ClientePessoaFísica cliente : clientes) {
            clienteDTOs.add(convertToDto(cliente));
        }
        return new ResponseEntity<>(clienteDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientePessoaFisicaDTO> getClienteById(@PathVariable int id) {
        for (ClientePessoaFísica cliente : clientes) {
            if (cliente.getIdCliente() == id) {
                return new ResponseEntity<>(convertToDto(cliente), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ClientePessoaFisicaDTO> createCliente(@RequestBody ClientePessoaFisicaDTO clienteDTO) {
        ClientePessoaFísica cliente = convertToEntity(clienteDTO);
        clientes.add(cliente);
        return new ResponseEntity<>(convertToDto(cliente), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientePessoaFisicaDTO> updateCliente(@PathVariable int id, @RequestBody ClientePessoaFisicaDTO updatedClienteDTO) {
        for (ClientePessoaFísica cliente : clientes) {
            if (cliente.getIdCliente() == id) {
                cliente.setNome(updatedClienteDTO.getNome());
                cliente.setEmail(updatedClienteDTO.getEmail());
                cliente.setEndereço(updatedClienteDTO.getEndereço());
                cliente.setTelefone(updatedClienteDTO.getTelefone());
                cliente.setUserName(updatedClienteDTO.getUserName());
                cliente.setPassword(updatedClienteDTO.getPassword());
                cliente.setCpf(updatedClienteDTO.getCpf());
                cliente.setDataNascimento(updatedClienteDTO.getDataNascimento());
                cliente.setRg(updatedClienteDTO.getRg());
                cliente.atualizaDados(cliente);
                return new ResponseEntity<>(convertToDto(cliente), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable int id) {
        for (ClientePessoaFísica cliente : clientes) {
            if (cliente.getIdCliente() == id) {
                clientes.remove(cliente);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody ClientePessoaFisicaDTO clienteDTO) {
        for (ClientePessoaFísica storedCliente : clientes) {
            if (storedCliente.getUserName().equals(clienteDTO.getUserName())
                    && storedCliente.getPassword().equals(clienteDTO.getPassword())) {
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/validarCPF")
    public ResponseEntity<Boolean> validarCPF(@RequestBody String cpf) {
        for (ClientePessoaFísica cliente : clientes) {
            if (cliente.validarCPF(cpf)) {
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    private ClientePessoaFisicaDTO convertToDto(ClientePessoaFísica cliente) {
        return new ClientePessoaFisicaDTO(cliente.getIdCliente(), cliente.getNome(), cliente.getEmail(), cliente.getEndereço(),
                cliente.getTelefone(), cliente.getUserName(), cliente.getPassword(), cliente.getCpf(), cliente.getDataNascimento(), cliente.getRg());
    }

    private ClientePessoaFísica convertToEntity(ClientePessoaFisicaDTO clienteDTO) {
        return new ClientePessoaFísica(clienteDTO.getIdCliente(), clienteDTO.getNome(), clienteDTO.getEmail(), clienteDTO.getEndereço(),
                clienteDTO.getTelefone(), clienteDTO.getUserName(), clienteDTO.getPassword(), clienteDTO.getCpf(), clienteDTO.getDataNascimento(), clienteDTO.getRg());
    }
}

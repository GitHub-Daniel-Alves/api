package br.gov.ufg.controller;

import br.gov.ufg.dto.ClientePessoaJuridicaDTO;
import br.gov.ufg.entity.ClientePessoaJurídica;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes/pessoajuridica")
public class ClientePessoaJuridicaController {
    private List<ClientePessoaJurídica> clientes = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<ClientePessoaJuridicaDTO>> getAllClientes() {
        List<ClientePessoaJuridicaDTO> clienteDTOs = new ArrayList<>();
        for (ClientePessoaJurídica cliente : clientes) {
            clienteDTOs.add(convertToDto(cliente));
        }
        return new ResponseEntity<>(clienteDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientePessoaJuridicaDTO> getClienteById(@PathVariable int id) {
        for (ClientePessoaJurídica cliente : clientes) {
            if (cliente.getIdCliente() == id) {
                return new ResponseEntity<>(convertToDto(cliente), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ClientePessoaJuridicaDTO> createCliente(@RequestBody ClientePessoaJuridicaDTO clienteDTO) {
        ClientePessoaJurídica cliente = convertToEntity(clienteDTO);
        clientes.add(cliente);
        return new ResponseEntity<>(convertToDto(cliente), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientePessoaJuridicaDTO> updateCliente(@PathVariable int id, @RequestBody ClientePessoaJuridicaDTO updatedClienteDTO) {
        for (ClientePessoaJurídica cliente : clientes) {
            if (cliente.getIdCliente() == id) {
                cliente.setNome(updatedClienteDTO.getNome());
                cliente.setEmail(updatedClienteDTO.getEmail());
                cliente.setEndereço(updatedClienteDTO.getEndereço());
                cliente.setTelefone(updatedClienteDTO.getTelefone());
                cliente.setUserName(updatedClienteDTO.getUserName());
                cliente.setPassword(updatedClienteDTO.getPassword());
                cliente.setCnpj(updatedClienteDTO.getCnpj());
                cliente.setRazaoSocial(updatedClienteDTO.getRazaoSocial());
                cliente.setInscricaoEstadual(updatedClienteDTO.getInscricaoEstadual());
                cliente.atualizaDados(cliente);
                return new ResponseEntity<>(convertToDto(cliente), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable int id) {
        for (ClientePessoaJurídica cliente : clientes) {
            if (cliente.getIdCliente() == id) {
                clientes.remove(cliente);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody ClientePessoaJuridicaDTO clienteDTO) {
        for (ClientePessoaJurídica storedCliente : clientes) {
            if (storedCliente.getUserName().equals(clienteDTO.getUserName())
                    && storedCliente.getPassword().equals(clienteDTO.getPassword())) {
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/validarCNPJ")
    public ResponseEntity<Boolean> validarCNPJ(@RequestBody String cnpj) {
        for (ClientePessoaJurídica cliente : clientes) {
            if (cliente.validarCNPJ(cnpj)) {
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    private ClientePessoaJuridicaDTO convertToDto(ClientePessoaJurídica cliente) {
        return new ClientePessoaJuridicaDTO(cliente.getIdCliente(), cliente.getNome(), cliente.getEmail(), cliente.getEndereço(),
                cliente.getTelefone(), cliente.getUserName(), cliente.getPassword(), cliente.getCnpj(), cliente.getRazaoSocial(), cliente.getInscricaoEstadual());
    }

    private ClientePessoaJurídica convertToEntity(ClientePessoaJuridicaDTO clienteDTO) {
        return new ClientePessoaJurídica(clienteDTO.getIdCliente(), clienteDTO.getNome(), clienteDTO.getEmail(), clienteDTO.getEndereço(),
                clienteDTO.getTelefone(), clienteDTO.getUserName(), clienteDTO.getPassword(), clienteDTO.getCnpj(), clienteDTO.getRazaoSocial(), clienteDTO.getInscricaoEstadual());
    }
}

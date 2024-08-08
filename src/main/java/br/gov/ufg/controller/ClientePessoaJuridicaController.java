package br.gov.ufg.controller;

import br.gov.ufg.dto.ClientePessoaJuridicaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes-pessoa-juridica")
public class ClientePessoaJuridicaController {

    private List<ClientePessoaJuridicaDTO> clientePessoaJuridicaList = new ArrayList<>();
    private int idCounter = 1;

    @PostMapping
    public ResponseEntity<ClientePessoaJuridicaDTO> createClientePessoaJuridica(@RequestBody ClientePessoaJuridicaDTO clientePessoaJuridicaDTO) {
        clientePessoaJuridicaDTO.setIdCliente(idCounter++);
        clientePessoaJuridicaList.add(clientePessoaJuridicaDTO);
        return new ResponseEntity<>(clientePessoaJuridicaDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientePessoaJuridicaDTO> getClientePessoaJuridicaById(@PathVariable int id) {
        ClientePessoaJuridicaDTO cliente = clientePessoaJuridicaList.stream()
                .filter(c -> c.getIdCliente() == id)
                .findFirst()
                .orElse(null);
        if (cliente != null) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<ClientePessoaJuridicaDTO>> getAllClientesPessoaJuridica() {
        return new ResponseEntity<>(clientePessoaJuridicaList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientePessoaJuridicaDTO> updateClientePessoaJuridica(@PathVariable int id, @RequestBody ClientePessoaJuridicaDTO clientePessoaJuridicaDTO) {
        Optional<ClientePessoaJuridicaDTO> existingClienteOpt = clientePessoaJuridicaList.stream()
                .filter(cliente -> cliente.getIdCliente() == id)
                .findFirst();

        if (existingClienteOpt.isPresent()) {
            ClientePessoaJuridicaDTO existingCliente = existingClienteOpt.get();
            existingCliente.setNome(clientePessoaJuridicaDTO.getNome());
            existingCliente.setEmail(clientePessoaJuridicaDTO.getEmail());
            existingCliente.setEndereco(clientePessoaJuridicaDTO.getEndereco());
            existingCliente.setTelefone(clientePessoaJuridicaDTO.getTelefone());
            existingCliente.setUserName(clientePessoaJuridicaDTO.getUserName());
            existingCliente.setPassword(clientePessoaJuridicaDTO.getPassword());
            existingCliente.setCnpj(clientePessoaJuridicaDTO.getCnpj());
            existingCliente.setRazaoSocial(clientePessoaJuridicaDTO.getRazaoSocial());
            existingCliente.setInscricaoEstadual(clientePessoaJuridicaDTO.getInscricaoEstadual());

            return new ResponseEntity<>(existingCliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClientePessoaJuridica(@PathVariable int id) {
        boolean isRemoved = clientePessoaJuridicaList.removeIf(cliente -> cliente.getIdCliente() == id);
        if (isRemoved) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

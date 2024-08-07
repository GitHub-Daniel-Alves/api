package br.gov.ufg.dto;

import br.gov.ufg.entity.Cliente;
import br.gov.ufg.entity.ClientePessoaFisica;
import br.gov.ufg.entity.ClientePessoaJuridica;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;

public class ClienteDTO {

    private static final String CLIENTES_FILE_PATH = "clientes.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        SimpleModule module = new SimpleModule();
        module.registerSubtypes(new NamedType(ClientePessoaFisica.class, "ClientePessoaFisica"));
        module.registerSubtypes(new NamedType(ClientePessoaJuridica.class, "ClientePessoaJuridica"));
        objectMapper.registerModule(module);
    }

    public static List<Cliente> lerClientesDoArquivo() throws URISyntaxException, IOException {
        File file = Paths.get(ClassLoader.getSystemResource(CLIENTES_FILE_PATH).toURI()).toFile();
        return objectMapper.readValue(file, new TypeReference<List<Cliente>>() {});
    }

    public static void escreverClientesNoArquivo(List<Cliente> clientes) throws IOException {
        File file = new File(CLIENTES_FILE_PATH);
        objectMapper.writeValue(file, clientes);
    }
}

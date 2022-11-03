package dio.quebec.service.impl;

import dio.quebec.model.Cliente;
import dio.quebec.model.Endereco;
import dio.quebec.repository.ClienteRepository;
import dio.quebec.repository.EnderecoRepository;
import dio.quebec.service.ClienteService;
import dio.quebec.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienterepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienterepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienterepository.findById(id);
                //.orElseThrow(() -> new EntityNotFoundException(id.toString()));
                //.orElse(null);

        if (!cliente.isPresent()) {
            throw new EntityNotFoundException(id.toString());
            //return null;
        }

        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        verificaEnderecoESalva(cliente);
    }

    private void verificaEnderecoESalva(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();

        Endereco endereco = enderecoRepository.findById(cep).orElseGet( () -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);

        clienterepository.save(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        if (!clienterepository.findById(id).isPresent()) {
            throw new EntityNotFoundException(id.toString());
            //return null;
        }

        verificaEnderecoESalva(cliente);
    }

    @Override
    public void deletar(Long id) {
        if (!clienterepository.findById(id).isPresent()) {
            throw new EntityNotFoundException(id.toString());
            //return null;
        }

        clienterepository.deleteById(id);
    }
}

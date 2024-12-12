package Crud.com.Bola.Service; 

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 

import Crud.com.Bola.Model.BolaModel;
import Crud.com.Bola.Repository.BolaRepository; 

@Service // Define a classe como um serviço gerenciado pelo Spring
public class BolaService { // Início da definição da classe BolaService

    @Autowired // Injeta automaticamente uma instância do repositório BolaRepository
    private BolaRepository repo; 

    // Método para listar todas as bolas
    public List<BolaModel> listarTodos() { // Método que retorna uma lista de todas as bolas
        return repo.findAll(); // Chama o método do repositório para retornar todas as bolas do banco
    }

    // Método para salvar uma nova bola
    public BolaModel salvar(BolaModel bola) { // Método que recebe uma instância de BolaModel e a salva
        return repo.save(bola); // Chama o método do repositório para salvar a bola no banco de dados
    }

    // Método para buscar uma bola pelo ID
    public BolaModel buscarPorId(Long id) { // Método que recebe um ID e retorna a bola correspondente
        return repo.findById(id).orElse(null); // Chama o método do repositório para buscar a bola pelo ID, retorna null se não encontrar
    }

    // Método para deletar uma bola pelo ID
    public void deletar(Long id) { // Método que recebe um ID e deleta a bola correspondente
        repo.deleteById(id); // Chama o método do repositório para deletar a bola do banco de dados
    }
}

	
	
	


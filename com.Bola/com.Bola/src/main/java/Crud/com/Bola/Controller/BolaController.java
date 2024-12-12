package Crud.com.Bola.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Crud.com.Bola.DTO.BolaDTO;
import Crud.com.Bola.Model.BolaModel;
import Crud.com.Bola.Service.BolaService;

@RestController // Define que a classe é um controlador REST
@RequestMapping("/bola") // Define a URL base para os endpoints como "/bola"
public class BolaController {

    @Autowired // Injeta automaticamente a instância do serviço BolaService
    private BolaService bolaService; 

    @GetMapping("/listar") // Define um endpoint HTTP GET para listar todas as bolas
    public ResponseEntity<List<BolaModel>> listar() {
        List<BolaModel> bolas = bolaService.listarTodos(); // Chama o serviço para listar todas as bolas
        return ResponseEntity.ok(bolas); // Retorna a lista de bolas com status HTTP 200 (OK)
    }

    @PostMapping("/criar") // Define um endpoint HTTP POST para criar uma nova bola
    public ResponseEntity<BolaModel> criar(@RequestBody BolaModel bola) {
        BolaModel novaBola = bolaService.salvar(bola); // Chama o serviço para salvar a bola
        return new ResponseEntity<>(novaBola, HttpStatus.CREATED); // Retorna a bola criada com status HTTP 201 (Criado)
    }

    @GetMapping("/listar/{id}") // Define um endpoint HTTP GET para buscar uma bola pelo ID
    public ResponseEntity<BolaModel> buscarPorId(@PathVariable Long id) {
        BolaModel bola = bolaService.buscarPorId(id); // Chama o serviço para buscar a bola pelo ID
        if (bola != null) { // Se a bola for encontrada
            return ResponseEntity.ok(bola); // Retorna a bola com status HTTP 200 (OK)
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna status HTTP 404 (Não Encontrado)
        }
    }

    @PutMapping("/atualizar/{id}") // Define um endpoint HTTP PUT para atualizar uma bola existente
    public ResponseEntity<String> atualizarBola(@PathVariable Long id, @RequestBody BolaDTO dto) {
        BolaModel bola = bolaService.buscarPorId(id); // Chama o serviço para buscar a bola pelo ID
        if (bola != null) { // Se a bola for encontrada
            bola.updateFromDTO(dto);  // Atualiza a bola com os dados do DTO
            bolaService.salvar(bola);  // Chama o serviço para salvar a bola atualizada
            return ResponseEntity.ok("Bola atualizada com sucesso"); // Retorna mensagem de sucesso com status HTTP 200 (OK)
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bola não encontrada"); // Retorna erro se bola não for encontrada
        }
    }

    @DeleteMapping("/deletar/{id}") // Define um endpoint HTTP DELETE para excluir uma bola pelo ID
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        BolaModel bola = bolaService.buscarPorId(id); // Chama o serviço para buscar a bola pelo ID
        if (bola != null) { // Se a bola for encontrada
            bolaService.deletar(id); // Chama o serviço para deletar a bola
            return ResponseEntity.noContent().build(); // Retorna status HTTP 204 (Sem Conteúdo) após deletar
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna erro se bola não for encontrada
        }
    }
}

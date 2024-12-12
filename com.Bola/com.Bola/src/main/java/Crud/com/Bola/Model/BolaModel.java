package Crud.com.Bola.Model;

import java.time.LocalDate;
import Crud.com.Bola.DTO.BolaDTO; 

import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; 
import jakarta.persistence.Table;

@Entity // Define a classe como uma entidade JPA (persistente no banco de dados)
@Table(name = "bola") // Define o nome da tabela no banco de dados como "bola"
public class BolaModel { // Início da definição da classe BolaModel

    @Id // Define o campo id como a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o valor do id será gerado automaticamente pelo banco de dados
    private Long id; // Campo que representa o id único da bola

    private String cor; // Campo para armazenar a cor da bola
    private String tipo; // Campo para armazenar o tipo da bola (ex: futebol, basquete, etc.)
    private Double tamanho; // Campo para armazenar o tamanho da bola
    private String material; // Campo para armazenar o material da bola (ex: couro, sintético, etc.)
    private Double peso; // Campo para armazenar o peso da bola
    private String marca; // Campo para armazenar a marca da bola
    private LocalDate dataFabricacao; // Campo para armazenar a data de fabricação da bola

    // Construtor padrão (sem parâmetros)
    public BolaModel() {
    }

    // Construtor com parâmetros para inicializar todos os campos da classe
    public BolaModel(Long id, String cor, String tipo, Double tamanho, String material, Double peso, String marca, LocalDate dataFabricacao) {
        this.id = id; // Inicializa o id
        this.cor = cor; // Inicializa a cor
        this.tipo = tipo; // Inicializa o tipo
        this.tamanho = tamanho; // Inicializa o tamanho
        this.material = material; // Inicializa o material
        this.peso = peso; // Inicializa o peso
        this.marca = marca; // Inicializa a marca
        this.dataFabricacao = dataFabricacao; // Inicializa a data de fabricação
    }

    // Getters e Setters para acessar e modificar os campos privados da classe
    public Long getId() { // Getter para o id
        return id;
    }

    public void setId(Long id) { // Setter para o id
        this.id = id;
    }

    public String getCor() { // Getter para a cor
        return cor;
    }

    public void setCor(String cor) { // Setter para a cor
        this.cor = cor;
    }

    public String getTipo() { // Getter para o tipo
        return tipo;
    }

    public void setTipo(String tipo) { // Setter para o tipo
        this.tipo = tipo;
    }

    public Double getTamanho() { // Getter para o tamanho
        return tamanho;
    }

    public void setTamanho(Double tamanho) { // Setter para o tamanho
        this.tamanho = tamanho;
    }

    public String getMaterial() { // Getter para o material
        return material;
    }

    public void setMaterial(String material) { // Setter para o material
        this.material = material;
    }

    public Double getPeso() { // Getter para o peso
        return peso;
    }

    public void setPeso(Double peso) { // Setter para o peso
        this.peso = peso;
    }

    public String getMarca() { // Getter para a marca
        return marca;
    }

    public void setMarca(String marca) { // Setter para a marca
        this.marca = marca;
    }

    public LocalDate getDataFabricacao() { // Getter para a data de fabricação
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) { // Setter para a data de fabricação
        this.dataFabricacao = dataFabricacao;
    }

    // Método para atualizar os dados do objeto usando um DTO (Data Transfer Object)
    public void updateFromDTO(BolaDTO dto) { // Recebe um objeto DTO com os dados atualizados
        this.cor = dto.cor(); // Atualiza a cor da bola com o valor do DTO
        this.tipo = dto.tipo(); // Atualiza o tipo da bola com o valor do DTO
        this.tamanho = dto.tamanho(); // Atualiza o tamanho da bola com o valor do DTO
        this.material = dto.material(); // Atualiza o material da bola com o valor do DTO
        this.peso = dto.peso(); // Atualiza o peso da bola com o valor do DTO
        this.marca = dto.marca(); // Atualiza a marca da bola com o valor do DTO
        this.dataFabricacao = dto.dataFabricacao(); // Atualiza a data de fabricação da bola com o valor do DTO
    }
}

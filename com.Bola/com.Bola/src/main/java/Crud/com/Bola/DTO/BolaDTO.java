package Crud.com.Bola.DTO; 

import java.time.LocalDate; 

// Define o record BolaDTO, que é um tipo imutável com um construtor, getters e outros métodos prontos para uso
public record BolaDTO(Long id, String cor, String tipo, Double tamanho, String material, Double peso, String marca, LocalDate dataFabricacao) { 
    // O record automaticamente cria um construtor, métodos getters (como id(), cor()), equals(), hashCode() e toString() para os campos
}

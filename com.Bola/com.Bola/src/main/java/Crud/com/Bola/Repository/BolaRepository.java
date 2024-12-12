package Crud.com.Bola.Repository; 

import org.springframework.data.jpa.repository.JpaRepository;

import Crud.com.Bola.Model.BolaModel; 

public interface BolaRepository extends JpaRepository<BolaModel, Long> { // Define a interface BolaRepository, que estende JpaRepository
    // JpaRepository oferece todos os métodos básicos como save(), findById(), delete(), etc., para a entidade BolaModel e sua chave primária Long
}


	

 



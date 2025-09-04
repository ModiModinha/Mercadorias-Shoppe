package br.com.MercShoppe.dev.MercShoppe_api.repository;

import br.com.MercShoppe.dev.MercShoppe_api.Entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {
}

package br.com.MercShoppe.dev.MercShoppe_api.repository;

import br.com.MercShoppe.dev.MercShoppe_api.Entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FornecedorRepository extends JpaRepository<Fornecedor, UUID> {
}

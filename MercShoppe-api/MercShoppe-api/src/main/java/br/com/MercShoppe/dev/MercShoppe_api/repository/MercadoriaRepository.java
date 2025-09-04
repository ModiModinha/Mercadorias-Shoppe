package br.com.MercShoppe.dev.MercShoppe_api.repository;

import br.com.MercShoppe.dev.MercShoppe_api.Entity.Mercadoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MercadoriaRepository extends JpaRepository<Mercadoria, UUID> {

}

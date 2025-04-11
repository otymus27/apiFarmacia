package otymus.com.farmacia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import otymus.com.farmacia.entities.Item;

@Repository

// Aqui já tenho tudo necessário para manipulação no banco de dados
public interface ItemRepository extends JpaRepository<Item, Long> {
}

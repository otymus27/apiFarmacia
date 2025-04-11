package otymus.com.farmacia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import otymus.com.farmacia.entities.Item;
import otymus.com.farmacia.repositories.ItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> listar(){
        return itemRepository.findAll();
    }

    public Optional<Item> buscarPorId(Long id) {
        return itemRepository.findById(id);
    }

    public Item cadastrar(Item item) {
        return itemRepository.save(item);
    }

    public Item alterar(Long id, Item itemDetails) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item não encontrado"));
        item.setNome(itemDetails.getNome());
        item.setDescricao(itemDetails.getDescricao());
        item.setQuantidade(itemDetails.getQuantidade());
        item.setPreco(itemDetails.getPreco());
        return itemRepository.save(item);
    }

    public void excluir(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() ->new RuntimeException("Item não encontrado"));
        itemRepository.delete(item);
    }


}

package otymus.com.farmacia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import otymus.com.farmacia.entities.Item;
import otymus.com.farmacia.services.ItemService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> listar() {
        return itemService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Item> buscarPorId(@PathVariable Long id) {
        return itemService.buscarPorId(id);
    }

    @PostMapping
    public Item cadastrar(@RequestBody Item item) {
        return itemService.cadastrar(item);
    }

    @PutMapping("/{id}")
    public Item alterar(@PathVariable Long id, @RequestBody Item itemDetails) {
        return itemService.alterar(id, itemDetails);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        itemService.excluir(id);
    }

}

package N78braga.com.github.produtosApi.controller;

import N78braga.com.github.produtosApi.Repository.ProdutoRepository;
import N78braga.com.github.produtosApi.model.Produto;
import jdk.javadoc.doclet.Doclet;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    //public void salvar(@RequestBody Produto produto){
    public Produto salvar(@RequestBody Produto produto) {
        System.out.println("Produto recebebido: " + produto);
        var id = UUID.randomUUID().toString();
        produto.setId(id);
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping("{id}")
    public Produto obterPorId(@PathVariable("id") String id) {
        // Optional<Produto> produtos = produtoRepository.findById(id);
        //  return produtos.isPresent() ? produtos.get():null;
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable("id") String id) {
        produtoRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void atualizar(@PathVariable("id") String id, @RequestBody Produto produto) {
        produto.setId(id);
        produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> buscar(@RequestParam("name") String name) {
        return produtoRepository.findByName(name);
    }

}

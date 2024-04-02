package br.com.fiap.msproduto.controller;

import br.com.fiap.msproduto.ProdutoApplication;
import br.com.fiap.msproduto.model.Produto;
import br.com.fiap.msproduto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public Produto cadastrarProduto(@RequestBody Produto produto){
        return produtoService.cadastrarProduto(produto);
    }

    @GetMapping
    public List<Produto> listarProduto(){
        return produtoService.listarProduto();
    }

    @GetMapping("/{produtoId}")
    public ResponseEntity<?> listarUmProduto(@PathVariable Integer produtoId){
        return produtoService.listarUmProduto(produtoId);
    }

    @PutMapping("/{produtoId}")
    public Produto atualizarProduto(@PathVariable Integer produtoId,
                                    @RequestBody Produto novoProuto){
        return produtoService.atualizarProduto(produtoId, novoProuto);
    }

    @DeleteMapping("/{produtoId}")
    public void excluirProduto(@PathVariable Integer produtoId){
        produtoService.excluirProduto(produtoId);
    }

}

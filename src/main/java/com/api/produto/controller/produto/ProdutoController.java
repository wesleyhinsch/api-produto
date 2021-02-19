package com.api.produto.controller.produto;

import com.api.produto.model.Produto;
import com.api.produto.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api/produto")
@Api(value="API Produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @ApiOperation(value="Retornar lista com todos os Produtos")
    @GetMapping("/v1.0")
    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    @ApiOperation(value="Buscar um unico produto")
    @GetMapping("/v1.0/{id}")
    public Produto listarProdutoUnico(@PathVariable(value="id") long id){
        return produtoRepository.findById(id);
    }

    @ApiOperation(value="Salvar um unico produto")
    @PostMapping("/v1.0")
    public Produto salvarProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @ApiOperation(value="Deletar um unico produto")
    @DeleteMapping("/v1.0")
    public void deletarProduto(@RequestBody Produto produto) {
        produtoRepository.delete(produto);
    }

    @ApiOperation(value="Atualizar um unico produto")
    @PutMapping("/v1.0")
    public Produto atualizarProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }


}

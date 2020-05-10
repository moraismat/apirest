package com.produtos.apirest.resources;


import java.util.List;

import com.produtos.apirest.models.Projeto;
import com.produtos.apirest.repository.ProjetoRepository;

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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// Classe que irá receber as requisições HTTP
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Projeto")
@CrossOrigin(origins = "*") // qualquer dominio pode acessar a api
public class ProjetoResource {
    
    @Autowired
    ProjetoRepository produtoRepository;

    // Listar os produtos salvos no banco de dados
    @GetMapping("/projetos")
    @ApiOperation(value="Retorna uma lista de produtos")
    public List<Projeto> listaProdutos(){
        return produtoRepository.findAll();

    }
    // Listar o produto salvo no banco de dados atraves do seu id
    @GetMapping("/projeto/{id}")
    @ApiOperation(value="Retorna um unico produto")
    public Projeto listaProduto(@PathVariable(value ="id") long id){
        return produtoRepository.findById(id);
 
    }

    // Metodo para postar/criar um produto, RequestBody -> produto vem no corpo da requisição
    @PostMapping("/projeto")
    @ApiOperation(value="Esse metodo salva um produto")
    public Projeto salvaProduto(@RequestBody Projeto projeto){

        return produtoRepository.save(projeto);
    }

    // Metodo para deletar um produto
    @DeleteMapping("/projeto")
    @ApiOperation(value="Esse metodo deleta um produto")
    public void deleteProduto(@RequestBody Projeto projeto){
        produtoRepository.delete(projeto);
    }

    // Método para modificar um produto
    @PutMapping("/projeto")
    @ApiOperation(value="Esse metodo atualiza um produto")
    public Projeto atualizaProduto(@RequestBody Projeto projeto) {

        return produtoRepository.save(projeto);
    }
}
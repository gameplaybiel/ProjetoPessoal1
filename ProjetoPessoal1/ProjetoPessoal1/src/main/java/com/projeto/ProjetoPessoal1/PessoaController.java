package com.projeto.ProjetoPessoal1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PessoaController {

    @Autowired
    PessoaDao dao;

    @PostMapping("/pessoa")
    public Pessoa inserir(@RequestBody Pessoa p) throws Exception {
        return dao.inserir(p);
    }

    @GetMapping("/pessoa")
    public List<Pessoa> listar() throws Exception {
        return dao.listar();
    }

    @GetMapping("/pessoa/{id}")
    public Pessoa obter(@PathVariable int id) throws Exception {
        return dao.obter(id);
    }

}

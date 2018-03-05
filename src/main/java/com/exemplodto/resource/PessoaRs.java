package com.exemplodto.resource;

import java.util.List;

import com.exemplodto.dao.PessoaEnderecoDAO;
import com.exemplodto.dto.PessoaEnderecoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PessoaRs {

    @Autowired
    private PessoaEnderecoDAO dao;

    //http://localhost:8080/pessoa/loadData
    @GetMapping(path = "/loadData")
    public void carregaDados() {
        dao.carregar();
    }

    //http://localhost:8080/pessoa/endereco/2
    @GetMapping(path = "/endereco/{id}")
    public List<PessoaEnderecoDTO> listaPessoasPorEndereco(@PathVariable Long id) {
        return dao.PessoaPorEndereco(id);
    }
}

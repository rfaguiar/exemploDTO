package com.exemplodto.dao.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.exemplodto.dao.PessoaEnderecoDAO;
import com.exemplodto.dto.PessoaEnderecoDTO;
import com.exemplodto.dto.model.Endereco;
import com.exemplodto.dto.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PessoaEnderecoDAOImpl implements PessoaEnderecoDAO {

    @Autowired
    private EntityManager em;

    @Override
    public List<PessoaEnderecoDTO> PessoaPorEndereco(Long idEndereco) {

//        String jpql = "SELECT p.nome, e.logradouro FROM Endereco e JOIN e.pessoa p WHERE e.id = :idEnd ";
        String sql = "SELECT p.nome, e.logradouro FROM Pessoa as p LEFT JOIN Endereco as e WHERE p.id = e.id AND e.id = :idEnd ";

        List<Object[]> result = em.createNativeQuery(sql).setParameter("idEnd", idEndereco).getResultList();

        List<PessoaEnderecoDTO> retorno = new ArrayList<>();

        for (Object[] obj: result) {
            String nome = obj[0] != null ? obj[0].toString() : "";
            String logradouro = obj[1] != null ? obj[1].toString() : "";
            retorno.add(new PessoaEnderecoDTO(nome, logradouro));
        }

        return retorno;
    }

    @Transactional
    @Override
    public void carregar() {

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Fulano");
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Ciclano");

        Endereco end1 = new Endereco();
        end1.setPessoa(pessoa1);
        end1.setLogradouro("logra fulano");
        end1.setNumero(200);

        Endereco end2 = new Endereco();
        end2.setPessoa(pessoa2);
        end2.setLogradouro("logra Ciclano");
        end2.setNumero(350);


        em.persist(pessoa1);
        em.persist(pessoa2);
        em.persist(end1);
        em.persist(end2);


    }
}

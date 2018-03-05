package com.exemplodto.dao;

import java.util.List;

import com.exemplodto.dto.PessoaEnderecoDTO;

public interface PessoaEnderecoDAO {

    public List<PessoaEnderecoDTO> PessoaPorEndereco(Long idEndereco);

    public void carregar();
}

package com.exemplodto.dto;

import java.util.Objects;

public class PessoaEnderecoDTO {

    private String nomePessoa;
    private String logradouro;

    public PessoaEnderecoDTO(String nomePessoa, String logradouro) {
        this.nomePessoa = nomePessoa;
        this.logradouro = logradouro;
    }

    public PessoaEnderecoDTO() {}

    @Override
    public String toString() {
        return "PessoaEnderecoDTO{" +
                "nomePessoa='" + nomePessoa + '\'' +
                ", logradouro='" + logradouro + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PessoaEnderecoDTO)) return false;
        PessoaEnderecoDTO that = (PessoaEnderecoDTO) o;
        return Objects.equals(getNomePessoa(), that.getNomePessoa()) &&
                Objects.equals(getLogradouro(), that.getLogradouro());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getNomePessoa(), getLogradouro());
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

}

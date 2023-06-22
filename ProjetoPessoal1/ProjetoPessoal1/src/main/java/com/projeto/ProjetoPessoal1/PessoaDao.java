package com.projeto.ProjetoPessoal1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PessoaDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    //Dao pra inserir
    public Pessoa inserir(Pessoa p) throws Exception {
        String sqlInsert = "INSERT INTO Pessoa (NOME, ENDERECO, TELEFONE, CIDADE) "
                + "VALUES (?, ?, ?)";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sqlInsert);) {
            ps.setString(1, p.getNome());
            ps.setString(2, p.getEndereco());
            ps.setString(3, p.getTelefone());
            ps.setString(4, p.getCidade());
            int result = ps.executeUpdate();
            if (result == 1) {
                System.out.println("Pessoa inserida com sucesso.");
                return p;
            }
            ps.close();
            throw new Exception("Erro na inserção.");
        }
    }

    //Dao pra listar
    public List<Pessoa> listar() throws Exception {
        String sqlSelect = "select ID, NOME, ENDERECO, TELEFONE, CIDADE from Pessoa";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sqlSelect);) {
            List<Pessoa> lista = new ArrayList<>();
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    Pessoa p = new Pessoa();
                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    p.setEndereco(rs.getString("endereco"));
                    p.setTelefone(rs.getString("telefone"));
                    p.setCidade(rs.getString("cidade"));
                    lista.add(p);
                }
            }
            return lista;
        }
    }

    //Dao pra obter
    public Pessoa obter(int id) throws Exception {
        String sqlSelect = "select ID, NOME, ENDERECO, TELEFONE, CIDADE from Pessoa where id = ?";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sqlSelect);) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery();) {
                if (rs.next()) {
                    Pessoa p = new Pessoa();
                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    p.setEndereco(rs.getString("endereco"));
                    p.setTelefone(rs.getString("telefone"));
                    p.setCidade(rs.getString("cidade"));
                    return p;
                }
            }
            throw new Exception("Id não encontrado na tabela");
        }
    }
}

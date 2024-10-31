package com.mycompany.teste.DAO;

import com.mycompany.teste.entidade.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO clientes (nome, email, telefone, data_nascimento, cpf, senha) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());
            stmt.setDate(4, new java.sql.Date(cliente.getDataNascimento().getTime()));
            stmt.setString(5, cliente.getCpf());
            stmt.setString(6, cliente.getSenha());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    cliente.setClienteId(generatedKeys.getInt(1));
                }
            }
        }
    }

    public Cliente read(int clienteId) throws SQLException {
        String sql = "SELECT * FROM clientes WHERE cliente_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, clienteId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setClienteId(rs.getInt("cliente_id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setDataNascimento(rs.getDate("data_nascimento"));
                cliente.setDataCriacao(rs.getTimestamp("data_criacao"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setSenha(rs.getString("senha"));
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> readAll() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setClienteId(rs.getInt("cliente_id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setDataNascimento(rs.getDate("data_nascimento"));
                cliente.setDataCriacao(rs.getTimestamp("data_criacao"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setSenha(rs.getString("senha"));
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    public void update(Cliente cliente) throws SQLException {
        String sql = "UPDATE clientes SET nome = ?, email = ?, telefone = ?, data_nascimento = ?, cpf = ?, senha = ? WHERE cliente_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());
            stmt.setDate(4, new java.sql.Date(cliente.getDataNascimento().getTime()));
            stmt.setString(5, cliente.getCpf());
            stmt.setString(6, cliente.getSenha());
            stmt.setInt(7, cliente.getClienteId());
            stmt.executeUpdate();
        }
    }

    public void delete(int clienteId) throws SQLException {
        String sql = "DELETE FROM clientes WHERE cliente_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, clienteId);
            stmt.executeUpdate();
        }
    }
}

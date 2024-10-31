package com.mycompany.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao{
    private String url;
    private String usuario;
    private String senha;
    private Connection conexao;

    public Conexao(String url, String usuario, String senha) {
        this.url = url;
        this.usuario = usuario;
        this.senha = senha;
    }

    // Método para conectar ao banco de dados
    public Connection conectar() {
        try {
            // Carregar o driver do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Estabelecer a conexão
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão realizada com sucesso!");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver do MySQL não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return conexao;
    }

    // Método para desconectar do banco de dados
    public void desconectar() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
                System.out.println("Conexão encerrada com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao encerrar a conexão: " + e.getMessage());
        }
    }

    // Método para obter a conexão
    public Connection getConexao() {
        return conexao;
    }
}

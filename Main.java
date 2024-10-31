package com.mycompany.teste;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3307/e_commerce";
        String usuario = "root";
        String senha = "catolica";

        Conexao conexaoMySQL = new Conexao(url, usuario, senha);
        Connection conn = conexaoMySQL.conectar();

        conexaoMySQL.desconectar();
    }
}

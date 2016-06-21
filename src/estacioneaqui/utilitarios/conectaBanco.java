/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estacioneaqui.utilitarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author a1201239
 */
public class conectaBanco {
    public Statement stm;// responsável por preparar e realizar pesquisas no banco de dados
    public ResultSet rs;// responsável por armazenar o resultado de uma pesquisa passada para o statement
    private String driver = "com.mysql.jdbc.Driver";// responsável por identificar o serviço de banco de dados
    private String caminho = "jdbc:mysql://localhost:3306/EstacioneAqui";// responsável por setar o local do banco de dados
    private String usuario = "root";
    private String senha = "";
    public Connection conn;// responsável por realizar a conexão com banco de dados
    
    public void conexao() { //método responsável por realizar a conexão com o banco
        try {// tentativa inicial
            System.setProperty("jdbc.Driver", driver);// seta a propriedade do driver de conexão
            conn = DriverManager.getConnection(caminho, usuario, senha);// realiza a conexão com o banco de dados
            JOptionPane.showMessageDialog(null, "Conectado com sucesso!");// imprime uma caixa de mensagens
        } catch (SQLException ex) {//excessão
            Logger.getLogger(conectaBanco.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro do conexão!\n Erro: " + ex.getMessage());
        }
        
    }
    
    public void desconecta(){// método para fechar conexão com o banco de dados
        
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(conectaBanco.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão!\n Erro: " + ex.getMessage());
        }
    }
}


package br.com.basedeconhecimento.jdbc;
/**
 *
 * @author Andre Said
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    static String url = "jdbc:mysql://localhost:3306/myconhecimento";
    static String banco = "myconhecimento";
    static String usuario = "root";
    static String senha = "";
    static Connection con = null;
    
    public static Connection abrirConexao(){
        
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(url, usuario, senha);
            } catch (ClassNotFoundException | SQLException ex) {
                
            }
        
        return con;
       
        }
    public static void fecharConexao(){
        if(con !=null){
            try{
                con.close();
            }catch(SQLException ex){
                System.out.println(ex);
            }
        }
    }
    }



package br.com.basedeconhecimento.dao;

import br.com.basedeconhecimento.jdbc.Conexao;
import br.com.basedeconhecimento.modelo.CadastroNovo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andre Said
 */
public class CadastramentoDao {
     //CLASSE CONEXÃO
    Connection con;
    String sql;
    PreparedStatement ps;
    ResultSet rs;
    
    //FUNÇÃO SALVAR
    public boolean salvar (CadastroNovo cadastronovo){
        con = Conexao.abrirConexao();
        sql = "insert into CadastroNovo (sistema, erro, formadeacesso) values(?,?,?,?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, cadastronovo.getErro());
            ps.setString(2, cadastronovo.getFormadeacesso());
            ps.setString(3, cadastronovo.getSistema());
            ps.execute();
            Conexao.fecharConexao();
            con.close();
            return true;
            
        }catch (SQLException ex){
            System.out.println(ex);
            return false;
        }
    }
    //FUNÇÃO PESQUISAR
    
          public List<CadastroNovo> pesquisar(){
        try {
            Connection conexao = Conexao.abrirConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from carro");
            ResultSet resultSet = ps.executeQuery();
            List<CadastroNovo> cadastros = new ArrayList<>();
            while(resultSet.next()){
                CadastroNovo cadastro = new CadastroNovo();
                cadastro.setId(resultSet.getInt("id"));
                cadastro.setSistema (resultSet.getString("Sistemas"));
                cadastro.setErro(resultSet.getString("Erro"));
                cadastro.setFormadeacesso(resultSet.getString("cor"));
            }
            return cadastros;
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastramentoDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //FUNÇÃO ALTERAR
        
          public boolean alterar(CadastroNovo cadastronovo) {
        con = Conexao.abrirConexao();
        sql = "update produto set nome = ?, quantidade = ?, preco = ?" +
                "where codigo = ?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, cadastronovo.getErro());
            ps.setString(2, cadastronovo.getFormadeacesso());
            ps.setString(1, cadastronovo.getSistema());
            ps.execute();
            Conexao.fecharConexao();
            con.close();
            return true;
            
        }catch (SQLException ex){
            System.out.println(ex);    
            return false;
            }
        }
    //FUNÇÃO EXCLUIR
          
        
          public boolean excluir(CadastroNovo cadastronovo) {
        con = Conexao.abrirConexao();
        sql = "delete from produto where id = ?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, cadastronovo.getId());
            ps.execute();
            Conexao.fecharConexao();
            con.close();
            return true;
            
        }catch (SQLException ex){
            System.out.println(ex);
            return false;
            
        }
    }
   //FUNÇÃO LIMPAR 
        
          public ArrayList<CadastroNovo> getListaSistemas(){
        ArrayList<CadastroNovo> lista = new ArrayList<CadastroNovo>();
        
        con = Conexao.abrirConexao();
        sql = "select * from produto ";
        
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            CadastroNovo CadastroNovo = null;
            while(rs.next()){
                CadastroNovo = new CadastroNovo();
                CadastroNovo.setSistema(rs.getString("Sistema"));
                CadastroNovo.setFormadeacesso(rs.getString("Forma de acesso"));
                CadastroNovo.setErro(rs.getString("Erro"));
                lista.add(CadastroNovo);
            }
            Conexao.fecharConexao();
            con.close();
            
        }catch (SQLException ex){
            System.out.println(ex);    
        }
        return lista;
    }
    
}

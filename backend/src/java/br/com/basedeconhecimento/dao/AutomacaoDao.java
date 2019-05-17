
package br.com.basedeconhecimento.dao;
import br.com.basedeconhecimento.jdbc.Conexao;
import br.com.basedeconhecimento.modelo.Automacao;
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
 * @author André Said
 */
public class AutomacaoDao {
      //CLASSE CONEXÃO
    Connection con;
    String sql;
    PreparedStatement ps;
    ResultSet rs;
    
    //FUNÇÃO SALVAR
    public boolean salvar (Automacao cadastronovo){
        con = Conexao.abrirConexao();
        sql = "insert into Automacao (sistema, formadeacesso, erro) values(?,?,?)";
        
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
    
          public List<Automacao> pesquisar(){
        try {
            Connection conexao = Conexao.abrirConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from id");
            ResultSet resultSet = ps.executeQuery();
            List<Automacao> cadastros = new ArrayList<>();
            while(resultSet.next()){
                Automacao cadastro = new Automacao();
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
        
          public boolean alterar(Automacao cadastronovo) {
        con = Conexao.abrirConexao();
        sql = "update Automacao set sistema = ?, formadeacesso = ?, erro = ?" +
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
                 
          public boolean excluir(Automacao cadastronovo) {
        con = Conexao.abrirConexao();
        sql = "delete from Automacao where id = ?";
        
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
        
          public ArrayList<Automacao> getListaSistemas(){
        ArrayList<Automacao> lista = new ArrayList<Automacao>();
        
        con = Conexao.abrirConexao();
        sql = "select * from Automacao ";
        
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            Automacao CadastroNovo = null;
            while(rs.next()){
                CadastroNovo = new Automacao();
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

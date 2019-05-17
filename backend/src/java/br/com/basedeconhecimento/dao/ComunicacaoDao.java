
package br.com.basedeconhecimento.dao;
import br.com.basedeconhecimento.jdbc.Conexao;
import br.com.basedeconhecimento.modelo.ComunicacaoEletronica;
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
public class ComunicacaoDao {
     //CLASSE CONEXÃO
    Connection con;
    String sql;
    PreparedStatement ps;
    ResultSet rs;
    
    //FUNÇÃO SALVAR
    public boolean salvar (ComunicacaoEletronica cadastronovo){
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
    
          public List<ComunicacaoEletronica> pesquisar(){
        try {
            Connection conexao = Conexao.abrirConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from carro");
            ResultSet resultSet = ps.executeQuery();
            List<ComunicacaoEletronica> cadastros = new ArrayList<>();
            while(resultSet.next()){
                ComunicacaoEletronica cadastro = new ComunicacaoEletronica();
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
        
          public boolean alterar(ComunicacaoEletronica cadastronovo) {
        con = Conexao.abrirConexao();
        sql = "update ComunicacaoEletronica set sistema = ?, formadeacesso = ?, erro = ?" +
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
                 
          public boolean excluir(ComunicacaoEletronica cadastronovo) {
        con = Conexao.abrirConexao();
        sql = "delete from ComunicacaoEletronica where id = ?";
        
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
        
          public ArrayList<ComunicacaoEletronica> getListaSistemas(){
        ArrayList<ComunicacaoEletronica> lista = new ArrayList<ComunicacaoEletronica>();
        
        con = Conexao.abrirConexao();
        sql = "select * from ComunicacaoEletronica ";
        
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ComunicacaoEletronica ComunicacaoEletronica = null;
            while(rs.next()){
                ComunicacaoEletronica = new ComunicacaoEletronica();
                ComunicacaoEletronica.setSistema(rs.getString("Sistema"));
                ComunicacaoEletronica.setFormadeacesso(rs.getString("Forma de acesso"));
                ComunicacaoEletronica.setErro(rs.getString("Erro"));
                lista.add(ComunicacaoEletronica);
            }
            Conexao.fecharConexao();
            con.close();
            
        }catch (SQLException ex){
            System.out.println(ex);    
        }
        return lista;
    }
}

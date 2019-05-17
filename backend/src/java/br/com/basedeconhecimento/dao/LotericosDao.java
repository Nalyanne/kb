
package br.com.basedeconhecimento.dao;
import br.com.basedeconhecimento.jdbc.Conexao;
import br.com.basedeconhecimento.modelo.Lotericos;
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
public class LotericosDao {
     //CLASSE CONEXÃO
    Connection con;
    String sql;
    PreparedStatement ps;
    ResultSet rs;
    
    //FUNÇÃO SALVAR
    public boolean salvar (Lotericos cadastronovo){
        con = Conexao.abrirConexao();
        sql = "insert into Lotericos (sistema, formadeacesso, erro) values(?,?,?)";
        
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
    
          public List<Lotericos> pesquisar(){
        try {
            Connection conexao = Conexao.abrirConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from id");
            ResultSet resultSet = ps.executeQuery();
            List<Lotericos> cadastros = new ArrayList<>();
            while(resultSet.next()){
                Lotericos cadastro = new Lotericos();
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
        
          public boolean alterar(Lotericos cadastronovo) {
        con = Conexao.abrirConexao();
        sql = "update Lotericos set sistema = ?, formadeacesso = ?, erro = ?" +
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
                 
          public boolean excluir(Lotericos cadastronovo) {
        con = Conexao.abrirConexao();
        sql = "delete from Lotericos where id = ?";
        
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
        
          public ArrayList<Lotericos> getListaSistemas(){
        ArrayList<Lotericos> lista = new ArrayList<Lotericos>();
        
        con = Conexao.abrirConexao();
        sql = "select * from Lotericos ";
        
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            Lotericos Lotericos = null;
            while(rs.next()){
                Lotericos = new Lotericos();
                Lotericos.setSistema(rs.getString("Sistema"));
                Lotericos.setFormadeacesso(rs.getString("Forma de acesso"));
                Lotericos.setErro(rs.getString("Erro"));
                lista.add(Lotericos);
            }
            Conexao.fecharConexao();
            con.close();
            
        }catch (SQLException ex){
            System.out.println(ex);    
        }
        return lista;
    }
}

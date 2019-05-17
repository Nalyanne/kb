
package br.com.basedeconhecimento.controleBean;

import br.com.basedeconhecimento.dao.CadastramentoDao;
import br.com.basedeconhecimento.modelo.CadastroNovo;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author Andre Said
 */
@ManagedBean (name="mb")
@SessionScoped
public class basedeconhecimentoBean {
    
    private CadastroNovo cadastronovo = new CadastroNovo();
    private List<CadastroNovo> cadastros = new ArrayList<>();
    private CadastramentoDao conhecimentoDAO = new CadastramentoDao();
        
        public void salvar(){
          conhecimentoDAO.salvar(cadastronovo);
          cadastronovo = new CadastroNovo();
        }
        public void pesquisar(){
            conhecimentoDAO.pesquisar();
        }
        public void alterar(CadastroNovo c){
            cadastronovo = c;
        }
        public void excluir(){
            conhecimentoDAO.excluir(cadastronovo);
            
        }
        public void limparTela(){
            cadastronovo = new CadastroNovo();
        }

        public CadastroNovo getCadastronovo() {
            return cadastronovo;
        }

        public void setCadastronovo(CadastroNovo cadastronovo) {
            this.cadastronovo = cadastronovo;
        }

        public List<CadastroNovo> getCadastros() {
            return cadastros;
        }

        public void setCadastros(List<CadastroNovo> cadastros) {
            this.cadastros = cadastros;
        }

        public CadastramentoDao getConhecimentoDAO() {
            return conhecimentoDAO;
        }

        public void setConhecimentoDAO(CadastramentoDao conhecimentoDAO) {
            this.conhecimentoDAO = conhecimentoDAO;
        }
        
    
    
    }

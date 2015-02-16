package br.com.tairoroberto.navegacaoimplicita;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.tairoroberto.domain.Produto;



@ManagedBean
//@ApplicationScoped //todo mundo  que acessa ra pagina poderá ver os dados
@SessionScoped  //apenas o proprio usuaro exergar seus dados
//@ViewScoped  //apenas o proprio usuaro exergar seus dados, porém so enquanto a tela esta aberta
//@RequestScoped //os dados não são a guardados, a cada nova requisição os dados são deletados
//@NoneScoped //Escopo sem tempo de vida, é chamado a cada nomponente da aplicação .obs: menos usado.
public class GestaoProdutosBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2411889286587271915L;
	private List<Produto> produtos;
	private Produto produto;
	
	//construct
	public GestaoProdutosBean() {
		this.produtos = new ArrayList<Produto>();
		this.produto = new  Produto();
	}
	
	//method to redirect link
	public String  obterAjuda() {
		if (produtos.isEmpty()) {
			return "AjudaGestaoProdutos?faces-redirect=true";
		}else{
			return "AjudaGestaoProdutosTelefone?faces-redirect=true";
		}
		
	}
	
	/**
	 * @PostConstruct
	 * é utilizado para iniciar algum recurso que o managedBean necessita
	 */
	@PostConstruct
	public void inicializar() {
		System.out.println("Inicializou Bean");
	}
	
	
	/**
	 * @PreDestroy
	 * é utilizado para finalizar algum recurso que o managedBean necessita
	 */
	@PreDestroy
	public void finalizar() {
		System.out.println("Finalizou Bean");
	}
	
	public void incluir() {
		this.produtos.add(this.produto);
		this.produto = new Produto();
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	
}

package model;

public class Client {

	private int id;
	private String nome;
	private String sobrenome;
	private String nome_da_mae;
	private String nome_do_pai;
	private String CPF;
	private String data_nascimento;
	private String endereco;
	private String CEP;
	
	public Client() {
	}
	public Client(String nome, String sobrenome, String nome_da_mae, String nome_do_pai, String CPF, String data_nascimento, String endereco, String CEP) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nome_da_mae = nome_da_mae;
		this.nome_do_pai = nome_do_pai;
		this.CPF = CPF;
		this.data_nascimento = data_nascimento;
		this.endereco = endereco;
		this.CEP = CEP;
	}
	
	public Client(String nome, String sobrenome, String nome_da_mae, String CPF, String data_nascimento, String endereco, String CEP) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nome_da_mae = nome_da_mae;
		this.CPF = CPF;
		this.data_nascimento = data_nascimento;
		this.endereco = endereco;
		this.CEP = CEP;
	}
	
	public Client(int id, String nome, String sobrenome, String nome_da_mae, String nome_do_pai, String CPF, String data_nascimento, String endereco, String CEP) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nome_da_mae = nome_da_mae;
		this.nome_do_pai = nome_do_pai;
		this.CPF = CPF;
		this.data_nascimento = data_nascimento;
		this.endereco = endereco;
		this.CEP = CEP;
	}
	
	public Client(int id, String nome, String sobrenome, String nome_da_mae, String CPF, String data_nascimento, String endereco, String CEP) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nome_da_mae = nome_da_mae;
		this.CPF = CPF;
		this.data_nascimento = data_nascimento;
		this.endereco = endereco;
		this.CEP = CEP;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getNome_da_mae() {
		return nome_da_mae;
	}
	public void setNome_da_mae(String nome_da_mae) {
		this.nome_da_mae = nome_da_mae;
	}
	public String getNome_do_pai() {
		return nome_do_pai;
	}
	public void setNome_do_pai(String nome_do_pai) {
		this.nome_do_pai = nome_do_pai;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	
	
}

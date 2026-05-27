package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.ClientController;

public class TelaClient extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JLabel lblId;
	private JLabel lblNome;
	private JLabel lblSobrenome;
	private JLabel lblNomeDaMae;
	private JLabel lblNomeDoPai;
	private JLabel lblCPF;
	private JLabel lbldtNascimento;
	private JLabel lblEndereco;
	private JLabel lblCEP;
	

	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtNomeDaMae;
	private JTextField txtNomeDoPai;
	private JTextField txtCPF;
	private JTextField txtdtNascimento;
	private JTextField txtEndereco;
	private JTextField txtCEP;
	
	
	private JButton btnNovo;
    private JButton btnSalvar;
    private JButton btnExcluir;
    private JButton btnLimpar;
    
	private JTable tabelaClientes;
	private DefaultTableModel modeloTabela;
	
	private ClientController controller;
	
	public TelaClient() {
		setTitle("Cad_Clie");
		setSize(700,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		criarComponentes();
		
		controller = new ClientController(this);
		configurarEventos();
		controller.carregarTabela();
		
	}
	
	private void criarComponentes() {
		JPanel painelFormulario = new JPanel(new GridLayout(3,2,10,10));
		painelFormulario.setBorder(BorderFactory.createTitledBorder("Dados do Cliente"));
		
		lblId = new JLabel ("ID: ");
		txtId= new JTextField();
		txtId.setEditable(false);
		
		lblNome = new JLabel("Nome: ");
		txtNome= new JTextField();
		
		lblSobrenome = new JLabel("Sobrenome:");
		txtSobrenome  = new JTextField();
		
		lblNomeDaMae = new JLabel("Nome da Mãe: ");
		txtNomeDaMae = new JTextField();
		
		lblNomeDoPai = new JLabel("Nome do Pai: ");
		txtNomeDoPai = new JTextField();
		
		lblCPF = new JLabel("CPF: ");
		txtCPF = new JTextField();
		
		lbldtNascimento = new JLabel("Data de Nascimento: ");
		txtdtNascimento = new JTextField();
		
		lblEndereco = new JLabel("Endereço: ");
		txtEndereco = new JTextField();
		
		lblCEP = new JLabel("CEP: ");
		txtCEP = new JTextField();
		
		painelFormulario.add(lblId);
		painelFormulario.add(txtId);
		painelFormulario.add(lblNome);
		painelFormulario.add(txtNome);
		painelFormulario.add(lblSobrenome);
		painelFormulario.add(txtSobrenome);
		painelFormulario.add(lblNomeDaMae);
		painelFormulario.add(txtNomeDaMae);
		painelFormulario.add(lblNomeDoPai);
		painelFormulario.add(txtNomeDoPai);
		painelFormulario.add(lblCPF);
		painelFormulario.add(txtCPF);
		painelFormulario.add(lbldtNascimento);
		painelFormulario.add(txtdtNascimento);
		painelFormulario.add(lblEndereco);
		painelFormulario.add(txtEndereco);
		painelFormulario.add(lblCEP);
		painelFormulario.add(txtCEP);
		
		add(painelFormulario, BorderLayout.NORTH);
		
		modeloTabela = new DefaultTableModel(new Object[] {"ID","Nome","Sobrenome","Nome da mãe","Nome do Pai","CPF","Data de Nascimento","Endereço", "CEP"},0) 
		{ private static final long serialVersionUID = 1L;
		
		 public boolean isCellEditable(int row, int column) {
			 return false;
		 }
	};
	
	tabelaClientes = new JTable(modeloTabela);
	JScrollPane scrollPane =  new JScrollPane(tabelaClientes);
	scrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Clientes"));
	add(scrollPane, BorderLayout.CENTER);
	
	JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15,10));
	
	btnNovo = new JButton("Novo");
    btnSalvar = new JButton("Salvar");
    btnExcluir = new JButton("Excluir");
    btnLimpar = new JButton("Limpar");
	
	painelBotoes.add(btnNovo);
	painelBotoes.add(btnSalvar);
	painelBotoes.add(btnExcluir);
	painelBotoes.add(btnLimpar);
	
	add(painelBotoes, BorderLayout.SOUTH);
	
 }

	
	private void configurarEventos() {
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                controller.limpar();
            }
        });

        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                controller.salvar();
            }
        });

        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                controller.excluir();
            }
        });

        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                controller.limpar();
            }
        });

        tabelaClientes.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                controller.preencherFormulario();
            }
        });
    }

	
	public JLabel getLblId() {
		return lblId;
	}

	public void setLblId(JLabel lblId) {
		this.lblId = lblId;
	}

	public JLabel getLblNome() {
		return lblNome;
	}

	public void setLblNome(JLabel lblNome) {
		this.lblNome = lblNome;
	}

	public JLabel getLblSobrenome() {
		return lblSobrenome;
	}

	public void setLblSobrenome(JLabel lblSobrenome) {
		this.lblSobrenome = lblSobrenome;
	}

	public JLabel getLblNomeDaMae() {
		return lblNomeDaMae;
	}

	public void setLblNomeDaMae(JLabel lblNomeDaMae) {
		this.lblNomeDaMae = lblNomeDaMae;
	}

	public JLabel getLblNomeDoPai() {
		return lblNomeDoPai;
	}

	public void setLblNomeDoPai(JLabel lblNomeDoPai) {
		this.lblNomeDoPai = lblNomeDoPai;
	}

	public JLabel getLblCPF() {
		return lblCPF;
	}

	public void setLblCPF(JLabel lblCPF) {
		this.lblCPF = lblCPF;
	}

	public JLabel getLbldtNascimento() {
		return lbldtNascimento;
	}

	public void setLbldtNascimento(JLabel lbldtNascimento) {
		this.lbldtNascimento = lbldtNascimento;
	}

	public JLabel getLblEndereco() {
		return lblEndereco;
	}

	public void setLblEndereco(JLabel lblEndereco) {
		this.lblEndereco = lblEndereco;
	}

	public JLabel getLblCEP() {
		return lblCEP;
	}

	public void setLblCEP(JLabel lblCEP) {
		this.lblCEP = lblCEP;
	}

	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public JTextField getTxtSobrenome() {
		return txtSobrenome;
	}

	public void setTxtSobrenome(JTextField txtSobrenome) {
		this.txtSobrenome = txtSobrenome;
	}

	public JTextField getTxtNomeDaMae() {
		return txtNomeDaMae;
	}

	public void setTxtNomeDaMae(JTextField txtNomeDaMae) {
		this.txtNomeDaMae = txtNomeDaMae;
	}

	public JTextField getTxtNomeDoPai() {
		return txtNomeDoPai;
	}

	public void setTxtNomeDoPai(JTextField txtNomeDoPai) {
		this.txtNomeDoPai = txtNomeDoPai;
	}

	public JTextField getTxtCPF() {
		return txtCPF;
	}

	public void setTxtCPF(JTextField txtCPF) {
		this.txtCPF = txtCPF;
	}

	public JTextField getTxtdtNascimento() {
		return txtdtNascimento;
	}

	public void setTxtdtNascimento(JTextField txtdtNascimento) {
		this.txtdtNascimento = txtdtNascimento;
	}

	public JTextField getTxtEndereco() {
		return txtEndereco;
	}

	public void setTxtEndereco(JTextField txtEndereco) {
		this.txtEndereco = txtEndereco;
	}

	public JTextField getTxtCEP() {
		return txtCEP;
	}

	public void setTxtCEP(JTextField txtCEP) {
		this.txtCEP = txtCEP;
	}

	public JTable getTabelaClientes() {
		return tabelaClientes;
	}

	public void setTabelaClientes(JTable tabelaClientes) {
		this.tabelaClientes = tabelaClientes;
	}

	public DefaultTableModel getModeloTabela() {
		return modeloTabela;
	}

	public void setModeloTabela(DefaultTableModel modeloTabela) {
		this.modeloTabela = modeloTabela;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JButton getBtnNovo() {
		return btnNovo;
	}

	public void setBtnNovo(JButton btnNovo) {
		this.btnNovo = btnNovo;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public void setBtnSalvar(JButton btnSalvar) {
		this.btnSalvar = btnSalvar;
	}

	public JButton getBtnExcluir() {
		return btnExcluir;
	}

	public void setBtnExcluir(JButton btnExcluir) {
		this.btnExcluir = btnExcluir;
	}

	public JButton getBtnLimpar() {
		return btnLimpar;
	}

	public void setBtnLimpar(JButton btnLimpar) {
		this.btnLimpar = btnLimpar;
	}
	
	
	
}	

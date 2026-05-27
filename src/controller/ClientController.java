package controller;

import java.util.List; 

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.ClientDAO;
import model.Client;
import view.TelaClient;

public class ClientController {
	
	private TelaClient tela;
	private ClientDAO clientDAO;
	
	public ClientController(TelaClient tela) {
		this.tela = tela;
		this.clientDAO = new ClientDAO();
	}
	
	public void salvar() {
		String nome = tela.getTxtNome().getText().trim();
		String sobrenome = tela.getTxtSobrenome().getText().trim();
		String nmMae = tela.getTxtNomeDaMae().getText().trim();
		String nmPai = tela.getTxtNomeDoPai().getText().trim();
		String cpf = tela.getTxtCPF().getText().trim();
		String dtNascimento = tela.getTxtdtNascimento().getText().trim();
		String endereco = tela.getTxtEndereco().getText().trim();
		String cep = tela.getTxtCEP().getText().trim();
		
		if (nome.isEmpty() || sobrenome.isEmpty() || nmMae.isEmpty() || cpf.isEmpty() || 
			dtNascimento.isEmpty() || endereco.isEmpty() || cep.isEmpty()) {
            JOptionPane.showMessageDialog(
                    tela,
                    "Preencha os campos.",
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE
             );
             return;
		}
		
		try {
			String idTexto = tela.getTxtId().getText().trim();
			
			if (idTexto.isEmpty()) {
				Client client = new Client(nome, sobrenome, nmMae, nmPai, cpf, dtNascimento, endereco, cep);
				clientDAO.salvar(client);
				JOptionPane.showMessageDialog(tela, "Cliente salvo com sucesso.");
			} else {
				Client client = new Client(Integer.parseInt(idTexto), nome, sobrenome, nmMae, nmPai, cpf, dtNascimento, endereco, cep);
				clientDAO.salvar(client);
				JOptionPane.showMessageDialog(tela, "Cliente atualizado com sucesso.");
			}
			
			limpar();
            carregarTabela();
			
		} catch (Exception e) {
            JOptionPane.showMessageDialog(
                    tela,
                    "Erro ao salvar: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
                );
            }
	}
	
	public void excluir() {
		int linha = tela.getTabelaClientes().getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(
                tela,
                "Selecione um cliente na tabela para excluir.",
                "Atenção",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        int confirmacao = JOptionPane.showConfirmDialog(
            tela,
            "Deseja realmente excluir o cliente selecionado?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION
        );

        if (confirmacao != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            int id = Integer.parseInt(tela.getTxtId().getText());
            clientDAO.excluir(id);
            JOptionPane.showMessageDialog(tela, "Cliente excluído com sucesso.");
            limpar();
            carregarTabela();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                tela,
                "Erro ao excluir: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
	}
	
	public void limpar() {
		tela.getTxtId().setText("");
        tela.getTxtNome().setText("");
        tela.getTxtSobrenome().setText("");
        tela.getTxtNomeDaMae().setText("");
        tela.getTxtNomeDoPai().setText("");
        tela.getTxtCPF().setText("");
        tela.getTxtdtNascimento().setText("");
        tela.getTxtEndereco().setText("");
        tela.getTxtCEP().setText("");
        tela.getTxtNome().requestFocus();
        tela.getTabelaClientes().clearSelection();
	}
	
	public void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tela.getTabelaClientes().getModel();
        modelo.setRowCount(0);

        try {
            List<Client> clientes = clientDAO.listar();

            int i;
            for (i = 0; i < clientes.size(); i++) {
                Client c = clientes.get(i);
                modelo.addRow(new Object[] {
                    c.getId(),
                    c.getNome(),
                    c.getSobrenome(),
                    c.getNome_da_mae(),
                    c.getNome_do_pai(),
                    c.getCPF(),
                    c.getData_nascimento(),
                    c.getEndereco(),
                    c.getCEP()
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                tela,
                "Erro ao carregar tabela: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
	
	public void preencherFormulario() {
        int linha = tela.getTabelaClientes().getSelectedRow();

        if (linha != -1) {
            tela.getTxtId().setText(tela.getTabelaClientes().getValueAt(linha, 0).toString());
            tela.getTxtNome().setText(tela.getTabelaClientes().getValueAt(linha, 1).toString());
            tela.getTxtSobrenome().setText(tela.getTabelaClientes().getValueAt(linha, 3).toString());
            tela.getTxtNomeDaMae().setText(tela.getTabelaClientes().getValueAt(linha, 4).toString());
            tela.getTxtNomeDoPai().setText(tela.getTabelaClientes().getValueAt(linha, 5).toString());
            tela.getTxtCPF().setText(tela.getTabelaClientes().getValueAt(linha, 6).toString());
            tela.getTxtdtNascimento().setText(tela.getTabelaClientes().getValueAt(linha, 7).toString());
            tela.getTxtEndereco().setText(tela.getTabelaClientes().getValueAt(linha, 8).toString());
            tela.getTxtCEP().setText(tela.getTabelaClientes().getValueAt(linha, 9).toString());
        }
    }
}

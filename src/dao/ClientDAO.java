package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import model.Client;
import util.Conexao;

public class ClientDAO {
	
	public void salvar(Client client) {
		Connection conn = null;
		java.sql.PreparedStatement stmt = null;
		
		String sql = "INSERT INTO cad_cli (nome, sobrenome, nome_da_mae, nome_do_pai, CPF, data_nascimento, endereco, CEP) VALUES (?,?,?,?,?,?,?,?)";
		
		try {
			conn = Conexao.conectar();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, client.getNome());
			stmt.setString(2, client.getSobrenome());
			stmt.setString(3, client.getNome_da_mae());
			if (client.getNome_do_pai() != null) {
				stmt.setString(4, client.getNome_do_pai());
			} else {
				stmt.setNull(4, java.sql.Types.VARCHAR);
			}
			stmt.setString(5, client.getCPF());
			stmt.setString(6, client.getData_nascimento());
			stmt.setString(7, client.getEndereco());
			stmt.setString(8, client.getCEP());
			stmt.executeUpdate();						
		} catch (Exception e) {
			throw new RuntimeException("Erro ao salvar cliente: " + e.getMessage());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void atualizar(Client client) {
		Connection conn = null;
		java.sql.PreparedStatement stmt = null;
		
		String sql = "UPDATE cad_cli SET nome = ?, sobrenome = ?, nome_da_mae = ?, nome_do_pai = ?, CPF = ?, data_nascimento = ?, endereco = ?, CEP = ? WHERE id = ?";
		
		try {
			conn = Conexao.conectar();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, client.getNome());
			stmt.setString(2, client.getSobrenome());
			stmt.setString(3, client.getNome_da_mae());
			if (client.getNome_do_pai() != null) {
				stmt.setString(4, client.getNome_do_pai());
			} else {
				stmt.setNull(4, java.sql.Types.VARCHAR);
			}
			stmt.setString(5, client.getCPF());
			stmt.setString(6, client.getData_nascimento());
			stmt.setString(7, client.getEndereco());
			stmt.setString(8, client.getCEP());
			stmt.setInt(9, client.getId());
			stmt.executeUpdate();
			} catch (Exception e) {
	            throw new RuntimeException("Erro ao atualizar client: " + e.getMessage());
	        } finally {
	            try {
	                if (stmt != null) {
	                    stmt.close();
	                }
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
		
	}
	
	public void excluir (int id) {
		Connection conn = null;
		java.sql.PreparedStatement stmt = null;
		
		String sql = "DELETE FROM cad_cli WHERE id = ?";
		
		try {
			conn = Conexao.conectar();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao excluir client: " + e.getMessage());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Client> listar() {
		List<Client> lista = new ArrayList<Client>();
		
		Connection conn = null;
		java.sql.PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM cad_cli";
		
		try {
			conn = Conexao.conectar();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Client client = new Client();
				client.setId(rs.getInt("id"));
				client.setNome(rs.getString("nome"));
				client.setSobrenome(rs.getString("sobrenome"));
				client.setNome_da_mae(rs.getString("nome_da_mae"));
				client.setNome_do_pai(rs.getString("nome_do_pai"));
				client.setCPF(rs.getString("CPF"));
				client.setData_nascimento(rs.getString("data_nascimento"));
				client.setEndereco(rs.getString("endereco"));
				client.setCEP(rs.getString("CEP"));
				lista.add(client);
			}
			} catch (Exception e) {
				throw new RuntimeException("Erro ao listar os itens: " + e.getMessage());
			} finally {
				try {
					if (rs != null) {
						rs.close();
					}
					if (stmt != null) {
						stmt.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		return lista;
	}
}

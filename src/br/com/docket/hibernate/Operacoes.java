package br.com.docket.hibernate;

import java.util.List;
import javax.swing.JOptionPane;
import br.com.docket.modelo.Cartorio;

public class Operacoes {
	static CartorioHibernate cartHib = CartorioHibernate.getInstance();

	public void criarCartorio(Cartorio cartorio) {
		cartHib.criarCartorio(cartorio);
		JOptionPane.showMessageDialog(null, "Cart�rio criado com sucesso!");
	}
	
	public void editarCartorio(Cartorio cartorio) {
    boolean atualizar = false;    
		if (cartorio != null && (cartorio.getId() != 0)) {
			Cartorio cart = cartHib.visualizarCartorio(cartorio.getId());			
			if (cart != null) {				
				if (cart.getNome() != null) {
					if (cartorio.getNome() != null && !cartorio.getNome().equals(cart.getNome())) {
						cart.setNome(cartorio.getNome());
						atualizar = true;
					}
				}

				if(atualizar) {
					cartHib.editarCartorio(cart);
				  JOptionPane.showMessageDialog(null, "Registro do cart�rio " + cartorio.getId() + " editado com sucesso!");
				}		
				else JOptionPane.showMessageDialog(null, "N�o h� dados novos para editar o registro do cart�rio " + cartorio.getId() + ".");
				
			}			
			else {
				JOptionPane.showMessageDialog(null, "O registro de destino n�o existe.");
				return;
			}			
		}
		else {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel localizar o registro de destino para edit�-lo.");
			return;
		}
	}
	
	public Cartorio visualizarCartorio(int id) {
		return cartHib.visualizarCartorio(id);
	}
	
	public void excluirCartorioPorID(int id) {
		  if(id!=0) {
		  	cartHib.excluirCartorioPorID(id);
		  	JOptionPane.showMessageDialog(null, "Cart�rio " + id + " exclu�do com sucesso.");
		  }
		  else JOptionPane.showMessageDialog(null, "Registro de cart�rio n�o encontrado.");
		}
	
	public List<Cartorio> listarCartorios() {
		List<Cartorio> cartorios = cartHib.listarCartorios();
		if(cartorios != null && cartorios.size() > 0) return cartorios;
		else {
			JOptionPane.showMessageDialog(null, "Nenhum registro de cart�rios foi encontrado.");
			return null;
		}		
	}
	
}
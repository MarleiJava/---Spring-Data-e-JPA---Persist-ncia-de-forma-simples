package projeto.spring.data.aula;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.aula.dao.InterfaceSpringDataUser;
import projeto.spring.data.aula.dao.InterfaceTelefone;
import projeto.spring.data.aula.model.Telefone;
import projeto.spring.data.aula.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTest {
	
	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;
	
	@Autowired
	private InterfaceTelefone interfaceTelefone;
	
	@Test
	public void tetInsert() {
		System.out.println("Iniciou spring com sucesso");
	}
	
	
	public void testInsert() {
		

		UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
		usuarioSpringData.setEmail("doguinho@outlook.com");
		usuarioSpringData.setIdade(10);
		usuarioSpringData.setLogin("Dog");
		usuarioSpringData.setNome("Marlei");
		usuarioSpringData.setSenha("123");
		interfaceSpringDataUser.save(usuarioSpringData);
	
	}
	
	@Test
	public void testConsulta() {
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(1L);
		
		if(usuarioSpringData == null) {
			System.out.println("Não tem nada cadastrado");
		}else {
		
		System.out.println(usuarioSpringData.get().getNome());
		System.out.println(usuarioSpringData.get().getIdade());
		System.out.println(usuarioSpringData.get().getEmail());
		System.out.println(usuarioSpringData.get().getLogin());
		
		for(Telefone telefone : usuarioSpringData.get().getTelefones()) {
			System.out.println(telefone.getNumero());
			System.out.println(telefone.getTipo());
		}
		}
	}
	
	
	public void testeConsultaTodos() {
		Iterable<UsuarioSpringData> lista = interfaceSpringDataUser.findAll();
		
	for(UsuarioSpringData usuarioSpringData : lista) {
		System.out.println(usuarioSpringData.getNome());
		System.out.println(usuarioSpringData.getIdade());
		System.out.println(usuarioSpringData.getEmail());
		System.out.println(usuarioSpringData.getLogin());
		System.out.println("-----------------------------------------");
		
	}
	
	}
	
	
	public void testeUpdate(){
		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(1L);
		
		UsuarioSpringData data = usuarioSpringData.get();
		
		data.setNome("Nome atualizado");
		interfaceSpringDataUser.save(data);
		
		
	}
	
	
	public void testeDelete() {
		interfaceSpringDataUser.deleteById(6L);
	}
		

	public void testeConsultaNome() {
		System.out.println("Consultando");
		List<UsuarioSpringData> list= interfaceSpringDataUser.buscaPorNome("Hot dog ");
		
		for(UsuarioSpringData usuarioSpringData : list) {
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println("-----------------------------------------");
			
		}
	}
	
	

	public void testeConsultaNomeParam() {


		UsuarioSpringData usuarioSpringData
		= interfaceSpringDataUser.buscaPorNomeParam("Marlei");
  

		System.out.println(usuarioSpringData.getEmail());
		System.out.println(usuarioSpringData.getIdade());
		System.out.println(usuarioSpringData.getLogin());
		System.out.println(usuarioSpringData.getNome());
		System.out.println(usuarioSpringData.getSenha());
		System.out.println(usuarioSpringData.getId());
		System.out.println("---------------------------------------------------");
	}

	
	public void testeDeletrePorNome() {
		
		interfaceSpringDataUser.deletePorNome("Marlei ");
		
	}
	
	 
	public void updateEmailPorNome() {
		interfaceSpringDataUser.updateEmailPorNome("marlinho@hotmailk", "Nome atualizado");
	}
	
	
	public void testInsertTelefone() {
		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(1L);
		
		Telefone telefone = new Telefone();
		telefone.setNumero("99999999999999");
		telefone.setTipo("celular");
		telefone.setUsuarioSpringData(usuarioSpringData.get());
		
		interfaceTelefone.save(telefone);
		
	}
	
	

}

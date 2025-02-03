package projeto.spring.data.aula;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.aula.dao.InterfaceSpringDataUser;
import projeto.spring.data.aula.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTest {
	
	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;
	
	@Test
	public void tetInsert() {
		System.out.println("Iniciou spring com sucesso");
	}
	
	
	public void testInsert() {
		

		UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
		usuarioSpringData.setEmail("doguinho@outlook.com");
		usuarioSpringData.setIdade(10);
		usuarioSpringData.setLogin("Dog");
		usuarioSpringData.setNome("Hot dog ");
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
		}
	}
	

}

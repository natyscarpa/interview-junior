package br.com.brainweb.interview.core;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.brainweb.interview.core.features.hero.HeroFinder;
import br.com.brainweb.interview.model.Hero;
import br.com.brainweb.interview.model.HeroComparator;
import br.com.brainweb.interview.model.request.CreateHeroRequest;

@SpringBootApplication
@EnableTransactionManagement
public class Application {

	private HeroFinder heroFinder;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner print() {
		return args -> {
			System.out.println("Olá! :)");

			Hero mulherMaravilha = new Hero(new CreateHeroRequest(), UUID.randomUUID());
			Hero viuvaNegra = new Hero(new CreateHeroRequest(), UUID.randomUUID());
			Hero mistica = new Hero(new CreateHeroRequest(), UUID.randomUUID());

			//Busca Herois por Id 
			searchHeroById(UUID.fromString("123"));

			//Buscar Herois por Nome 
			searchHeroByName("mistica");
		};
	}

	/***
	 *  Criar endpoint de busca de heróis por ID. Caso não encontre o herói o sistema deve retornar um erro 404 (Not Found);
	 *  
	 * @param id
	 * @throws Exception 
	 */
	private void searchHeroById(UUID id) throws Exception {
		System.out.println("Busca o herói pelo ID: " + id);

		Optional<Hero> hero = heroFinder.findById(id);

		if (hero == null) {
			System.out.println(return404code());
		} else {
			System.out.println("Heroi encontrado: ");
			System.out.println(hero);
		}
		
	}

	/***
	 *  Criar endpoint de busca de heróis por filtro, nesse caso o filtro será apenas o nome. 
     *  Caso não encontre nenhum herói o sistema deve retornar um sucesso 200 com o body vazio;
     *
	 * @param name
	 * @throws Exception 
	 */
	private void searchHeroByName(String name) throws Exception {
		System.out.println("Busca o herói pelo nome: " + name);

		List<Hero> heroList = heroFinder.findHeroByName(name);

		if (heroList.isEmpty()) {
			System.out.println(return200code());
		} else {
			System.out.println("Herois encontrados: ");
			heroList.forEach(hero -> System.out.println(hero));
		}
	}

	 @PostMapping(value = "/v1/notification")
	 public ResponseEntity<String> return200code() throws Exception {
		 return ResponseEntity.status(HttpStatus.OK)
		            .body(" ");
	 }
	 
	 @PostMapping(value = "/v1/notification")
	 public ResponseEntity<String> return404code() throws Exception {
		 return ResponseEntity.status(HttpStatus.NOT_FOUND)
		            .body("Heroi não encontrado");
	 }
	 
	 
	 /***
	  * Criar endpoint de atualização de heróis, todos os campos poderão ser atualizados. 
	  * Caso não encontre o herói o sistema deve retornar um erro 404 (Not Found)
	  */
	 private void updateHero(Hero hero) {
		 //Receber o heroi
		 //Buscar no banco
		 	//Caso encontre mais de um, dar a opção para o usuário escolher qual sera alterado depois atualizar
		 	//Caso encontre apenas um, atualizar e retornar uma mensagem de sucesso
		 	//Caso o heroi não seja encontrado, retonar o erro 404
	 }
	 
	 /**
	  * Criar endpoint de exclusão de heróis. A exclusão será física, ok? (Física?! 
 		 É, deleta o registro da base). Caso não encontre o herói o sistema deve retornar um erro 404 (Not Found).
	  */
	 private void removeHero(Hero hero) {
		//Receber o heroi
		 //Buscar no banco
		 	//Caso encontre mais de um, dar a opção para o usuário escolher qual sera removido, e realizar a remoção
		 	//Caso encontre apenas um, remover e retornar uma mensagem de sucesso
		 	//Caso o heroi não seja encontrado, retonar o erro 404
	 }
	 
	 /***
	  * Ah, tem algo mais! O Sr. Wayne nos pediu para criar um endpoint onde ele possa selecionar 
	  * dois heróis e comparar seus atributos força, agilidade, destreza e inteligência. 
	  * Como resultado, o sistema deve retornar um objeto contendo os id's e a 
	  * diferença dos atributos (positivo se maior, negativo se menor) de cada herói. 
	  * Dá uma pensada em como vai ficar esse objeto e o caminho do endpoint
	  */
	 private void compare(Hero heroi1, Hero heroi2) {
		 //receber os dois herois
		 //buscar as informacoes de poder deles (atraves da entidade PowerStats)
		 //realizar comparacoes
		 //exibir os resultados
		 //esboço do objeto: HeroComparator
		 
		 HeroComparator hc = new HeroComparator();
		 hc.compare(heroi1, heroi2);
	 }
	 
	 
}
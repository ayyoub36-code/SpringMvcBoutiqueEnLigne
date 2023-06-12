package fr.fms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

@SpringBootApplication
public class SpringMvcEnLigneApplication implements CommandLineRunner {

	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcEnLigneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// generatedata();
		// generatedata(30);

	}

	public void generatedata() {

		// Category smartphone = categoryRepository.save(new
		// Category(1,"Smartphone",null));
		// Category tablet = categoryRepository.save(new Category(2,"Tablet",null));
		// Category pc = categoryRepository.save(new Category(3,"PC",null));
		Category smartphone = categoryRepository.findById(1L).get();
		Category tablet = categoryRepository.findById((long) 2).get();
		Category pc = categoryRepository.findById((long) 3).get();
		articleRepository.save(new Article(null, "I10", "Apple", 250, smartphone, null));
		articleRepository.save(new Article(null, "I11", "Apple", 250, smartphone, null));
		articleRepository.save(new Article(null, "I12", "Apple", 350, smartphone, null));
		articleRepository.save(new Article(null, "S9", "Samsung", 250, smartphone, null));
		articleRepository.save(new Article(null, "S10", "Samsung", 350, smartphone, null));
		articleRepository.save(new Article(null, "GalaxyTab", "Samsung", 450, tablet, null));
		articleRepository.save(new Article(null, "Ipad", "Apple", 350, tablet, null));
		articleRepository.save(new Article(null, "R510", "Asus", 500, pc, null));

	}
}

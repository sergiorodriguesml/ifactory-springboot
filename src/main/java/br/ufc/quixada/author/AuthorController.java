package br.ufc.quixada.author;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.quixada.pub.Pub;

@RestController
@RequestMapping("/authors")
public class AuthorController {

	@Autowired
	private AuthorRepository repository;

	@GetMapping()
	public List<Author> queryAllAuthors() {
		return (List<Author>) repository.findAll();
	}

	@PostMapping()
	public ResponseEntity<Void> createAuthor(@RequestBody Author author)
			throws MalformedURLException, URISyntaxException {
		repository.save(author);
		URL createdURL = new URL("http://localhost:8080/authors/" + author.getId().toString());
		return ResponseEntity.created(createdURL.toURI()).build();
	}

	@DeleteMapping(value="/{id}")
	public ResponseEntity<String> deleteA(@PathVariable Integer id) throws MalformedURLException, URISyntaxException {
		repository.delete(id);
		return ResponseEntity.ok("Author deletado");
	}
	
	@PutMapping()
	public ResponseEntity<Author> atualizaAuthor(@RequestBody Author author){
		repository.save(author);
		return ResponseEntity.ok(author);
	}

	@GetMapping(value="/{id}")
	public Author getAuthor(@PathVariable Integer id){
		return repository.findOne(id);
	}
	
	@GetMapping(value = "{id}/pubs")
	public ResponseEntity<Iterable<Pub>> getPubs(@PathVariable Integer id){
		return ResponseEntity.ok(repository.findOne(id).getPublications());
	}
}

package br.ufc.quixada.publisher;

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

import br.ufc.quixada.author.Author;

@RestController
@RequestMapping("/publishers")
public class PublisherController {
	
	@Autowired
	private PublisherRepository publisherRepository;
	
	@GetMapping()
	public List<Publisher> queryPublishers(){
		return (List<Publisher>) publisherRepository.findAll();
	}
	
	@PostMapping()
	public ResponseEntity<Publisher> createPublisher(@RequestBody Publisher publisher)
			throws MalformedURLException, URISyntaxException {
//		if(publisher == null) return ResponseEntity.notFound().build();
		publisherRepository.save(publisher);
//		URL createdURL = new URL("http://localhost:8080/publishers/" + publisher.getId().toString());
//		return ResponseEntity.created(createdURL.toURI()).build();
		return ResponseEntity.ok(publisher);
	}
	
	@DeleteMapping(value="/{id}")
	public void deletePublisher(@PathVariable Integer id) throws MalformedURLException, URISyntaxException {
		publisherRepository.delete(id);
	}
	
	@PutMapping()
	public void atualizaPublisher(@RequestBody Publisher publisher){
		publisherRepository.save(publisher);
	}
	
	@GetMapping(value="/{id}")
	public Publisher getPublisher(@PathVariable Integer id){
		return publisherRepository.findOne(id);
	}

}

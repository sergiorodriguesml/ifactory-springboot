package br.ufc.quixada.author;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class InMemoryAuthorRepository implements AuthorRepository {
	private static final List<Author> AUTHORS = new ArrayList<>();

	static {
		AUTHORS.addAll(Arrays.asList(new Author(1, "Sergio", "Rodrigues"), new Author(2, "Marcus", "Vieira")));
	}

	@Override
	public Iterable<Author> findAll() {
		return Collections.unmodifiableList(AUTHORS);

	}

	@Override
	public void save(Author author) {
		AUTHORS.add(author);

	}

	@Override
	public void deleteAuthor(Integer id) {
		AUTHORS.remove(id-1);
		
	}

	@Override
	public void attAuthor(Author author) {
		int id = author.getId()-1;
		AUTHORS.get(id).setFirstName(author.getFirstName());
		AUTHORS.get(id).setLastName(author.getLastName());
	}

	@Override
	public Author getAuthorByID(Integer id) {
		return AUTHORS.get(id-1);
	}

}

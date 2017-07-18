package br.ufc.quixada.author;

public interface AuthorRepository {
	
	Iterable<Author> findAll();
	
	public void save(Author author);
	
	public void deleteAuthor(Integer id);
	
	public void attAuthor(Author author);
	
	public Author getAuthorByID(Integer id);
	

}

package bookstoreDao;

import java.util.List;

public interface bookDAO {
	public void addbook(bookModel book);
	public List<bookModel> getAllbooks();
}

package dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import model.AvailableRooms;
import model.BillModel;
import model.BookModel;
import model.BookedData;
import model.BookedRooms;
import model.Login;
import model.User;
@Repository
public interface UserDao
{
	void register(User user);

	boolean validateUser(Login lg);

	List<BookedRooms> getUserRooms(Login lg);

	List<AvailableRooms> getAvailableRooms();

	List<BookedData>getbookedrooms();

	void adminRegister(User user);

	void bookroom(BookModel b);

	List<BookModel> autoselect(BookModel b);

	void deleteroom(BookModel b);

	List<BillModel> getbill(Login lg);

}

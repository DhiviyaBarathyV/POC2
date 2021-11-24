package com.dhiviyaBookStore.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.dhiviyaBookStore.model.Books;
import com.dhiviyaBookStore.model.Login;
import com.dhiviyaBookStore.model.OrderDetails;
import com.dhiviyaBookStore.model.Search;
import com.dhiviyaBookStore.model.User;
import com.dhiviyaBookStore.service.DhiviyaBookStoreService;


@SessionAttributes({"login"})
@RestController
public class DhiviyaBookStoreController 
{
	@Autowired
	DhiviyaBookStoreService service;
	@GetMapping("/main")
	public ModelAndView showmain()
	{
		ModelAndView mav= new ModelAndView("main");
		return mav ;
	}
	
	@GetMapping("/register")
	public ModelAndView showRegister()
	{
		User user= new User();
		ModelAndView mav= new ModelAndView("register");
		mav.addObject("user", user);
		return mav ;
		
	}

	@PostMapping("/registrationprocess")
	public ModelAndView addUser(@Valid @ModelAttribute("user") User user,BindingResult br)
	{
		ModelAndView mav=null;
		if(br.hasErrors())
		{
			mav= new ModelAndView("register");
		}
		else
		{
			mav= new ModelAndView("main");
			service.addUser(user);
		}
		  return mav;	
	}

	@GetMapping("/login")
	public ModelAndView showLogin()
	{
		Login login = new Login();
		ModelAndView mav= new ModelAndView("login");
		mav.addObject("login",login);
		return mav ;
	}
	
	@PostMapping("/loginprocess")
	public ModelAndView loginProcess( @ModelAttribute("login")Login login)
	{
		ModelAndView mav= null;
		System.out.println("name"+login.getUserName());
		System.out.println("pword"+login.getPassWord());
		
		if(login.getUserName().endsWith(".dhiviyabooks"))
		{
			if(service.adminValidation(login))
			{
				Search search= new Search();
				
				mav= new ModelAndView("adminWelcome");
				List<Books> allBooks=service.getAvailablebooks();
				mav.addObject("login",login);
				mav.addObject("allBooks",allBooks);
				mav.addObject("search",search);
			}
			else
			{
				mav= new ModelAndView("login");
			}
		}
		else
		{
			if(service.userValidation(login))
			{	
				Search search= new Search();
				mav= new ModelAndView("userWelcome");
				List<Books> allBooks=service.getAvailablebooks();
				mav.addObject("login",login);
				mav.addObject("allBooks",allBooks);
				mav.addObject("search",search);

			}
			else
			{
				mav= new ModelAndView("login");
			}	
		}	
		return mav;
	}

	@GetMapping("/searchAdmin")
	public ModelAndView welcomeAdmin( @ModelAttribute("login")Login login,@ModelAttribute("search")Search search)
	{
		System.out.println("Value:"+ search.getValue());
		ModelAndView mav= new ModelAndView("adminWelcome");
		List<Books> allBooks=service.getSearchBook(search.getValue());
		mav.addObject("login",login);
		mav.addObject("allBooks",allBooks);
		return mav;
	}
	@GetMapping("/searchUser")
	public ModelAndView welcomeUser( @ModelAttribute("login")Login login,@ModelAttribute("search")Search search)
	{
		System.out.println("Value:"+ search.getValue());
		ModelAndView mav= new ModelAndView("userWelcome");
		List<Books> allBooks=service.getSearchBook(search.getValue());
		mav.addObject("login",login);
		mav.addObject("allBooks",allBooks);
		return mav;
	}
	@GetMapping("/addBook")
	public ModelAndView addBook( @ModelAttribute("login")Login login)
	{
		ModelAndView mav= new ModelAndView("addBook");
		Books book= new Books();
		mav.addObject("login",login);
		mav.addObject("book",book);
		return mav;
	}
	@PostMapping("/addingBook")
	public ModelAndView addingBook( @ModelAttribute("login")Login login,@Valid @ModelAttribute("book") Books book,BindingResult br)
	{

		ModelAndView mav=null;
		if(br.hasErrors())
		{
			mav= new ModelAndView("addBook");
			Books books= new Books();
			mav.addObject("login",login);
			mav.addObject("book",books);
		}
		else
		{
			service.addBook(book);
			Search search= new Search();
			 mav= new ModelAndView("adminWelcome");
			List<Books> allBooks=service.getAvailablebooks();
			mav.addObject("login",login);
			mav.addObject("allBooks",allBooks);
			mav.addObject("search",search);
		}
		return mav;	
	}
	
	@GetMapping("/deleteBook/{idValue}")
	public ModelAndView deletingBook( @ModelAttribute("login")Login login,@ModelAttribute("idValue") int id,@ModelAttribute("book") Books book)
	{
		service.deleteBook(id);
		ModelAndView mav= new ModelAndView("deleteMsg");
		mav.addObject("id",id);
		mav.addObject("login",login);
		return mav;
			
	}
	@GetMapping("/buyBook/{idValue}/{bookname}")
	public ModelAndView deletingBook( @ModelAttribute("login")Login login,@ModelAttribute("idValue") int id,@ModelAttribute("bookname") String bookname)
	{
		List<OrderDetails> Order=service.buyBook(id,bookname,login);
		service.deleteBook(id);
		ModelAndView mav= new ModelAndView("orderDetails");
		mav.addObject("login",login);
		mav.addObject("Order",Order);
		return mav;
			
	}
	@GetMapping("/back")
	public ModelAndView backAdminWelcome( @ModelAttribute("login")Login login,@ModelAttribute("book") Books book)
	{
		Search search= new Search();
		
		ModelAndView mav= new ModelAndView("adminWelcome");
		List<Books> allBooks=service.getAvailablebooks();
		mav.addObject("login",login);
		mav.addObject("allBooks",allBooks);
		mav.addObject("search",search);
		return mav;
	}
	
	@GetMapping("/backu")
	public ModelAndView backUserWelcome( @ModelAttribute("login")Login login,@ModelAttribute("book") Books book)
	{
		Search search= new Search();
		
		ModelAndView mav= new ModelAndView("userWelcome");
		List<Books> allBooks=service.getAvailablebooks();
		mav.addObject("login",login);
		mav.addObject("allBooks",allBooks);
		mav.addObject("search",search);
		return mav;
	}
	
	@GetMapping("/mybooks")
	public ModelAndView myBooks(@ModelAttribute("login")Login login,@ModelAttribute("book") Books book)
	{
		ModelAndView mav= new ModelAndView("myBooks");
		mav.addObject("login",login);
		List<OrderDetails> details= service.getMyBooks(login.getUserName());
		mav.addObject("details",details);
		return mav;
		
	}
	@GetMapping("/sortBookname")
	public ModelAndView UserWelcomeSorted( @ModelAttribute("login")Login login,@ModelAttribute("book") Books book)
	{
		Search search= new Search();
		String field="bookName";
		ModelAndView mav= new ModelAndView("userWelcome");
		List<Books> allBooks=service.getAvailablebooksSortedByName(field);
		mav.addObject("login",login);
		mav.addObject("allBooks",allBooks);
		mav.addObject("search",search);
		return mav;
	}
	@GetMapping("/sortBooknamedesc")
	public ModelAndView UserWelcomeSortedDES( @ModelAttribute("login")Login login,@ModelAttribute("book") Books book)
	{
		Search search= new Search();
		String field="bookName";
		ModelAndView mav= new ModelAndView("userWelcome");
		List<Books> allBooks=service.getAvailablebooksSortedByNameDES(field);
		mav.addObject("login",login);
		mav.addObject("allBooks",allBooks);
		mav.addObject("search",search);
		return mav;
	}
	
	@GetMapping("/sortPrice")
	public ModelAndView UserWelcomeSortedPrice( @ModelAttribute("login")Login login,@ModelAttribute("book") Books book)
	{
		Search search= new Search();
		String field="price";
		ModelAndView mav= new ModelAndView("userWelcome");
		List<Books> allBooks=service.getAvailablebooksSortedByName(field);
		mav.addObject("login",login);
		mav.addObject("allBooks",allBooks);
		mav.addObject("search",search);
		return mav;
	}
	@GetMapping("/sortPriceDES")
	public ModelAndView UserWelcomeSortedPriceDES( @ModelAttribute("login")Login login,@ModelAttribute("book") Books book)
	{
		Search search= new Search();
		String field="price";
		ModelAndView mav= new ModelAndView("userWelcome");
		List<Books> allBooks=service.getAvailablebooksSortedByNameDES(field);
		mav.addObject("login",login);
		mav.addObject("allBooks",allBooks);
		mav.addObject("search",search);
		return mav;
	}
	@GetMapping("/sortBooknameAdmin")
	public ModelAndView AdminWelcomeSorted( @ModelAttribute("login")Login login,@ModelAttribute("book") Books book)
	{
		Search search= new Search();
		String field="bookName";
		ModelAndView mav= new ModelAndView("adminWelcome");
		List<Books> allBooks=service.getAvailablebooksSortedByName(field);
		mav.addObject("login",login);
		mav.addObject("allBooks",allBooks);
		mav.addObject("search",search);
		return mav;
	}	
	@GetMapping("/sortPriceAdmin")
	public ModelAndView AdminWelcomeSortedPrice( @ModelAttribute("login")Login login,@ModelAttribute("book") Books book)
	{
		Search search= new Search();
		String field="price";
		ModelAndView mav= new ModelAndView("adminWelcome");
		List<Books> allBooks=service.getAvailablebooksSortedByName(field);
		mav.addObject("login",login);
		mav.addObject("allBooks",allBooks);
		mav.addObject("search",search);
		return mav;
	}
	@GetMapping("/sortBooknameAdminDES")
	public ModelAndView AdminWelcomeSortedDES( @ModelAttribute("login")Login login,@ModelAttribute("book") Books book)
	{
		Search search= new Search();
		String field="bookName";
		ModelAndView mav= new ModelAndView("adminWelcome");
		List<Books> allBooks=service.getAvailablebooksSortedByNameDES(field);
		mav.addObject("login",login);
		mav.addObject("allBooks",allBooks);
		mav.addObject("search",search);
		return mav;
	}	
	@GetMapping("/sortPriceAdminDES")
	public ModelAndView AdminWelcomeSortedPriceDES( @ModelAttribute("login")Login login,@ModelAttribute("book") Books book)
	{
		Search search= new Search();
		String field="price";
		ModelAndView mav= new ModelAndView("adminWelcome");
		List<Books> allBooks=service.getAvailablebooksSortedByNameDES(field);
		mav.addObject("login",login);
		mav.addObject("allBooks",allBooks);
		mav.addObject("search",search);
		return mav;
	}	
}

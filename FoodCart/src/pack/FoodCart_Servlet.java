package pack;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FoodCart_Servlet
 */
@WebServlet("/FoodCart")
public class FoodCart_Servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get the data  from the database(Model)
//		String[] foodItems= {"Biriyani", "Pizza" , "Chicken Lolypop"};
//		request.setAttribute("foodItems", foodItems);
		
		try {
			List<Food> foodItems =FoodCartDbUtil.getFoodList();
			request.setAttribute("foodItems", foodItems);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		// redirect to a different page(View)
		RequestDispatcher dispatcher=request.getRequestDispatcher("show-food.jsp");
		dispatcher.forward(request, response);
	}

}

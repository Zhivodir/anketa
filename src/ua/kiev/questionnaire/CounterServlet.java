package ua.kiev.questionnaire;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class CounterServlet extends HttpServlet {
	private static Map<String, Integer> statistic = new HashMap<>();
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String firstName = req.getParameter("name");
		String surname = req.getParameter("surname");
		String age = req.getParameter("age");
		if(req.getParameter("age") != null && req.getParameter("age").matches("[-+]?\\d+")) {
			int age1 = Integer.parseInt(req.getParameter("age"));
		}

		String gender = req.getParameter("gender");
		if(statistic.containsKey(gender)){
			statistic.put(gender, statistic.get(gender) + 1);
		}else{
			statistic.put(gender, 1);
		}

		String education = req.getParameter("education");
		if(statistic.containsKey(education)){
			statistic.put(education, statistic.get(gender) + 1);
		}else{
			statistic.put(education, 1);
		}

		String maritalStatus = req.getParameter("maritalStatus");
		if(statistic.containsKey(maritalStatus)){
			statistic.put(maritalStatus, statistic.get(gender) + 1);
		}else{
			statistic.put(maritalStatus, 1);
		}

		req.setAttribute("name", firstName);
		req.setAttribute("surname", surname);
		req.setAttribute("age", age);
		req.setAttribute("statistic", statistic);

		RequestDispatcher Dispatcher = getServletContext().getRequestDispatcher("/statistic.jsp");
		try {
			Dispatcher.forward(req, resp);
		}catch(ServletException e){e.printStackTrace();}

	}
}

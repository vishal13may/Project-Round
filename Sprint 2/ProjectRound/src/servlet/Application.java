package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import bean.Data;

import sql.Queries;

/**
 * Servlet implementation class Application
 */
@WebServlet("/Application")
public class Application extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Map<Integer,Data> questionMap = new HashMap<Integer, Data>();
      private static int key = 1;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Application() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Data d = getQuestion();
		Gson gson = new Gson();
		JsonObject myObj = new JsonObject();
		JsonElement questionJson = gson.toJsonTree(d);
		if (d.getQuestion() == null) {
			myObj.addProperty("success", false);
		} else {
			myObj.addProperty("success", true);
		}
		myObj.add("Question",questionJson);
		PrintWriter out = response.getWriter();
		out.println(myObj.toString());
		out.close();
	}

	private Data getQuestion(){
		Data d = null;
		if(questionMap.size()==0){
			Queries q = new Queries();
			try {
				questionMap= q.getQuestion();
				d = questionMap.get(key++);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			d= questionMap.get(key++);
		}
		return d;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Queries q = new Queries();
		try {
			Map<Integer,Data> questionMap= q.getQuestion();
			System.out.println(questionMap);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

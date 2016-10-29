package sql;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.ConnectionPool;

import bean.*;

public class Queries {
	public Map<Integer,Data> getQuestion() throws SQLException{
		Connection con = ConnectionPool.getConnection();
		if(con==null){
			return null;
		}
		Statement st = con.createStatement();
		String query = "select * from questiondata";
		ResultSet rs = st.executeQuery(query);
		Map<Integer,Data> questionMap = new HashMap<Integer,Data>();
		while(rs.next()){
			Data d = new Data();
			d.setQuestionId(rs.getInt(1));
			d.setQuestion(rs.getString(2));
			questionMap.put(d.getQuestionId(),d);
		}
		
		query = "select * from answer";
		rs = st.executeQuery(query);
		while(rs.next()){
			Data d = questionMap.get(rs.getInt(1));
			d.setAnswer(rs.getInt(2));
		}
	    
		query = "select * from answerchoices";
		rs = st.executeQuery(query);
		while(rs.next()){
			Data d = questionMap.get(rs.getInt(1));
			d.getChoices().put(rs.getInt(2),rs.getString(3));
		}
	    
		return questionMap;
		
	}
}

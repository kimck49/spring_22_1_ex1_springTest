package com.kimck.spring_22_1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

public class TicketDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public TicketDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void buyTicket(final TicketDto dto) {
		
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				String query = "insert into card(consumerid, amount) values(?,?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, dto.getConsumerid());
				pstmt.setString(2, dto.getAmount());
				
				return pstmt;
			}
		});
		
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				String query = "insert into ticket(consumerid, countnum) values(?,?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, dto.getConsumerid());
				pstmt.setString(2, dto.getAmount());
				
				return pstmt;
			}
		});
		
		
	}
	
	
	
	
	
	
	
}

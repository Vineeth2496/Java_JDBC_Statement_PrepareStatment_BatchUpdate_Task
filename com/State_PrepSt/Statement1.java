package com.State_PrepSt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import com.properties.jdbcCon;

public class Statement1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try
		{
			
			
		jdbcCon c=new jdbcCon();
		Connection con=c.con();
		System.out.println(con);
		
		con.setAutoCommit(false);
		
		PreparedStatement pst=con.prepareStatement("select srno,id,name from table1", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		ResultSet rs1=pst.executeQuery();
		
		RowSetFactory rsf =RowSetProvider.newFactory();
		
		CachedRowSet crs=rsf.createCachedRowSet();
		
		crs.populate(rs1);
		
		for(;crs.next();)
		{
			System.out.println(rs1.getInt("Srno"));
			System.out.println(rs1.getInt("Id"));
			System.out.println(rs1.getString("Name"));
		}
		
	/*	for(;rs.next();)
		{
			System.out.println(rs.getString("Cenima"));
			System.out.println(rs.getString("Hero"));
			System.out.println(rs.getString("Heroine"));
			System.out.println(rs.getString("Director"));
		}
		
		System.out.println("************************");
		for(;rs.previous();)
		{
			System.out.println(rs.getString("Cenima"));
			System.out.println(rs.getString("Hero"));
			System.out.println(rs.getString("Heroine"));
			System.out.println(rs.getString("Director"));
		}
	*/
	/*	rs.absolute(3);
		rs.updateInt(1, 004);
		rs.updateInt(2, 204);
		rs.updateString(3, "kathrine");
		
		rs.updateRow();
		System.out.println("updated"+rs);
	*/
		
	/*	rs.absolute(3);
		rs.deleteRow();
	*/	
	/*	
		PreparedStatement pst=con.prepareStatement("insert into table1 values(?, ?, ?)");
		pst.setInt(1, 001);
		pst.setInt(2, 201);
		pst.setString(3, "Navya");
	
		pst.addBatch();
		
		pst.setInt(1, 002);
		pst.setInt(2, 202);
		pst.setString(3, "Kavya");
	
		pst.addBatch();
		pst.setInt(1, 003);
		pst.setInt(2, 203);
		pst.setString(3, "Divya");
	
		pst.addBatch();
		
		int a[]=pst.executeBatch();
		
		for(int x:a)
		{
			con.commit();
			System.out.println("Prepared statement updated:"+x);
		}
	*/
		
	/*	
		Statement st1=con.createStatement();
	//	String qr1="create table movie(cenima varchar2(15), hero varchar2(15), heroine varchar2(15), Director varchar2(15))";
	//	st1.addBatch(qr1);

		String qr2="insert into movie values('Major', 'Adivi sesh', 'Saiee', 'Venampalli')";
		st1.addBatch(qr2);

		String qr3="insert into movie values('Badri', 'Pawan kalyan', 'Renu, Ameesha', 'Puri Jagan')";
		st1.addBatch(qr3);

		String qr4="insert into movie values('Darling', 'Prabhas', 'Kajol', 'Karunakaran')";
		st1.addBatch(qr4);

		int i[]=st1.executeBatch();
		
		for(int x:i)
		{
			con.commit();
			System.out.println("Updated qurries: "+x);
		}
	*/	
		
		
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

}

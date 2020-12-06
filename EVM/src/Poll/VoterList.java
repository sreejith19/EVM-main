/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Poll;
import evm.Error;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author user
 */
public class VoterList {
    private static String userName="tapan";
    private static String password="tapan*1234";
    public static String generate(String cons){
        String list="\n Voters List ("+cons+")\n VoterID  Name  DOB\n";
        try{
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection con=DriverManager.getConnection(  
               "jdbc:mysql://localhost:3306/evm2?useSSL=false","tapan","tapan*1234");
            Statement stmt=con.createStatement();  
      
            String s= "select * from Voter where constituency=\'"+cons+"\'";
            ResultSet rs=stmt.executeQuery(s);
            while(rs.next()){
                String v=rs.getString("Voter_id");
                String n=rs.getString("Name");
                Date dob=rs.getDate("dob");
                list+=(v+"  "+n+"  "+dob+"\n");
            }
            return list;
       }
       catch(ClassNotFoundException|SQLException e){
           new Error("error");
       }
        return "Cannot generate list";
    }
    /*public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(generate(s));
    }*/
}

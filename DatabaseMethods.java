/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.persistenta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseMethods {

    private Connection conn;

    public DatabaseMethods(String databaseURL, String username, String password) throws SQLException {
        conn = DriverManager.getConnection(databaseURL, username, password);
    }

    public boolean afisareAngajati() {

        List<Person> person_collection = new ArrayList<>();
        try {

            Statement st = conn.createStatement();
            st.executeQuery("select * from person");
            ResultSet rs = st.getResultSet();

            while (rs.next()) {

                
                Person angajati = new Person(rs.getInt("person_id"), rs.getString("name"), rs.getInt("age"), rs.getString("address"), rs.getInt("salary"));
                person_collection.add(angajati);

            }

        } catch (SQLException exception) {
            System.out.println(exception);
        }
        person_collection.forEach((per) -> {
            System.out.println(per);
        });
        return false;

    }

    void selectareAngajatiNume(String name) {

        try {

            PreparedStatement stmt = conn.prepareStatement("select * from person where name=?");
            stmt.setString(1, name);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {

                
                System.out.println(rs.getString("name")+ "\t"+ rs.getInt("age")+"\t"+ rs.getString("address")+"\t"+rs.getInt("salary") );
                

            }


        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

    }

    void selectareAngajatiVarsta(int age) {

        try {

            PreparedStatement stmt = conn.prepareStatement("select * from person where age=?");
            stmt.setInt(1, age);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {

                
                System.out.println(rs.getString("name")+ "\t"+ rs.getInt("age")+"\t"+ rs.getString("address")+"\t"+rs.getInt("salary") );
                

            }

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

    }

    void selectareAngajatiAdresa(String address) {

        try {

            PreparedStatement stmt = conn.prepareStatement("select * from person where address=?");
            stmt.setString(1, address);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {

                
               System.out.println(rs.getString("name")+ "\t"+ rs.getInt("age")+"\t"+ rs.getString("address")+"\t"+rs.getInt("salary") );
                

            }

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

    }

    void selectareAngajatiSalariu(int salary) {

        try {

            PreparedStatement stmt = conn.prepareStatement("select * from person where salary=?");
            stmt.setInt(1, salary);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {

                
                System.out.println(rs.getString("name")+ "\t"+ rs.getInt("age")+"\t"+ rs.getString("address")+"\t"+rs.getInt("salary") );
                

            }
            

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

    }

    

    void modificareAngajatiNume(String name, int id) {

        try {

            PreparedStatement stmod = conn.prepareStatement("insert into person (name) values (?) where person_id=?");
            stmod.setString(1, name);
            stmod.setInt(2,id);
            stmod.execute();

        } catch (SQLException exception) {
            System.out.println(exception);
        }

    }
    void modificareAngajatiVarsta(int age, int id) {

        try {

            PreparedStatement stmod = conn.prepareStatement("insert into person (age) values (?) where person_id=?");
            stmod.setInt(1, age);
            stmod.setInt(2,id);
            stmod.execute();

        } catch (SQLException exception) {
            System.out.println(exception);
        }

    }
    void modificareAngajatiAdresa(String address, int id) {

        try {

            PreparedStatement stmod = conn.prepareStatement("insert into person (address) values (?) where person_id=?");
            stmod.setString(1, address);
            stmod.setInt(2,id);
            stmod.execute();

        } catch (SQLException exception) {
            System.out.println(exception);
        }

    }
    void modificareAngajatiSalariu(int salary, int id) {

        try {

            PreparedStatement stmod = conn.prepareStatement("insert into person (salary) values (?) where person_id=?");
            stmod.setInt(1, salary);
            stmod.setInt(2,id);
            stmod.execute();

        } catch (SQLException exception) {
            System.out.println(exception);
        }

    }

    public boolean stergereAngajati(int id) {

        try {

            PreparedStatement st = conn.prepareStatement("delete from person where person_id = ?");
            st.setInt(1, id);
            st.execute();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

        return false;

    }

    public boolean noiAngajati(Person angajat) {

        try {

            PreparedStatement st = conn.prepareStatement("insert into person (name,age,address,salary) values (?,?,?,?)");
            st.setString(1, angajat.getName());
            st.setInt(2, angajat.getAge());
            st.setString(3, angajat.getAddress());
            st.setInt(4, angajat.getSalary());
            st.execute();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

        return false;

    }

//
}

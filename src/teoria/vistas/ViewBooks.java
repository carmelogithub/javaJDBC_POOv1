package teoria.vistas;

import java.sql.*;
import java.util.Scanner;

public class ViewBooks {
    //escribe el código para mostrar los libros en un listado. No hagas la tabla manualmente.
    public static void main(String[] args){
        String consulta = "SELECT * FROM libros where precio > ?";
        Connection conn = null;

            try(Connection conexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/a_biblioteca","root","")){
                PreparedStatement ps = conexion.prepareStatement(consulta);
                Scanner sc= new Scanner(System.in);
                System.out.println("Dime los libros que quieres ver con un precio mayor a: ");
                ps.setDouble(1, sc.nextDouble());
                ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                            System.out.println("ID: " + rs.getInt("id"));
                            System.out.println("Titulo: " + rs.getString("titulo"));
                            System.out.println("Autor:" + rs.getString("autor"));
                            System.out.println(" Precio: " + rs.getDouble("precio"));
                            System.out.println("----------------------------");
                        }//cierra while


            }//cierra try
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
            /*
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/a_biblioteca","root","");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Titulo: " + rs.getString("titulo"));
               System.out.println("Autor:" + rs.getString("autor"));
               System.out.println(" Precio: " + rs.getDouble("precio"));
               System.out.println("----------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
    }//cierra el main

}



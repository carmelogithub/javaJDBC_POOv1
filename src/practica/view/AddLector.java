package practica.view;

import practica.model.Lector;

import java.sql.*;

public class AddLector {

    public static void main(String[] args) {
        System.out.println("AddLector");
        Date fecha=Date.valueOf("2024-03-11");


        System.out.println("Fecha: "+fecha.toString());


        Lector lector=new Lector(20,"Juan","Madrid",fecha);
        Connection conn = null;
        try {
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/a_biblioteca","root","");
            String sql = "INSERT INTO lectores (id,nombre,ciudad,fecha) VALUES (?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,lector.getId());
            ps.setString(2,lector.getNombre());
            ps.setString(3,lector.getCiudad());
            ps.setDate(4,lector.getFecha_alta());
            int nuevo_lector=ps.executeUpdate();
            System.out.println("Nuevo lector: "+nuevo_lector);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }

}//cierra clase

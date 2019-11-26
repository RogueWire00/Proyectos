
 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.vehiculo.aplicacion.bd;

import hn.uth.vehiculo.aplicacion.objeto.Vehiculo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class gestorDB {
    
public static Connection getConexion()
            throws Exception {
        try {
            String url = "jdbc:mysql://localhost:3306/datos_vehiculos";
            String usuario = "root";
            String contrasenia = "";

            return DriverManager
                    .getConnection(url,
                            usuario,
                            contrasenia);
        } catch (Exception e) {
            throw new Exception("No se pudo establecer la conexión: " + e.toString());
        }

    }

    public static void guardarVehiculo(Vehiculo vehiculo) {
        try {
            Connection con = getConexion();
            String sql = "INSERT INTO Vehiculos "
                    + " (PLACA, MODELO, MARCA,ANIO,MOTOR,PRECIO,NOMBRE,DESCRIPCION,IMAGEN) "
                    + " VALUES (?,?,?,?,?,?,?,?,?) ";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, vehiculo.getPlaca());
            ps.setString(2, vehiculo.getModelo());
            ps.setString(3, vehiculo.getMarca());
            ps.setInt(4, vehiculo.getAnio());
            ps.setString(5, vehiculo.getMotor());
            ps.setDouble(6, vehiculo.getPrecio());
            ps.setString(7, vehiculo.getNombre());
            ps.setString(8, vehiculo.getDescripcion());
            ps.setString(9, vehiculo.getImagen());

            ps.execute();

            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error guardar Vehiculo: "
                    + e.toString());
        }
    }

    public static void actualizarVehiculo(Vehiculo vehiculo) {
        try {
            Connection con = getConexion();
            String sql = "UPDATE  Vehiculos "
                    + "SET MODELO=? "
                    + ", MARCA =? "
                    + ",ANIO=? "
                    + ",MOTOR=? "
                    + ",PRECIO=? "
                    + ",NOMBRE=? "
                    + ",DESCRIPCION=? "
                    + ",IMAGEN=? "
                    + "WHERE PLACA=? ";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, vehiculo.getPlaca());
            ps.setString(2, vehiculo.getModelo());
            ps.setString(3, vehiculo.getMarca());
            ps.setInt(4, vehiculo.getAnio());
            ps.setString(5, vehiculo.getMotor());
            ps.setDouble(6, vehiculo.getPrecio());
            ps.setString(7, vehiculo.getNombre());
            ps.setString(8, vehiculo.getDescripcion());
            ps.setString(9, vehiculo.getImagen());

            ps.executeUpdate();

            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error guardar Vehiculo: "
                    + e.toString());
        }
    }

    public static void eliminarVehiculo(Vehiculo vehiculo) {
        try {
            Connection con = getConexion();
            String sql = "DELETE FROM Vehiculo "
                    + "WHERE PLACA=? ";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, vehiculo.getPlaca());

            ps.execute();

            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error guardar Placa: "
                    + e.toString());
        }
    }

    public static List<Vehiculo> getVehiculo() {
        try {
            List<Vehiculo> lista = new ArrayList<>();
            Connection con = getConexion();
            String sql = "SELECT *  FROM Vehiculo ";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                lista.add(
                        new Vehiculo(
                                rs.getString("Placa"),
                                 rs.getString("Modelo"),
                                 rs.getString("Marca"),
                                 rs.getInt("ANIO"),
                                 rs.getString("Motor"),
                                 rs.getDouble("Precio"),
                                 rs.getString("Nombre"),
                                 rs.getString("Descripcion"),
                                 rs.getString("Imagen")));       
            }
            rs.close();
            st.close();
            con.close();

            return lista;
        } catch (Exception e) {
            System.out.println("Error guardar Vehiculo: "
                    + e.toString());
        }
        return null;
    }
}

package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import javax.swing.JOptionPane;
import Model.funciones;

public final class SQL extends funciones {

    private final String DATABASE_URL = "jdbc:mysql://icomponents.net:3306/icompone_mario";
    private final String USERNAME = "icompone_mario";
    private final String PASSWORD = "Mario2018";

    private Connection connection;
    private Properties properties;

    /**
     * Constructor de la clase SQL Crea una instancia a la base de datos.
     */
    protected SQL() {
        super();
        this.connect();
    }

    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("Username", USERNAME);
            properties.setProperty("Password", PASSWORD);
        }
        return properties;
    }

    /**
     * Crea la instancia a la base de datos, luego de cargar la libreria:
     * com.mysql.jdbc.Driver: sin esta libreria no funcionará.
     *
     * @return
     */
    public Connection connect() {
        if (this.connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                this.connection = DriverManager.getConnection(this.DATABASE_URL, USERNAME, PASSWORD);

            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "" + e);
            }
        }
        return connection;
    }

    /**
     * Cierra la conexion a la base de datos
     *
     *
     * @return
     */
    public Connection disconnect() {
        try {
            if (this.connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
        return connection;
    }

    /**
     * Retorna si una consulta (SELECT) tiene datos o bien si existe o no.
     *
     * @param rs
     * @return true si existe y-o tiene datos.
     */
    public boolean Exists(ResultSet rs) {
        try {
            return rs.isBeforeFirst();
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Recibe las sentencias que no son select: UPDATE, DELETE, INSERT, DROP ..
     *
     * @param preparedQuery
     * @param objs
     * @return
     */
    public boolean exec(String preparedQuery, ArrayList<Object> objs) {
        connect();
        PreparedStatement ps;
        try {
            ps = this.connection.prepareStatement(preparedQuery);

            Iterator it = objs.iterator();
            int poc = 1;
            while (it.hasNext()) {
                Object element = it.next();
                if (this.isNumeric(element)) {
                    ps.setInt(poc, Integer.parseInt(element.toString()));
                } else {
                    ps.setString(poc, element.toString());
                }
                poc++;
            }

            ps.executeUpdate();
            ps.close();
            return true;

        } catch (SQLException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        } finally {
            disconnect();
        }

    }

    /**
     * Sentencia ùnica para SELECT, retorna un ResultSet, que podrà ser
     * utilizado para crear tablas o manipular informaciòn.
     *
     * @param preparedQuery
     * @param objs
     * @return
     */
    public ResultSet SELECT(String preparedQuery, ArrayList<Object> objs) {
        connect();
        PreparedStatement ps;
        try {
            ps = this.connection.prepareStatement(preparedQuery);

            Iterator it = objs.iterator();
            int poc = 1;
            while (it.hasNext()) {
                Object element = it.next();
                if (this.isNumeric(element)) {
                    ps.setInt(poc, Integer.parseInt(element.toString()));
                } else {
                    ps.setString(poc, element.toString());
                }
                poc++;
            }

            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {

        }
        return null;
    }
}

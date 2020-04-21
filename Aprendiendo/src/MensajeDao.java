import java.sql.SQLException;

public class MensajeDao {

	Conexion con = null;
	
	public MensajeDao() {
		con = Conexion.getConexion();
	}
	
	public void insertar (Mensaje mensaje) {
		String sql = "INSERT INTO mensaje (name, email, website, message)"
				+ "VALUES ('"+mensaje.getName()+"','"+mensaje.getEmail()+"','"+mensaje.getWebsite()+"','"+mensaje.getMessage()+"')";
		try {
			con.insert(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

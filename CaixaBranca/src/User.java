import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class User {

     /**
     * Estabelece uma conexão com o banco de dados MySQL.
     *
     * @return Uma conexão com o banco de dados.
     */
	public Connection conectarBD() {
		Connection conn = null;
		try {
			// Carrega o driver JDBC do MySQL
			Class.forName("com.mysql.Driver.Manager").newInstance();

			// Define a URL de conexão com o banco de dados
			String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
			conn = DriverManager.getConnection(url);		
		} catch (Exception e) { }
		return conn;}

	// Variáveis de instância
	public String nome=""; 
	public boolean result = false; 


	/**
     	* Verifica as credenciais de login de um usuário no banco de dados.
     	*
     	* @param login O nome de usuário.
     	* @param senha A senha do usuário.
     	* @return Verdadeiro se o usuário estiver autenticado, falso caso contrário.
     	*/
	public boolean verificarUsuario(String login, String senha) {
		String sql = "";
		Connection conn = conectarBD();
		sql += "select nome from usuarios"; 
		sql += "where login = " + "'" + login + "'";
		sql += " and senha = " + "'" + senha + ";";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				result = true; 
				nome = rs.getString("nome");}
		} catch (Exception e) { }
		return result;}

}

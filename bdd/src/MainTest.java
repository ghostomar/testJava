import java.sql.*;


public class MainTest {
	
	/**
	 * @param args
	 */
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Connection connexion = null;
		try {
		Class.forName("com.mysql.jdbc.Driver") ;
		connexion = DriverManager.getConnection("jdbc:mysql://localhost/revision", "root", "");
		System.out.println("ok");
		
		Statement st = connexion.createStatement();
		/*int count = st.executeUpdate("INSERT INTO types (NumType, LibType) VALUES (6,'test3'),(7,'test3');");
		System.out.println("Il y a eu " + count + " ligne.");
		*/
		ResultSet rs = st.executeQuery ("SELECT * FROM types") ;
		// Pour accéder à chacune des lignes du résultat de la requête :
		int num;
		String lib;
		
		while (rs.next()) {
		num = rs.getInt("NumType");
		lib = rs.getString("LibType");
		System.out.println("num=" + num + "lib=" + lib) ;
		}
		rs.close() ; // Permet de libérer la mémoire utilisée.
		
		
		connexion.close(); // Fermeture de la connexion
		}
		catch(ClassNotFoundException erreur) {
			System.out.println("Driver non chargé !" + erreur);
			}
		catch(SQLException erreur) {
			System.out.println("erreur de connexion a la bdd");
		}
	}
}

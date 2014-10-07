import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Model {

	static Connection connexion = null;

	public static void connexionBdd(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
			connexion = DriverManager.getConnection("jdbc:mysql://localhost/revision", "root", "");
			System.out.println("open ok");
		}
		catch(ClassNotFoundException erreur) {
			System.out.println("Driver non chargé !" + erreur);
			}
		catch(SQLException erreur) {
			System.out.println("erreur de connexion a la bdd");
		}
	}
	
	public static void exitBdd(){
		
		try {
			connexion.close(); // Fermeture de la connexion
			System.out.println("exit ok");
		}
		catch(SQLException erreur) {
			System.out.println("erreur close bdd");
		}
	}

	public static void insert(Types unTyp){
		
		try {
			
			int num;
			String lib;
			num = unTyp.getNumType();
			lib = unTyp.getLibType();
			Statement st = connexion.createStatement();
			int count = st.executeUpdate("INSERT INTO types (NumType, LibType) VALUES ('"+ num +"', '"+ lib +"')");  
			//System.out.println("Il y a eu " + count + " ligne.");
			
		}
		catch (SQLException e) {
			System.out.println("erreur insert");
		  }
	}
	
	
	public static Object[][] select(){
			
		try {
			
			Statement st = connexion.createStatement();
			ResultSet rs = st.executeQuery ("SELECT * FROM types") ;
			

			int i=0;
			int num;
			String lib;
			Object[][] tab = new Object[10][10];
			
			while (rs.next()) {
				num = rs.getInt("NumType");
				lib = rs.getString("LibType");
				
				tab[i][0]=num;
				tab[i][1]=lib;
				i=i+1;
			}
			rs.close();
			return tab;
		}
		catch (SQLException e) {
			System.out.println("erreur select");
		  }
		return null;
	}

}

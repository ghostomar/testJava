import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTable;

public class Vue extends JFrame {
	
	public Vue(Object[][] unTab) {
    	 super();

        setTitle("ma base de données");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
		String[] entetes = {"numTypes", "libTypes"};
		JTable tableau = new JTable(unTab, entetes);
		
        getContentPane().add(tableau.getTableHeader(), BorderLayout.NORTH);
        getContentPane().add(tableau, BorderLayout.CENTER);
 
        pack();
		}	
    }

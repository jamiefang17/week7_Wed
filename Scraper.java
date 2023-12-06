package week7_Wed;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.*;

public class Scraper extends JFrame {
    //add instance viable
    JTextField urlTextField;
    JTable jtable;
    JTextField regexTextField;

    public Scraper(){
        super("Scrape the application");
        
        setLayout(new BorderLayout());

        urlTextField = new JTextField("Enter URL");
        add(urlTextField, BorderLayout.NORTH);

        String columns[] ={"ID","NAME","SALARY"};
        String data[][]={{"1","Jamie","30000"},{"2","Peter","4500"},{"3","Esther","2500"}};

        jtable = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(jtable);
        add(scrollPane);
       
        JPanel southJPanel =new JPanel();
        
        regexTextField = new JTextField();

        add(southJPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(800,900);
        setVisible(true);
    }
    
}

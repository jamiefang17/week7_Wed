package week7_Wed;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;

public class Scraper extends JFrame {
    //add instance viable
    JTextField urlTextField;
    JTable jtable;
    JTextField regexTextField;
    JButton btn;

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
        btn =new JButton("Click here");
        btn.addActionListener(this::SearchPage);
        //btn.addActionLister(e -> SearchPange(e));
        southJPanel.add(btn);
        
        regexTextField = new JTextField(20);
        southJPanel.add(regexTextField);

        add(southJPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(500,300);
        setSize(800,300);
        setVisible(true);
    }
    //add btn click
    public void SearchPage(ActionEvent e){
        //every time click the bt, we'll
    }
    
}

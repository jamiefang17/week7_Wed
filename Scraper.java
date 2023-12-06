package week7_Wed;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Scraper extends JFrame {
    //add instance viable
    JTextField urlTextField;
    DefaultTableModel tableModel;
    JTable jtable;
    JComboBox<String> regexComboBox;
    //JTextField regexTextField;
    JButton btn;

    public Scraper(){
        super("Scrape the application");
        
        setLayout(new BorderLayout());

        urlTextField = new JTextField("Enter URL");
        add(urlTextField, BorderLayout.NORTH);
        //design the table with default looking
        tableModel= new DefaultTableModel();
        jtable = new JTable(tableModel);

        tableModel.addColumn("Line#"); 
        tableModel.addColumn("Result");
        

        //String columns[] ={"ID","NAME","SALARY"};
        //String data[][]={{"1","Jamie","30000"},{"2","Peter","4500"},{"3","Esther","2500"}};

        //jtable = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(jtable);
        add(scrollPane);
       
        JPanel southJPanel =new JPanel();

        regexComboBox =new JComboBox<String>();
        regexComboBox.addItem("\\d{3}\\-\\d{3}\\-\\d{4}");
        regexComboBox.addItem("0-9");
        regexComboBox.addItem("[A-Za-z0-9\\.]+\\@[A-Za-z0-9]+\\.[A-Za-z0-9]+");

        btn =new JButton("Click here");
        btn.addActionListener(this::SearchPage);
        //btn.addActionLister(e -> SearchPange(e));
        southJPanel.add(btn);
        
        //regexComboBox = new JTextField(20);
        southJPanel.add(regexComboBox);

        add(southJPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(500,300);
        setSize(800,300);
        setVisible(true);
    }

    //add reset

public void Reset(ActionEvent e)
{
    tableModel.setRowCount(0);
    match.clear();
}

//add btn click
    public void SearchPage(ActionEvent e){
        tableModel.setRowCount(0);
        //every time click the bt, we'll
        //get url
        try{
        URL url = new URL(urlTextField.getText());
        URLConnection urlConnection =url.openConnection();
       InputStream inputStream = urlConnection.getInputStream();
       InputStreamReader streamReader = new InputStreamReader(inputStream);

       BufferedReader bufferedReader = new BufferedReader(streamReader);
       String line = null;
       HashSet<String> matches =new HashSet<String>();


        while ((line = bufferedReader.readLine())!=null){
            //REGEX pattern matching
            Pattern pattern = Pattern.compile(regexComboBox.getSelectedItem().toString());
            Matcher match = pattern.matcher(line);
            //add to our table
            if(match.find()){
                if(matches.contains((match.group())))
                {}//do noth
                else{
                    var grouping =match.group();
                    //.....
                               matches.add(match.group());
                tableModel.addRow(new Object[]{String.valueOf(tableModel.getColumnCount() +1), match.group()});
            }
        }

            
        }       

        } catch(Exception exception){

        }

    }
    
}

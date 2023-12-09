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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Scraper extends JFrame {

JTextField textFieldUrl;
//JTextField textFieldRegex;
JTable jtable;
JButton btn;
DefaultTableModel tableModel;
JComboBox box = new JComboBox<>();
public Scraper() {
super("scrape the internet");

setLayout(new BorderLayout());

textFieldUrl = new JTextField(20);

add(textFieldUrl, BorderLayout.NORTH);

tableModel = new DefaultTableModel();
jtable = new JTable(tableModel);

tableModel.addColumn("Line #");
tableModel.addColumn("Result");

JScrollPane pane = new JScrollPane(jtable);

add(pane);

JPanel panel = new JPanel();

//textFieldRegex = new JTextField(20);
box.addItem("[0-9]+");
box.addItem("\\d{3}\\-\\d{3}\\-\\d{4}");
box.addItem("[0-9a-zA-Z\\.]+\\@[0-9a-zA-Z\\\\.]+\\.[0-9a-zA-Z\\\\.]+");
panel.add(box);

btn = new JButton("Click me!");
btn.addActionListener(e -> HandleButtonClick(e));
panel.add(btn);

add(panel, BorderLayout.SOUTH);

setSize(500, 599);
setLocationRelativeTo(null);
setDefaultCloseOperation(DISPOSE_ON_CLOSE);
setVisible(true);
}

private void HandleButtonClick(ActionEvent e) {
URL givenUrl = null;
tableModel.setRowCount(0);

try {
givenUrl = new URL(textFieldUrl.getText());

URLConnection connection = givenUrl.openConnection();
InputStream is = connection.getInputStream();

BufferedReader br = new BufferedReader(new InputStreamReader(is));

String line = null;

while ((line = br.readLine()) != null) {
Pattern pattern = Pattern.compile(box.getSelectedItem().toString());
Matcher match = pattern.matcher(line);

while (match.find()) {
tableModel.insertRow(tableModel.getRowCount(), new Object[]{String.valueOf(tableModel.getRowCount() + 1), match.group()});
}
}

} catch (Exception exception) {
}

}
}
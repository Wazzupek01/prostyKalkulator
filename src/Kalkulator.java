import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import static java.awt.image.ImageObserver.HEIGHT;
import static java.lang.Math.pow;

public class Kalkulator extends Component {
    private JButton podziel;
    private JPanel panel1;
    private JFormattedTextField liczbaB;
    private JFormattedTextField liczbaA;
    private JButton dodaj;
    private JButton odejmij;
    private JButton pomnoz;
    private JFormattedTextField wynik;
    private JButton pierwiastek;
    private JButton potega;
    private JButton rad;
    private JButton binarnie;

    public Kalkulator() {
        podziel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double a = Double.parseDouble(liczbaA.getText());
                double b = Double.parseDouble(liczbaB.getText());
                double dzielenie = a / b;
                if (b == 0)
                    JOptionPane.showMessageDialog(Kalkulator.this, "Błąd dzielenia", "zepsułeś!", JOptionPane.ERROR_MESSAGE);
                else
                    wynik.setText(Double.toString(dzielenie));
            }
        });
        dodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double a = Double.parseDouble(liczbaA.getText());
                double b = Double.parseDouble(liczbaB.getText());
                wynik.setText(Double.toString(a + b));
            }
        });
        odejmij.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double a = Double.parseDouble(liczbaA.getText());
                double b = Double.parseDouble(liczbaB.getText());
                wynik.setText(Double.toString(a - b));
            }
        });
        pomnoz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double a = Double.parseDouble(liczbaA.getText());
                double b = Double.parseDouble(liczbaB.getText());
                wynik.setText(Double.toString(a * b));
            }
        });
        pierwiastek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double a = Double.parseDouble(liczbaA.getText());
                double b = Double.parseDouble(liczbaB.getText());
                wynik.setText(Double.toString(pow(a,1/b)));
            }
        });
        potega.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double a = Double.parseDouble(liczbaA.getText());
                double b = Double.parseDouble(liczbaB.getText());
                wynik.setText(Double.toString(pow(a,b)));
            }
        });
        rad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double a = Double.parseDouble(liczbaA.getText());
                double odp = a * 2*Math.PI;
                wynik.setText(Double.toString(odp));
            }
        });
        binarnie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Integer a = Integer.parseInt(liczbaA.getText());
                wynik.setText(Integer.toBinaryString(a));
            }
        });

    }
    public static void main(String[] args) {
        JFrame ramka = new JFrame("Kalkulator");
        ramka.setContentPane(new Kalkulator().panel1);
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.pack();
        ramka.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setGroupingUsed(false);
        NumberFormatter numberFormatter = new NumberFormatter(numberFormat);

        liczbaA = new JFormattedTextField(numberFormatter);
        liczbaB = new JFormattedTextField(numberFormatter);
    }
}

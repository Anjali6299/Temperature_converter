import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;


class Main extends JFrame
{
    JTextField temp_input, temp_output;
    ButtonListener buttonListener;
    JLabel input_label,convert_label,output_label,img_label;
    JComboBox<String> comboBox1;
    JComboBox<String> comboBox2;

    public Main()
    {

        JFrame frame = new JFrame("Temperature Converter");
        JPanel panel=new JPanel();

        panel.setBounds(new Rectangle());
        panel.setBackground(Color.gray);
        panel.setSize(800,300);


        String[] s1 = {"Celsius", "Fahrenheit", "Kelvin"};
        comboBox1 = new JComboBox<>(s1);
        comboBox1.setBounds(670,40,90,20);
        add(comboBox1);

        String[] s2 = {"Celsius", "Fahrenheit", "Kelvin"};
        comboBox2 = new JComboBox<>(s2);
        comboBox2.setBounds(620,100,90,30);
        add(comboBox2);


        input_label=new JLabel("Temperature:");
        input_label.setFont(new Font("arial",Font.BOLD,17));
        input_label.setSize(270,20);
        input_label.setLocation(500,40);

        convert_label = new JLabel("Convert to: ");
        convert_label.setFont(new Font("arial",Font.BOLD,17));
        convert_label.setSize(270,20);
        convert_label.setLocation(500,110);

        temp_input = new JTextField(10);
        temp_input.setSize(40,20);
        temp_input.setLocation(620,40);

        temp_output = new JTextField(10);
        temp_output.setSize(120,20);
        temp_output.setLocation(620,210);

        output_label = new JLabel("Output:");
        output_label.setFont(new Font("arial",Font.BOLD,17));
        output_label.setSize(270,20);
        output_label.setLocation(500,210);


        JButton button =new JButton("Convert");
        button.setSize(80,30);
        button.setLocation(620,150);
        button.setBackground(Color.white);
        buttonListener = new ButtonListener();
        button.addActionListener(buttonListener);

        img_label = new JLabel("");
        img_label.setIcon(new ImageIcon("pic.png"));
        img_label.setBounds(780,40,200,250);


        frame.add(output_label);
        frame.add(convert_label);
        frame.add(input_label);
        frame.add(temp_input);
        frame.add(temp_output);
        frame.add(button);
        frame.add(comboBox1);
        frame.add(comboBox2);
        frame.add(img_label);

        frame.add(panel);
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        temp_output.setEditable(false);


    }

    private class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String temp = (String) comboBox1.getSelectedItem();
            String tempConvert = (String) comboBox2.getSelectedItem();

            assert temp != null;
            if(temp.equals("Celsius") && Objects.equals(tempConvert, "Fahrenheit")){
                double c = Double.parseDouble(temp_input.getText());
                double f = c*1.8+32;
                temp_output.setText(String.valueOf(f));
            }
            else if (temp.equals("Celsius") && Objects.equals(tempConvert, "Kelvin")) {
                double c = Double.parseDouble(temp_input.getText());
                double k = c+273;
                temp_output.setText(String.valueOf(k));
            }
            else {
                if (temp.equals("Celsius")) {
                    assert tempConvert != null;
                    if (tempConvert.equals("Celsius")) {
                        double c = Double.parseDouble(temp_input.getText());
                        temp_output.setText(String.valueOf(c));
                    }
                }
            }

            if(temp.equals("Fahrenheit") && Objects.equals(tempConvert, "Celsius")) {
                double f = Double.parseDouble(temp_input.getText());
                double c = (f - 32)*5/9;
                temp_output.setText(String.valueOf(c));
            }
            else if(temp.equals("Fahrenheit") && Objects.equals(tempConvert, "Kelvin")) {
                double f = Double.parseDouble(temp_input.getText());
                double k = (f - 32)*5/9 + 273.15;
                temp_output.setText(String.valueOf(k));
            }
            else {
                if(temp.equals("Fahrenheit")) {
                    assert tempConvert != null;
                    if (tempConvert.equals("Fahrenheit")) {
                        double f = Double.parseDouble(temp_input.getText());
                        temp_output.setText(String.valueOf(f));
                    }
                }
            }

            if(temp.equals("Kelvin") && Objects.equals(tempConvert, "Fahrenheit")) {
                double k = Double.parseDouble(temp_input.getText());
                double f = (k * (9/5)) - 459.67;
                temp_output.setText(String.valueOf(f));
            }
            else if (temp.equals("Kelvin") && Objects.equals(tempConvert, "Kelvin")) {
                double k = Double.parseDouble(temp_input.getText());
                temp_output.setText(String.valueOf(k));
            }
            else {
                if (temp.equals("Kelvin")) {
                    assert tempConvert != null;
                    if (tempConvert.equals("Celsius")) {
                        double k = Double.parseDouble(temp_input.getText());
                        double c = k - 273;
                        temp_output.setText(String.valueOf(c));
                    }
                }
            }
        }
    }

    public static void main(String[] args)
    {
        new Main();
    }
}
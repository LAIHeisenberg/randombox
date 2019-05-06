import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomNumberBox extends JFrame implements ActionListener {

    JPanel jPanel1;
    JPanel jPanel2;
    JPanel jPanel3;
    JPanel jPanel4;
    JPanel jPanel5;
    JPanel jPanel6;
    JPanel jPanel7;

    JLabel jLabel1 = new JLabel("一班组: ", SwingConstants.LEFT);
    JTextField[] jTextFields = new JTextField[10];
    JLabel jLabel2 = new JLabel("二班组: ",SwingConstants.LEFT);
    JLabel jLabel3 = new JLabel("上一班组", SwingConstants.LEFT);
    JLabel jLabel4 = new JLabel("上二班租", SwingConstants.LEFT);

    JTextArea jTextArea1 = new JTextArea();
    JTextArea jTextArea2 = new JTextArea();

    JButton jb1 = null;

    public RandomNumberBox(){

        jTextArea1.setEnabled(false);
        jTextArea2.setEnabled(false);

        for (int i=0; i<10; i++){
            jTextFields[i] = new JTextField("    ");
            jTextFields[i].setEnabled(false);
        }

        jPanel1 = new JPanel(new BorderLayout());
        jPanel1.add(jLabel1, BorderLayout.NORTH);
        jPanel1.setSize(100,20);
        jPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        jPanel2.add(jTextFields[0]);
        jPanel2.add(jTextFields[1]);
        jPanel2.add(jTextFields[2]);
        jPanel2.add(jTextFields[3]);
        jPanel2.add(jTextFields[4]);

        jPanel3 = new JPanel(new BorderLayout());

        jPanel3.add(jLabel2, BorderLayout.NORTH);

        jPanel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jPanel4.add(jTextFields[5]);
        jPanel4.add(jTextFields[6]);
        jPanel4.add(jTextFields[7]);
        jPanel4.add(jTextFields[8]);
        jPanel4.add(jTextFields[9]);

        jPanel5 = new JPanel(new BorderLayout());
        jb1 = new JButton("执行");
        jb1.addActionListener(this);
        jPanel5.add(jb1,BorderLayout.WEST);


        jPanel6 = new JPanel(new BorderLayout());
        jPanel6.add(jLabel3, BorderLayout.NORTH);
        jTextArea1.setColumns(13);
        jPanel6.add(jTextArea1);

        jPanel7 = new JPanel(new BorderLayout());
        jPanel7.add(jLabel4, BorderLayout.NORTH);
        jTextArea2.setColumns(13);
        jPanel7.add(jTextArea2);

        add(jPanel1);
        add(jPanel2);
        add(jPanel3);
        add(jPanel4);
        add(jPanel6);
        add(jPanel7);
        add(jPanel5,BorderLayout.SOUTH);

        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(Color.WHITE);

        setTitle("");
        setSize(200,300);
        setLocation(100,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        // 显示
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String[] arr = {"01","02","03","04","05","06","07","08","09","10"};
        Random random = new Random(371);
        Map<String,String> map = new HashMap<>(100);
        for (int i=0; i<10; i++){
            int f = random.nextInt();
            long r2 = System.currentTimeMillis() * f;
            map.put(String.valueOf(r2), arr[i]);
        }

        StringBuffer sbf1 = new StringBuffer();
        StringBuffer sbf2 = new StringBuffer();
        for (int i=0; i<5; i++){
            String str1 = jTextFields[i].getText().trim();
            String str2 = jTextFields[i].getText().trim();
            if (str1.equals("") || str2.equals("")){
                continue;
            }
            sbf1.append(jTextFields[i].getText()+",");
            sbf2.append(jTextFields[5+i].getText()+",");
        }
        if (sbf1.length() > 0){
            jTextArea1.setText(sbf1.substring(0, sbf1.length()-1));
        }
        jTextArea1.setEnabled(false);
        if (sbf2.length() > 0){
            jTextArea2.setText(sbf2.substring(0, sbf2.length()-1));
        }
        jTextArea2.setEnabled(false);

        int i=0;
        for (String s : map.values()){
            jTextFields[i].setText(s);
            arr[i++] = s;
        }

    }

}

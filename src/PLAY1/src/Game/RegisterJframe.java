package PLAY1.src.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class RegisterJframe extends JFrame implements MouseListener {



      static ArrayList<user> list1 = new ArrayList<>();
      static{  user u1 = new user("111", "123");
        user u2 = new user("222", "1234");
      list1.add(u1);list1.add(u2);}

    JDialog  jd= new JDialog();

    Button b1=new Button("CAPTCHA");
    String imagePatch="src\\PLAY1\\image\\login\\";



   String login ="登录按钮.png";
   String register ="注册按钮.png";

    JLabel jlbb2 =new JLabel();//register


    JTextField username = new JTextField();
    JPasswordField userPassword = new JPasswordField();
   // JTextField userPassword=new JTextField();
    JTextField userCode = new JTextField();
    JLabel jlb=new JLabel();

    String result=" ";

    public RegisterJframe() {

           buttonTwo();
           initB1();
        initJFrame();






            this.setVisible(true);
        }
    private void initJFrame(){
        this.setSize(488, 500);
        this.setDefaultCloseOperation(3);
        this.setTitle("sign up");

        this.setLayout(null);

        this.setLocationRelativeTo(null);

        ImageIcon Name = new ImageIcon("src\\PLAY1\\image\\login\\用户名.png");
        JLabel jlb1 = new JLabel(Name);
        jlb1.setBounds(40, 180, 100, 30);

      //  JPasswordField username = new JPasswordField();
       // username.setBounds(120, 180, 200, 30);



        this.getContentPane().add(jlb1);




        ImageIcon password = new ImageIcon("src\\PLAY1\\image\\login\\密码.png");
        JLabel jlbp = new JLabel(password);
        jlbp.setBounds(40, 220, 100, 30);

        this.getContentPane().add(jlbp);

       // JPasswordField userPassword = new JPasswordField();
        userPassword.setBounds(120, 220, 200, 30);
        this.getContentPane().add(userPassword);

        //temp1.replaceAll();
       // this.getContentPane().add(userPassword);


        //JTextField username = new JTextField();
        username.setBounds(120, 180, 200, 30);
        this.getContentPane().add(username);






        ImageIcon code = new ImageIcon("D:\\play\\src\\PLAY1\\image\\login\\验证码.png");
        JLabel jlbc = new JLabel(code);
        jlbc.setBounds(40, 260, 100, 30);
        this.getContentPane().add(jlbc);
        JTextField userCode = new JTextField();
        userCode.setBounds(120, 260, 100, 30);
        this.getContentPane().add(userCode);





        ImageIcon im = new ImageIcon("D:\\play\\src\\PLAY1\\image\\register\\background.png");
        JLabel jlb = new JLabel(im);
        jlb.setBounds(0, 0, 470, 500);
        this.getContentPane().add(jlb);

    }
   private void initB1(){


       b1.setBounds(250, 260, 100, 30);
       b1.addMouseListener(this);
       this.getContentPane().add(b1);





   }






    private void buttonTwo(){





        ImageIcon buttonLogin =new ImageIcon(imagePatch+login);
        ImageIcon buttonRegister =new ImageIcon(imagePatch+register);


      JLabel jlb1=new JLabel(buttonLogin);
        jlb1.addMouseListener(this);
        jlb1.setBounds(120, 300, 100, 30);

        jlb1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                Object source = e.getSource();
                if (source == jlb1) {
                  //  getContentPane().removeAll();
                    login = "sign up.png";
                    String name=username.getText();
                    char[] password=userPassword.getPassword();
                    String passwd=password.toString();


                   boolean flag = judgeAcount(list1, name, passwd);
                    if (flag == true) {
                        setVisible(false);
                        new GameJframe();
                    }else{
                        System.out.println("NOOO");
                    }

                /* boolean flagC=  judgeCode(userCode.getText(), jlb.getText());
                 if(flag){
                     System.out.println("name or password true");
                 }else{
                     System.out.println("name or password false");
                 }

                if(flagC){
                     System.out.println("CAPTCHA true");
                 }else{
                    System.out.println("CAPTCHA FALSE");
                 }*/

                    // initB1();buttonTwo();initJFrame();
                    System.out.println("pull");
                }
                //  if(flag){setVisible(false);new GameJframe();}


            }






            @Override
            public void mouseReleased(MouseEvent e) {

            }





            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
           /*     Object source = e.getSource();
                if (source == jlb1){
                System.out.println("untie");
                getContentPane().removeAll();
                login="登录按钮.png";
                initB1();buttonTwo();initJFrame();}*/
            }
        });







      jlbb2 =new JLabel(buttonRegister);
        jlbb2.addMouseListener(this);
        jlbb2.setBounds(250 , 300, 100, 30);
        jlbb2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                    Object source=e.getSource();


                       setVisible(false);new LoginJframe();

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.getContentPane().add(jlbb2);
        this.getContentPane().add(jlb1);
        this.getContentPane().repaint();
        this.getContentPane().repaint();
    }



















        public String getCode () {

            char[] arr1 = new char[62];
            for (int i = 0; i < arr1.length; i++) {
                if (i < 26) {
                    arr1[i] = (char) ('a' + i);
                } else if (i >= 26 && i < 52) {
                    arr1[i] = (char) ('A' + i - 26);
                } else if (i >= 52) {
                    arr1[i] = (char) (i - 52 + 48);
                }
            }



            String code = "";
            Random r = new Random();
            StringBuilder sb = new StringBuilder(code);
            for (int i = 0; i < 5; i++) {


                int rn = r.nextInt(62);
                char temp = arr1[i];
                arr1[i] = arr1[rn];
                arr1[rn] = temp;
            }
            for (int i = 0; i < 5; i++) {
                int rn = r.nextInt(62);
                sb.append(arr1[rn]);


            }


            return sb.toString();
        }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
         Object source=e.getSource();
                  if(source==jlbb2){
                      getContentPane().removeAll();
                      register="注册按下.png";
                      initB1();buttonTwo();initJFrame();


    }}

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object source = e.getSource();
        if (source == b1)
        {result=getCode();
            JDialog  jd= new JDialog();
            jd.setSize(80,60);
            jd.setAlwaysOnTop(true);
            jd.setLocation(750,450);


            JLabel jlb=new JLabel();
            jlb.setText(result);

            jd.getContentPane().add(jlb);
            jlb.setSize(100,80);
            jd.setAlwaysOnTop(true);

            jd.setVisible(true);

        }



    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object source=e.getSource();
        if(source==jlbb2){
            getContentPane().removeAll();
            register="注册按钮.png";
            initB1();buttonTwo();initJFrame();

        }
        if (source == b1){getContentPane().remove(jd);}
    }


       /* @Override
        public void actionPerformed (ActionEvent e){
            Object source = e.getSource();
            if (source == b1);
             {String result=getCode();
                 JDialog  jd= new JDialog();
                 jd.setSize(80,60);
                 jd.setAlwaysOnTop(true);
                 jd.setLocation(750,400);

                 JLabel jlb=new JLabel();
                 jlb.setText(result);
                jd.getContentPane().add(jlb);
               jlb.setSize(100,80);

                 jd.setVisible(true);







            }


        }*/
       private boolean judgeAcount(ArrayList<user>list,String name,String password){
           for (int i = 0; i <list.size() ; i++) {
             if(list.get(i).getName().equalsIgnoreCase(name)){ return true;}

           }
           for (int i = 0; i <list.size() ; i++) {
               if(list.get(i).getPasswd().equalsIgnoreCase(password)){return true;}

           }

        return false;
       }
       private boolean judgeCode(String code,String resultcode){
           if(code.equals(resultcode)){return true;}

           return false;
       }
    }











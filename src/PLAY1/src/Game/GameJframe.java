package PLAY1.src.Game;

import javax.lang.model.element.ModuleElement;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLOutput;
import java.util.Random;

public class GameJframe extends JFrame implements KeyListener{

    int[][] arr2 = new int[4][4];
    int[] arr1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    int number=0;
    int[][] win = new  int[][]{
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };

    int x = 0;
    int y = 0;

    int rd =1;
    String imagenPatch="src\\PLAY1\\image\\animal\\animal"+rd+"\\";
    String imagenBackPatch="src\\PLAY1\\image\\";


    JMenuItem changeAnimal = new JMenuItem("animal");
    JMenuItem changeWoman =new JMenuItem("girl");
    JMenuItem changeDeport =new JMenuItem("deporte");




    public GameJframe() {


        initJFrame();

        initJMenu();

        initArr();

        initImage();



        setVisible(true);


    }

    private void initJMenu() {




        JMenuBar jmb = new JMenuBar();

        JMenu function = new JMenu("funcion");
        JMenu about = new JMenu("con nosotros");

        JMenuItem replayItem = new JMenuItem("nuevo juego");
        JMenuItem reloginItem = new JMenuItem("registro");
        JMenuItem closeItem = new JMenuItem("cerra juego");
        JMenu change =new JMenu("cambia imagen");

        changeAnimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               initArr();
                Object source=e.getSource();
                if(source==changeAnimal){
                Random r= new Random();
                rd =r.nextInt(8)+1;initImage();
               imagenPatch="src\\PLAY1\\image\\animal\\animal"+rd+"\\";}
                initImage();

            }
        });
        changeDeport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initArr();
                Object source=e.getSource();
                if(source==changeDeport){
                Random r= new Random();
                 rd =r.nextInt(10)+1;initImage();
                imagenPatch="src\\PLAY1\\image\\sport\\sport"+rd+"\\";
                   initImage();


            }}
        });
        changeWoman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initArr();
                Object source=e.getSource();
                if(source==changeWoman){
                Random r= new Random();
                rd =r.nextInt(13)+1;initImage();
                imagenPatch="src\\PLAY1\\image\\girl\\girl"+rd+"\\";
                    initImage();

            }}
        });







         replayItem.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
             Object source =  e.getSource();
             if(source==replayItem){number=0;initArr();initImage();
                 System.out.println(rd);
             }
             }
         });
        reloginItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source =  e.getSource();
                setVisible(false);new RegisterJframe();
            }
        });
        closeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source =  e.getSource();
                if(source==closeItem){System.exit(0);}
            }
        });
        JMenuItem acountItem = new JMenuItem("cuenta");
        acountItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source =  e.getSource();
                if(source==acountItem){JDialog dialog =new JDialog();ImageIcon acount=new ImageIcon(imagenBackPatch+"about.png");
                    JLabel jlbaq=new JLabel(acount);
                    jlbaq.setBounds(0,0,100,58);dialog.getContentPane().add(jlbaq);
                dialog.setSize(100,50);dialog.setAlwaysOnTop(true);dialog.setLocationRelativeTo(null);
                dialog.setModal(true);dialog.setVisible(true);}
            }
        });








        jmb.add(function);
        jmb.add(about);

        function.add(replayItem);
        function.add(reloginItem);
        function.add(closeItem);
        function.add(change);
        change.add(changeAnimal);
        change.add(changeWoman);
        change.add(changeDeport);


        about.add(acountItem);


        this.setJMenuBar(jmb);
    }


    private void initJFrame() {
        this.setSize(603, 680);
        this.setTitle("juego puzzle v0.1");
        this.setAlwaysOnTop(true);

        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(3);

        this.setLayout(null);


        this.addKeyListener(this);

    }





    private void initImage() {






        this.getContentPane().removeAll();
        boolean flag= judge();
        if(flag){ImageIcon wim=new ImageIcon(imagenBackPatch+"win.png");
            JLabel jlbw=new JLabel(wim);
            jlbw.setBounds(200,200,200,200);
            this.getContentPane().add(jlbw);
        }
        JLabel jlbn=new JLabel("pasos:"+number);
        jlbn.setBounds(50,50,100,20);
        this.getContentPane().add(jlbn);







        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = arr2[i][j];
                ImageIcon ic = new ImageIcon(imagenPatch+ num + ".jpg");
                JLabel jlb = new JLabel(ic);
                jlb.setBounds(j * 105 + 83, i * 105 + 134, 105, 105);
                jlb.setBorder(new BevelBorder(1));
                this.getContentPane().add(jlb);

            }


        }
        ImageIcon back = new ImageIcon(imagenBackPatch+"background.png");
        JLabel jb = new JLabel(back);
        jb.setBounds(40, 40, 508, 560);
        jb.setBorder(new BevelBorder(1));
        this.getContentPane().add(jb);
        //刷新一下界面
        this.getContentPane().repaint();

    }





    private void initArr() {


        Random r = new Random();

        for (int i = 0; i < arr1.length; i++) {
            int rn = r.nextInt(16);
            int temp = arr1[i];
            arr1[i] = arr1[rn];
            arr1[rn] = temp;

        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
                arr2[i / 4][i % 4] = arr1[i];



        }

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65){this.getContentPane().removeAll();
            ImageIcon imi=new ImageIcon(imagenPatch+"all.jpg");
            JLabel jlb=new JLabel(imi);
            jlb.setBounds(40,70,508,560);
            this.getContentPane().add(jlb);


            }ImageIcon back = new ImageIcon(imagenBackPatch+"background.png");
        JLabel jb = new JLabel(back);
        jb.setBounds(40, 40, 508, 560);
        jb.setBorder(new BevelBorder(1));
        this.getContentPane().add(jb);
        this.getContentPane().repaint();























    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(judge()){return;}







        int code = e.getKeyCode();
        if (code == 37) {
            System.out.println("izquierda");
            if(y==0){return;}
            arr2[x][y] = arr2[x][y-1];
            arr2[x][y-1] =0 ;
            y--;
            number++;
           initImage();
        }
        if (code == 38) {
            System.out.println("arriba");
            if(x==0){return;}
            arr2[x][y] = arr2[x-1][y];
            arr2[x-1][y] = 0;
            x--;
            number++;
            initImage();
        }
        if (code == 39) {
            System.out.println("derecha");
            if(y==3){return;}
            arr2[x][y] = arr2[x][y+1];
            arr2[x][y+1] = 0;
            y++;
            number++;
         initImage();
        }
        if (code == 40) {
            System.out.println("abajo");
            if(x==3){return;}
            arr2[x][y] = arr2[x+1][y];
            arr2[x+1][y] = 0;
            x++;
            number++;
           initImage();
        } else if(code==65){initImage();}


        if (code == 87){
            arr2=new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
            };
           initImage();

        }







            
        }

     private boolean judge(){
         for (int i = 0; i < arr2.length ; i++) {
             for (int j = 0; j < arr2[i].length; j++) {
                 int temp=0;
             if( arr2[i][j]!=win[i][j]){return false;}else{temp++;}
             }
         }return true;
     }




}





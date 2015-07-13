/**
 * 
 */

//Jose Ramon Corona Boch
//Samuel Diaz
//Julio Dieguea Ochoa
//13/7/15
//HDT1


import javax.swing.JFrame;



public final class main extends JFrame {

    private final int OFFSET = 30;

    public main() {
        InitUI();
    }

    public void InitUI() {
        gui board = new gui();
        add(board);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 200);
        setLocationRelativeTo(null);
        setTitle("Radio_Sonica");
    }

    public static void main(String[] args) {
        main v = new main();
        v.setVisible(true);
    }
}

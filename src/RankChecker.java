import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;


/**
 * Simple program to check the range of CS:GO ranks
 * Created by Mauk on 3/11/2017.
 */
public class RankChecker extends JFrame{

    private String[] rankCodes = new String[18];
    private JButton[] rankButtons = new JButton[18];

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            RankChecker rc = new RankChecker();
            rc.setVisible(true);
        });
    }

    private RankChecker() {
        initUI();
    }

    private String[] getAllRankCodes() {

        rankCodes[0] = ("1-Silver_1");
        rankCodes[1] = ("2-Silver_2");
        rankCodes[2] = ("3-Silver_3");
        rankCodes[3] = ("4-Silver_4");
        rankCodes[4] = ("5-Silver_Elite");
        rankCodes[5] = ("6-Silver_Elite_Master");
        rankCodes[6] = ("7-Gold_Nova_1");
        rankCodes[7] = ("8-Gold_Nova_2");
        rankCodes[8] = ("9-Gold_Nova_3");
        rankCodes[9] = ("10-Gold_Nova_Master");
        rankCodes[10] = ("11-Master_Guardian_1");
        rankCodes[11] = ("12-Master_Guardian_2");
        rankCodes[12] = ("13-Master_Guardian_Elite");
        rankCodes[13] = ("14-Distinguished_Master_Guardian");
        rankCodes[14] = ("15-Legendary_Eagle");
        rankCodes[15] = ("16-Legendary_Eagle_Master");
        rankCodes[16] = ("17-Supreme_Master_First_Class");
        rankCodes[17] = ("18-Global_Elite");

        return rankCodes;
    }

//    private void createMenuBar() {
//
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        JMenuBar menuBar = new JMenuBar();
//        menuBar.setPreferredSize(new Dimension(355,20));
//
//        JMenu file = new JMenu("File");
//
//        JMenuItem eMenuItem = new JMenuItem("Exit");
//        eMenuItem.setToolTipText("Exit application");
//        eMenuItem.addActionListener((ActionEvent event) -> {
//            System.exit(0);
//        });
//
//        file.add(eMenuItem);
//
//        JMenu help = new JMenu("Help");
//
//
//        menuBar.add(file);
//
//        setJMenuBar(menuBar);
//
//    }

    private void placeRankButtons(String[] imageCodes) {
        for (int i=0; i<imageCodes.length; i++) {
            JButton rankButton = new JButton();
            rankButton.setFocusable(false);
            rankButton.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,0), 2));
            rankButton.setContentAreaFilled(false);
            ImageIcon rankImage = resizeRankImage(new ImageIcon(getClass().getClassLoader().getResource(imageCodes[i] + ".png")));
            rankButton.setIcon(rankImage);
            final int rankID = i;
            rankButton.addActionListener((ActionEvent event) -> {
                String[] code = imageCodes[rankID].split("-");
                processCode(code);
            });
            rankButtons[i] = rankButton;
        }

        createLayout(rankButtons);
    }

    private void processCode(String[] code) {
        int codeNum = Integer.parseInt(code[0]);
        int minRank = codeNum-6;
        int maxRank = codeNum+6;

        for (int i = 0; i < 18; i++) {
            if (i == codeNum-1) {
                rankButtons[i].setBorder(BorderFactory.createLineBorder(Color.BLUE,2));
            } else if (i > minRank-1 && i < maxRank-1) {
                rankButtons[i].setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
            } else {
                rankButtons[i].setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            }
        }

    }

    private void initUI() {

//        createMenuBar();

        ImageIcon csgoIcon = new ImageIcon(getClass().getClassLoader().getResource("CSGOicon.png"));
        setIconImage(csgoIcon.getImage());

        String[] rankCodes = getAllRankCodes();
        placeRankButtons(rankCodes);

        setTitle("CS:GO - RankChecker");
        setSize(355,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void createLayout(JButton[] rankButtons) {
        final ImageIcon backgroundImage = resizeBackgroundImage(new ImageIcon(getClass().getClassLoader().getResource("background-image.jpg")));
        JFrame frame = new JFrame();
        frame.setContentPane(new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, this);
            }
        });



        setContentPane(new BackgroundImage(backgroundImage.getImage()));
        JPanel pane = (JPanel) getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);


        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setVerticalGroup(gl.createParallelGroup()
                .addGroup(gl.createSequentialGroup()
                        .addComponent(rankButtons[0])
                        .addComponent(rankButtons[1])
                        .addComponent(rankButtons[2])
                        .addComponent(rankButtons[3])
                        .addComponent(rankButtons[4])
                        .addComponent(rankButtons[5]))
                .addGroup(gl.createSequentialGroup()
                        .addComponent(rankButtons[6])
                        .addComponent(rankButtons[7])
                        .addComponent(rankButtons[8])
                        .addComponent(rankButtons[9])
                        .addComponent(rankButtons[10])
                        .addComponent(rankButtons[11]))
                .addGroup(gl.createSequentialGroup()
                        .addComponent(rankButtons[12])
                        .addComponent(rankButtons[13])
                        .addComponent(rankButtons[14])
                        .addComponent(rankButtons[15])
                        .addComponent(rankButtons[16])
                        .addComponent(rankButtons[17]))
        );


        gl.setHorizontalGroup(gl.createSequentialGroup()
                        .addGroup(gl.createParallelGroup()
                                .addComponent(rankButtons[0])
                                .addComponent(rankButtons[1])
                                .addComponent(rankButtons[2])
                                .addComponent(rankButtons[3])
                                .addComponent(rankButtons[4])
                                .addComponent(rankButtons[5]))
                        .addGroup(gl.createParallelGroup()
                                .addComponent(rankButtons[6])
                                .addComponent(rankButtons[7])
                                .addComponent(rankButtons[8])
                                .addComponent(rankButtons[9])
                                .addComponent(rankButtons[10])
                                .addComponent(rankButtons[11]))
                        .addGroup(gl.createParallelGroup()
                                .addComponent(rankButtons[12])
                                .addComponent(rankButtons[13])
                                .addComponent(rankButtons[14])
                                .addComponent(rankButtons[15])
                                .addComponent(rankButtons[16])
                                .addComponent(rankButtons[17]))
        );

        pack();

    }

    public ImageIcon resizeBackgroundImage(ImageIcon icon) {

        Image tempImage = icon.getImage();
        Image resizedImage = tempImage.getScaledInstance(355, 350, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);

    }

    public ImageIcon resizeRankImage(ImageIcon icon) {

        Image tempImage = icon.getImage();
        Image resizedImage = tempImage.getScaledInstance(100,40, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);

    }

}

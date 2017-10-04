package SpriteMaker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuHandler {

    public MenuHandler() {

    }

    public MenuHandler(JMenuBar menubar, JFrame frame, Application apl, IOHandler io) {
        this.setMenubar(menubar, frame, apl, io);
    }

    public void setMenubar(JMenuBar menubar, JFrame frame, Application apl, IOHandler io) {

        // Help Menu
        JMenu HelpMenu = new JMenu("Help");
        JMenuItem AboutWin = new JMenuItem("About");

        AboutWin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,
                        "Sprite Creator 4\n"
                                + "Programmed by Athlon98.\n"
                                + "\n"
                                + "marc0tjevp@gmail.com\n"
                                + "marcovp.nl\n"
                                + "\n"
                                + "Special Thanks to:\n"
                                + "EnterBrain\n"
                                + "Circle\n"
                                + "Famitsu\n"
                                + "Holder\n"
                                + "Axerax\n"
                                + "Ying\n"
                                + "Zac Ray");
            }
        });

        HelpMenu.add(AboutWin);

        // Save Menu
        JMenu SaveMenu = new JMenu("Save");

        JMenuItem SaveMale = new JMenuItem("Save Male");
        SaveMale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                io.save(false, "Male");
            }
        });
        SaveMenu.add(SaveMale);

        JMenuItem SaveFemale = new JMenuItem("Save Female");
        SaveFemale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                io.save(false, "Female");
            }
        });
        SaveMenu.add(SaveFemale);

        JMenuItem SaveAllItem = new JMenuItem("Save All");
        SaveAllItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                io.save(true, "");
            }
        });
        SaveMenu.add(SaveAllItem);

        // Reset Menu
        JMenu ResetMenu = new JMenu("Reset");

        JMenuItem ReloadMale = new JMenuItem("Reset Male");
        ReloadMale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(frame, "Reset Male?", "Reset Male", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    apl.ReloadAll(false, "Male");
                    ImgHandler.doneWithFirstBoard = false;
                }
            }
        });
        ResetMenu.add(ReloadMale);

        JMenuItem ReloadFemale = new JMenuItem("Reset Female");
        ReloadFemale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(frame, "Reset Female?", "Reset Female", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    apl.ReloadAll(false, "Female");
                    ImgHandler.doneWithFirstBoard = false;
                }
            }
        });
        ResetMenu.add(ReloadFemale);

        JMenuItem ReloadAllItem = new JMenuItem("Reset All");
        ReloadAllItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(frame, "Reset Male and Female?", "Reset Both?", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    apl.ReloadAll(true, "");
                    ImgHandler.doneWithFirstBoard = false;
                }
            }
        });
        ResetMenu.add(ReloadAllItem);

        // File Menu
        JMenu FileMenu = new JMenu("File");

        JMenuItem ExitItem = new JMenuItem("Exit");
        ExitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit?", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    //TimerHandler.displayTimer.stop();
                    apl.destroy();
                }
            }
        });
        FileMenu.add(ExitItem);

        // Set MenuHandler
        menubar.setVisible(true);
        menubar.setOpaque(true);
        menubar.add(FileMenu);
        menubar.add(SaveMenu);
        menubar.add(ResetMenu);
        menubar.add(HelpMenu);
    }
}

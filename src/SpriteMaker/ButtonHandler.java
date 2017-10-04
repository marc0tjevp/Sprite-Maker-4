package SpriteMaker;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolTip;


public class ButtonHandler {

    public ButtonHandler() {

    }

    public void BodyButton(final String label, int x, int y, int sx, int sy) {
        JButton butt = new JButton(label);
        butt.setBounds(x, y, sx, sy);
        butt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Application.PickSex.equals("Male"))
                    Application.MTypeBody = label;
                if (Application.PickSex.equals("Female"))
                    Application.FTypeBody = label;
                Application.apl.repaint();
            }
        });
        Application.apl.add(butt);
    }

    public void PartButtons(int x, int y, int sx, int sy, final String label) {
        JButton butt = new JButton(label);
        butt.setBounds(x, y, sx, sy);
        Application.apl.add(butt);
        butt.addActionListener(e -> {
            ChangeLabel(label);
            ImgHandler.doneWithFirstBoard = true;
        });
    }

    public void ArrowKeys(int x, int y, int sx, int sy, final int behold, Image iconImage) {
        JButton butt = new JButton();
        butt.setBounds(x, y, sx, sy);
        butt.setIcon(new ImageIcon(iconImage));
        Application.apl.add(butt);
        butt.addActionListener(e -> TimerHandler.SetIconImageFrameHold = behold);
    }

    private void ChangeLabel(String label) {
        if (Application.PickSex.equals("Male"))
            Application.MObjectSelect = label;
        else
            Application.FObjectSelect = label;
        Application.ObjectSelect = label;
    }

    public void addColorJButton(int x, int y, final Color color, final Color TextColor, final String scolor) {
        final JButton butt = new JButton() {
            private static final long serialVersionUID = 1L;

            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(color);
                tip.setForeground(TextColor);
                return tip;
            }
        };

        butt.setBounds(x, y, Application.ColorButtonSize, Application.ColorButtonSize);
        butt.setBackground(color);
        Application.apl.add(butt);
        butt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                butt.setToolTipText(scolor + " Human " + Application.PickSex);
            }
        });

        butt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Application.PickSex.equals("Male"))
                    if (!Application.MTypeBody.equals(scolor))
                        Application.MTypeBody = scolor;
                if (Application.PickSex.equals("Female"))
                    if (!Application.FTypeBody.equals(scolor))
                        Application.FTypeBody = scolor;
                //	ImgHandler.AllSplit = Application.IH.StackImage();
                Application.apl.repaint();
            }
        });

        Application.tempColorButtonSize += Application.ColorButtonSize;

    }
}

package SpriteMaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class TimerHandler {

    public Timer displayTimer = null;
    public Timer displayTimer2 = null;
    public Timer displayTimer3 = null;
    public int SetIconImageFrame = 5, SetIconImageFrameInc = 4;
    public static int SetIconImageFrameHold = 5;

    public TimerHandler() {

        ActionListener listener2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Application.MisGhost && Application.PickSex.equals("Male") || Application.FisGhost && Application.PickSex.equals("Female")) {
                    Application.GhostC.setSelected(true);
                    Application.OpacitySlider.setEnabled(true);
                    if (Application.PickSex.equals("Female"))
                        Application.OpacitySlider.setValue((int) (Application.Fopacity * 100));
                    else if (Application.PickSex.equals("Male"))
                        Application.OpacitySlider.setValue((int) (Application.Mopacity * 100));
                }

                if (!Application.MisGhost && Application.PickSex.equals("Male") || !Application.FisGhost && Application.PickSex.equals("Female")) {
                    Application.GhostC.setSelected(false);
                    Application.OpacitySlider.setEnabled(false);
                }

                if (Application.MHaveBody && Application.PickSex.equals("Male") || Application.FHaveBody && Application.PickSex.equals("Female"))
                    Application.HaveBodyC.setSelected(true);
                if (!Application.MHaveBody && Application.PickSex.equals("Male") || !Application.FHaveBody && Application.PickSex.equals("Female"))
                    Application.HaveBodyC.setSelected(false);
            }
        };

        displayTimer2 = new Timer(50, listener2);
        displayTimer2.start();

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Application.NSplitFrame == 8)
                    Application.NSplitFrame += Application.NSplitFrameInc;
                else {
                    Application.NSplitFrame = 8;
                    Application.NSplitFrameInc = -Application.NSplitFrameInc;
                }
            }
        };

        displayTimer = new Timer(200, listener);
        displayTimer.start();

        ActionListener listener3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (SetIconImageFrame == SetIconImageFrameHold)
                    SetIconImageFrame += SetIconImageFrameInc;
                else {
                    SetIconImageFrame = SetIconImageFrameHold;
                    SetIconImageFrameInc = -SetIconImageFrameInc;
                }

                try {
                    Application.frame.setIconImage(ImgHandler.bi[SetIconImageFrame]);
                } catch (NullPointerException NPE) {
                    //What?? Ignore and continue
                }
            }
        };

//        displayTimer3 = new Timer(200, listener3);
//        displayTimer3.start();
    }
}

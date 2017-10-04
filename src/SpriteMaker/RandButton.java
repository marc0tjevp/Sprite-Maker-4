package SpriteMaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;

public class RandButton {

    public static JButton randButt;
    private int mbody, mhair, mhairop, mmantle, macce1, macce2, moption, mtail, mears, mface, mbangs, marmor;
    private int mbodycolor, mhaircolor, mhairopcolor, mmantlecolor, macce1color, macce2color, moptioncolor, mtailcolor, mearscolor, mfacecolor, mbangscolor, marmorcolor;
    private int fbody, fhair, fhairop, fmantle, facce1, facce2, foption, ftail, fears, fface, fbangs, farmor;
    private int fbodycolor, fhaircolor, fhairopcolor, fmantlecolor, facce1color, facce2color, foptioncolor, ftailcolor, fearscolor, ffacecolor, fbangscolor, farmorcolor;

    public RandButton() {
        randButt = new JButton("Random");
        randButt.setBounds(Application.ColorButtonX, Application.ColorButtonY + 250, 218, 20);
        randButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Application.PickSex.equals("Male")) {
                    mbody = 0;
                    mhair = 0;
                    mhairop = 0;
                    mmantle = 0;
                    macce1 = 0;
                    macce2 = 0;
                    moption = 0;
                    mtail = 0;
                    mears = 0;
                    mface = 0;
                    mbangs = 0;
                    marmor = 0;
                    mbodycolor = 0;
                    mhaircolor = 0;
                    mhairopcolor = 0;
                    mmantlecolor = 0;
                    macce1color = 0;
                    macce2color = 0;
                    moptioncolor = 0;
                    mtailcolor = 0;
                    mearscolor = 0;
                    mfacecolor = 0;
                    mbangscolor = 0;
                    marmorcolor = 0;
                    Application.MTypeBody = ImgHandler.cbody[randInt(0, 100) >= 10 ? randInt(0, 7) : randInt(0, IApplication.ImageBases - 1)];
                    mbodycolor = randInt(1, IApplication.usedColors);
                    mbody = randInt(1, Application.mbodyI);
                    Application.Mimg[Application.Body_L1] = Application.IH.Male_Body[mbodycolor][mbody];
                    Application.Mtype[Application.Body] = Integer.toString(mbodycolor) + Integer.toString(mbody) + "_";
                    mhaircolor = randInt(1, IApplication.usedColors);
                    mhair = randInt(1, Application.mhairI);
                    Application.Mimg[Application.Hair_L2] = Application.IH.Male_Hair[mhaircolor][mhair][2];
                    Application.Mimg[Application.Hair_L1] = Application.IH.Male_Hair[mhaircolor][mhair][1];
                    Application.Mtype[Application.Hair] = Integer.toString(mhaircolor) + Integer.toString(mhair) + "_";
                    if (randInt(1, 100) >= 60) //40% chance
                    {
                        if (randInt(1, 100) >= 15) //85% chance that if used it will be the same color as the hair
                            mhairopcolor = mhaircolor;
                        else
                            mhairopcolor = randInt(1, IApplication.usedColors);
                        mhairop = randInt(1, Application.mhairopI);
                        Application.Mimg[Application.Hairop_L2] = Application.IH.Male_Hairop[mhairopcolor][mhairop][2];
                        Application.Mimg[Application.Hairop_L1] = Application.IH.Male_Hairop[mhairopcolor][mhairop][1];
                        Application.Mtype[Application.Hairop] = Integer.toString(mhairopcolor) + Integer.toString(mhairop) + "_";
                    } else {
                        Application.Mimg[Application.Hairop_L2] = Application.AllBlank;
                        Application.Mimg[Application.Hairop_L1] = Application.AllBlank;
                        Application.Mtype[Application.Hairop] = "00_";
                    }
                    if (randInt(1, 100) >= 80) //20% chance
                    {
                        if (randInt(1, 100) >= 75) //25% chance when selected it will be the same color as the body
                            mmantlecolor = mbodycolor;
                        else if (randInt(1, 100) >= 85) //15% chance to match hair color if matching body fails
                            mmantlecolor = mhaircolor;
                        else
                            mmantlecolor = randInt(1, IApplication.usedColors);
                        mmantle = randInt(1, Application.mantleI);
                        Application.Mimg[Application.Mantle_L2] = Application.IH.Male_Mantle[mmantlecolor][mmantle][2];
                        Application.Mimg[Application.Mantle_L1] = Application.IH.Male_Mantle[mmantlecolor][mmantle][1];
                        Application.Mtype[Application.Mantle] = Integer.toString(mmantlecolor) + Integer.toString(mmantle) + "_";
                    } else {
                        Application.Mimg[Application.Mantle_L2] = Application.AllBlank;
                        Application.Mimg[Application.Mantle_L1] = Application.AllBlank;
                        Application.Mtype[Application.Mantle] = "00_";
                    }
                    if (randInt(1, 100) >= 80) //20% chance
                    {
                        if (randInt(1, 100) >= 30) //70% chance for acce1 to match hair color
                            macce1color = mhaircolor;
                        else if (randInt(1, 100) >= 50) //50% chance to match body if hair match fails
                            macce1color = mbodycolor;
                        else
                            macce1color = randInt(1, IApplication.usedColors);
                        macce1 = randInt(1, Application.macce1I);
                        Application.Mimg[Application.Acce1_L2] = Application.IH.Male_Acce1[macce1color][macce1][2];
                        Application.Mimg[Application.Acce1_L1] = Application.IH.Male_Acce1[macce1color][macce1][1];
                        Application.Mtype[Application.Acce1] = Integer.toString(macce1color) + Integer.toString(macce1) + "_";
                    } else {
                        Application.Mimg[Application.Acce1_L2] = Application.AllBlank;
                        Application.Mimg[Application.Acce1_L1] = Application.AllBlank;
                        Application.Mtype[Application.Acce1] = "00_";
                    }
                    if (randInt(1, 100) >= 80) //20% chance
                    {
                        macce2color = randInt(1, IApplication.usedColors);
                        macce2 = randInt(1, Application.acce2I);
                        Application.Mimg[Application.Acce2_L1] = Application.IH.Male_Acce2[macce2color][macce2][2];
                        Application.Mtype[Application.Acce2] = Integer.toString(macce2color) + Integer.toString(macce2) + "_";
                    } else {
                        Application.Mimg[Application.Acce2_L1] = Application.AllBlank;
                        Application.Mtype[Application.Acce2] = "00_";
                    }
                    if (randInt(1, 100) >= 90) //10% chance
                    {
                        moptioncolor = randInt(1, IApplication.usedColors);
                        moption = randInt(1, Application.optionI);
                        Application.Mimg[Application.Option_L2] = Application.IH.Male_Option[moptioncolor][moption][2];
                        Application.Mimg[Application.Option_L1] = Application.IH.Male_Option[moptioncolor][moption][1];
                        Application.Mtype[Application.Option] = Integer.toString(moptioncolor) + Integer.toString(moption) + "_";
                    } else {
                        Application.Mimg[Application.Option_L2] = Application.AllBlank;
                        Application.Mimg[Application.Option_L1] = Application.AllBlank;
                        Application.Mtype[Application.Option] = "00_";
                    }
                    if (randInt(1, 100) >= 93) //7% chance
                    {
                        mtailcolor = randInt(1, IApplication.usedColors);
                        mtail = randInt(1, Application.tailI);
                        Application.Mimg[Application.Tail_L2] = Application.IH.Male_Tail[mtailcolor][mtail][1];
                        Application.Mimg[Application.Tail_L1] = Application.IH.Male_Tail[mtailcolor][mtail][3];
                        Application.Mtype[Application.Tail] = Integer.toString(mtailcolor) + Integer.toString(mtail) + "_";
                    } else {
                        Application.Mimg[Application.Tail_L2] = Application.AllBlank;
                        Application.Mimg[Application.Tail_L1] = Application.AllBlank;
                        Application.Mtype[Application.Tail] = "00_";
                    }
                    if (randInt(1, 100) >= 93) //7% chance
                    {
                        mearscolor = randInt(1, IApplication.usedColors);
                        mears = randInt(1, Application.earsI);
                        Application.Mimg[Application.Ears_L3] = Application.IH.Male_Ears[mearscolor][mears][2];
                        Application.Mimg[Application.Ears_L2] = Application.IH.Male_Ears[mearscolor][mears][1];
                        Application.Mimg[Application.Ears_L1] = Application.IH.Male_Ears[mearscolor][mears][3];
                        Application.Mtype[Application.Ears] = Integer.toString(mearscolor) + Integer.toString(mears) + "_";
                    } else {
                        Application.Mimg[Application.Ears_L3] = Application.AllBlank;
                        Application.Mimg[Application.Ears_L2] = Application.AllBlank;
                        Application.Mimg[Application.Ears_L1] = Application.AllBlank;
                        Application.Mtype[Application.Ears] = "00_";
                    }
                    if (randInt(1, 100) >= 70) //30% chance
                    {
                        if (randInt(1, 100) >= 20) //80% chance to match hairop. if hairop doesn't exist match hair instead
                        {
                            if (mhairopcolor != 0)
                                mbangscolor = mhairopcolor;
                            else
                                mbangscolor = mhaircolor;
                        } else
                            mbangscolor = randInt(1, IApplication.usedColors);
                        mbangs = randInt(1, Application.mbangsI);
                        Application.Mimg[Application.Bangs_L1] = Application.IH.Male_Bangs[mbangscolor][mbangs][2];
                        Application.Mtype[Application.Bangs] = Integer.toString(mbangscolor) + Integer.toString(mbangs) + "_";
                    } else {
                        Application.Mimg[Application.Bangs_L1] = Application.AllBlank;
                        Application.Mtype[Application.Bangs] = "00_";
                    }
                    if (randInt(1, 100) >= 95) //5% chance
                    {
                        mfacecolor = randInt(1, IApplication.usedColors);
                        mface = randInt(1, Application.faceI);
                        Application.Mimg[Application.Face_L1] = Application.IH.Male_Face[mfacecolor][mface][2];
                        Application.Mtype[Application.Face] = Integer.toString(mfacecolor) + Integer.toString(mface) + "_";
                    } else {
                        Application.Mimg[Application.Face_L1] = Application.AllBlank;
                        Application.Mtype[Application.Face] = "00_";
                    }
                    if (randInt(1, 100) >= 90) {
                        marmorcolor = randInt(1, IApplication.usedColors);
                        marmor = randInt(1, Application.armorI);
                        Application.Mimg[Application.Armor_L1] = Application.IH.Male_Armor[marmorcolor][marmor][2];
                        Application.Mtype[Application.Armor] = Integer.toString(marmorcolor) + Integer.toString(marmor) + "_";
                    } else {
                        Application.Mimg[Application.Armor_L1] = Application.AllBlank;
                        Application.Mtype[Application.Armor] = "00_";
                    }
                } else if (Application.PickSex.equals("Female")) {
                    fbody = 0;
                    fhair = 0;
                    fhairop = 0;
                    fmantle = 0;
                    facce1 = 0;
                    facce2 = 0;
                    foption = 0;
                    ftail = 0;
                    fears = 0;
                    fface = 0;
                    fbangs = 0;
                    farmor = 0;
                    fbodycolor = 0;
                    fhaircolor = 0;
                    fhairopcolor = 0;
                    fmantlecolor = 0;
                    facce1color = 0;
                    facce2color = 0;
                    foptioncolor = 0;
                    ftailcolor = 0;
                    fearscolor = 0;
                    ffacecolor = 0;
                    fbangscolor = 0;
                    farmorcolor = 0;
                    Application.FTypeBody = ImgHandler.cbody[randInt(0, 100) >= 10 ? randInt(0, 7) : randInt(0, IApplication.ImageBases - 1)];
                    fbodycolor = randInt(1, IApplication.usedColors);
                    fbody = randInt(1, Application.fbodyI);
                    Application.Fimg[Application.Body_L1] = Application.IH.Female_Body[fbodycolor][fbody];
                    Application.Ftype[Application.Body] = Integer.toString(fbodycolor) + Integer.toString(fbody) + "_";
                    fhaircolor = randInt(1, IApplication.usedColors);
                    fhair = randInt(1, Application.fhairI);
                    Application.Fimg[Application.Hair_L2] = Application.IH.Female_Hair[fhaircolor][fhair][2];
                    Application.Fimg[Application.Hair_L1] = Application.IH.Female_Hair[fhaircolor][fhair][1];
                    Application.Ftype[Application.Hair] = Integer.toString(fhaircolor) + Integer.toString(fhair) + "_";
                    if (randInt(1, 100) >= 40) {
                        if (randInt(1, 100) >= 15)
                            fhairopcolor = fhaircolor;
                        else
                            fhairopcolor = randInt(1, IApplication.usedColors);
                        fhairop = randInt(1, Application.fhairopI);
                        Application.Fimg[Application.Hairop_L2] = Application.IH.Female_Hairop[fhairopcolor][fhairop][2];
                        Application.Fimg[Application.Hairop_L1] = Application.IH.Female_Hairop[fhairopcolor][fhairop][1];
                        Application.Ftype[Application.Hairop] = Integer.toString(fhairopcolor) + Integer.toString(fhairop) + "_";
                    } else {
                        Application.Fimg[Application.Hairop_L2] = Application.AllBlank;
                        Application.Fimg[Application.Hairop_L1] = Application.AllBlank;
                        Application.Ftype[Application.Hairop] = "00_";
                    }
                    if (randInt(1, 100) >= 80) {
                        if (randInt(1, 100) >= 65)
                            fmantlecolor = fbodycolor;
                        else if (randInt(1, 100) >= 85) //15% chance to match hair color if matching body fails
                            fmantlecolor = fhaircolor;
                        else
                            fmantlecolor = randInt(1, IApplication.usedColors);
                        fmantle = randInt(1, Application.mantleI);
                        Application.Fimg[Application.Mantle_L2] = Application.IH.Female_Mantle[fmantlecolor][fmantle][2];
                        Application.Fimg[Application.Mantle_L1] = Application.IH.Female_Mantle[fmantlecolor][fmantle][1];
                        Application.Ftype[Application.Mantle] = Integer.toString(fmantlecolor) + Integer.toString(fmantle) + "_";
                    } else {
                        Application.Fimg[Application.Mantle_L2] = Application.AllBlank;
                        Application.Fimg[Application.Mantle_L1] = Application.AllBlank;
                        Application.Ftype[Application.Mantle] = "00_";
                    }
                    if (randInt(1, 100) >= 80) {
                        if (randInt(1, 100) >= 30)
                            facce1color = fhaircolor;
                        else if (randInt(1, 100) >= 50) //50% chance to match body if hair match fails
                            facce1color = fbodycolor;
                        else
                            facce1color = randInt(1, IApplication.usedColors);
                        facce1 = randInt(1, Application.facce1I);
                        Application.Fimg[Application.Acce1_L2] = Application.IH.Female_Acce1[facce1color][facce1][2];
                        Application.Fimg[Application.Acce1_L1] = Application.IH.Female_Acce1[facce1color][facce1][1];
                        Application.Ftype[Application.Acce1] = Integer.toString(facce1color) + Integer.toString(facce1) + "_";
                    } else {
                        Application.Fimg[Application.Acce1_L2] = Application.AllBlank;
                        Application.Fimg[Application.Acce1_L1] = Application.AllBlank;
                        Application.Ftype[Application.Acce1] = "00_";
                    }
                    if (randInt(1, 100) >= 80) {
                        facce2color = randInt(1, IApplication.usedColors);
                        facce2 = randInt(1, Application.acce2I);
                        Application.Fimg[Application.Acce2_L1] = Application.IH.Female_Acce2[facce2color][facce2][2];
                        Application.Ftype[Application.Acce2] = Integer.toString(facce2color) + Integer.toString(facce2) + "_";
                    } else {
                        Application.Fimg[Application.Acce2_L1] = Application.AllBlank;
                        Application.Ftype[Application.Acce2] = "00_";
                    }
                    if (randInt(1, 100) >= 90) {
                        foptioncolor = randInt(1, IApplication.usedColors);
                        foption = randInt(1, Application.optionI);
                        Application.Fimg[Application.Option_L2] = Application.IH.Female_Option[foptioncolor][foption][2];
                        Application.Fimg[Application.Option_L1] = Application.IH.Female_Option[foptioncolor][foption][1];
                        Application.Ftype[Application.Option] = Integer.toString(foptioncolor) + Integer.toString(foption) + "_";
                    } else {
                        Application.Fimg[Application.Option_L2] = Application.AllBlank;
                        Application.Fimg[Application.Option_L1] = Application.AllBlank;
                        Application.Ftype[Application.Option] = "00_";
                    }
                    if (randInt(1, 100) >= 93) {
                        ftailcolor = randInt(1, IApplication.usedColors);
                        ftail = randInt(1, Application.tailI);
                        Application.Fimg[Application.Tail_L2] = Application.IH.Female_Tail[ftailcolor][ftail][1];
                        Application.Fimg[Application.Tail_L1] = Application.IH.Female_Tail[ftailcolor][ftail][3];
                        Application.Ftype[Application.Tail] = Integer.toString(ftailcolor) + Integer.toString(ftail) + "_";
                    } else {
                        Application.Fimg[Application.Tail_L2] = Application.AllBlank;
                        Application.Fimg[Application.Tail_L1] = Application.AllBlank;
                        Application.Ftype[Application.Tail] = "00_";
                    }
                    if (randInt(1, 100) >= 93) {
                        fearscolor = randInt(1, IApplication.usedColors);
                        fears = randInt(1, Application.earsI);
                        Application.Fimg[Application.Ears_L3] = Application.IH.Female_Ears[fearscolor][fears][2];
                        Application.Fimg[Application.Ears_L2] = Application.IH.Female_Ears[fearscolor][fears][1];
                        Application.Fimg[Application.Ears_L1] = Application.IH.Female_Ears[fearscolor][fears][3];
                        Application.Ftype[Application.Ears] = Integer.toString(fearscolor) + Integer.toString(fears) + "_";
                    } else {
                        Application.Fimg[Application.Ears_L3] = Application.AllBlank;
                        Application.Fimg[Application.Ears_L2] = Application.AllBlank;
                        Application.Fimg[Application.Ears_L1] = Application.AllBlank;
                        Application.Ftype[Application.Ears] = "00_";
                    }
                    if (randInt(1, 100) >= 70) {
                        if (randInt(1, 100) >= 20) {
                            if (fhairopcolor != 0)
                                fbangscolor = fhairopcolor;
                            else
                                fbangscolor = fhaircolor;
                        } else
                            fbangscolor = randInt(1, IApplication.usedColors);
                        fbangs = randInt(1, Application.fbangsI);
                        Application.Fimg[Application.Bangs_L1] = Application.IH.Female_Bangs[fbangscolor][fbangs][2];
                        Application.Ftype[Application.Bangs] = Integer.toString(fbangscolor) + Integer.toString(fbangs) + "_";
                    } else {
                        Application.Fimg[Application.Bangs_L1] = Application.AllBlank;
                        Application.Ftype[Application.Bangs] = "00_";
                    }
                    if (randInt(1, 100) >= 95) {
                        ffacecolor = randInt(1, IApplication.usedColors);
                        fface = randInt(1, Application.faceI);
                        Application.Fimg[Application.Face_L1] = Application.IH.Female_Face[ffacecolor][fface][2];
                        Application.Ftype[Application.Face] = Integer.toString(ffacecolor) + Integer.toString(fface) + "_";
                    } else {
                        Application.Fimg[Application.Face_L1] = Application.AllBlank;
                        Application.Ftype[Application.Face] = "00_";
                    }
                    if (randInt(1, 100) >= 90) {
                        farmorcolor = randInt(1, IApplication.usedColors);
                        farmor = randInt(1, Application.armorI);
                        Application.Fimg[Application.Armor_L1] = Application.IH.Female_Armor[farmorcolor][farmor][2];
                        Application.Ftype[Application.Armor] = Integer.toString(farmorcolor) + Integer.toString(farmor) + "_";
                    } else {
                        Application.Fimg[Application.Armor_L1] = Application.AllBlank;
                        Application.Ftype[Application.Armor] = "00_";
                    }
                }
            }
        });
        Application.apl.add(randButt);
    }

    public static int randInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }
}

package SpriteMaker;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

public class ImgHandler implements IApplication {
    protected Image image;
    public static BufferedImage[] bi;
    public static int IColors;
    public static String[] colorArray = {"null", "red", "yellow", "green", "blue", "white", "black", "purple", "pink", "dbrown", "lbrown"};
    public static String[] cbody = {"White", "Green", "Blue", "Red", "Black", "Yellow", "Purple", "Orange", "Zombie", "Goblin", "Orc", "Minotaur", "Cyclops"};
    public final static String[] bodyColors = {"White", "Green", "Blue", "Red", "Black", "Yellow", "Purple", "Orange"};
    String ImageLocation = "Data/";
    public Image[][] Male_Body = new Image[Application.usedColors + 1][Application.mbodyI + 1], Female_Body = new Image[Application.usedColors + 1][Application.fbodyI + 1];
    public Image[][][] Male_Face = new Image[Application.usedColors + 1][Application.faceI + 1][3], Female_Face = new Image[Application.usedColors + 1][Application.faceI + 1][3];
    public Image[][][] Male_Hair = new Image[Application.usedColors + 1][Application.mhairI + 1][4], Female_Hair = new Image[Application.usedColors + 1][Application.fhairI + 1][4];
    public Image[][][] Male_Hairop = new Image[Application.usedColors + 1][Application.mhairopI + 1][4], Female_Hairop = new Image[Application.usedColors + 1][Application.fhairopI + 1][4];
    public Image[][][] Male_Acce1 = new Image[Application.usedColors + 1][Application.macce1I + 1][4], Female_Acce1 = new Image[Application.usedColors + 1][Application.facce1I + 1][4];
    public Image[][][] Male_Acce2 = new Image[Application.usedColors + 1][Application.acce2I + 1][4], Female_Acce2 = new Image[Application.usedColors + 1][Application.acce2I + 1][4];
    public Image[][][] Male_Option = new Image[Application.usedColors + 1][Application.optionI + 1][5], Female_Option = new Image[Application.usedColors + 1][Application.optionI + 1][5];
    public Image[][][] Male_Mantle = new Image[Application.usedColors + 1][Application.mantleI + 1][4], Female_Mantle = new Image[Application.usedColors + 1][Application.mantleI + 1][4];
    public Image[][][] Male_Bangs = new Image[Application.usedColors + 1][Application.mbangsI + 1][4], Female_Bangs = new Image[Application.usedColors + 1][Application.fbangsI + 1][4];
    public Image[][][] Male_Tail = new Image[Application.usedColors + 1][Application.tailI + 1][4], Female_Tail = new Image[Application.usedColors + 1][Application.tailI + 1][4];
    public Image[][][] Male_Ears = new Image[Application.usedColors + 1][Application.earsI + 1][4], Female_Ears = new Image[Application.usedColors + 1][Application.earsI + 1][4];
    public Image[][][] Male_Armor = new Image[Application.usedColors + 1][Application.armorI + 1][4], Female_Armor = new Image[Application.usedColors + 1][Application.armorI + 1][4];
    public Image MaleNoneAll, FemaleNoneAll;
    public volatile static BufferedImage AllSplit;
    public static BufferedImage src0;
    public static BufferedImage[] ScaledAllSplit = new BufferedImage[5];
    public static BufferedImage[] src = new BufferedImage[maxI + 1];
    public static boolean doneWithFirstBoard = false;

    public int INum;
    public Thread th = null;

    ImgHandler() {
        th = new Thread(new Runnable() {
            public void run() {

                while (true) {
                    bi = MakeSmaller(AllSplit, ImageW, ImageH, ImageFrames, makeSmallerX, makeSmallerY);
                    try {
                        Thread.sleep(10);
                    } catch (Exception ex) {
                    }
                }
            }
        });
        th.start();
    }

    public void DrawParts(Graphics2D g, String IsSelected) {
        if (IsSelected.equals("Body"))
            DrawParts(g, Application.Mbody, Application.Fbody);
        if (IsSelected.equals("Face"))
            DrawParts(g, Application.Mface, Application.Fface);
        if (IsSelected.equals("Hair"))
            DrawParts(g, Application.Mhair, Application.Fhair);
        if (IsSelected.equals("Hairop"))
            DrawParts(g, Application.Mhairop, Application.Fhairop);
        if (IsSelected.equals("Mantle"))
            DrawParts(g, Application.Mmantle, Application.Fmantle);
        if (IsSelected.equals("Acce1"))
            DrawParts(g, Application.Macce1, Application.Facce1);
        if (IsSelected.equals("Acce2"))
            DrawParts(g, Application.Macce2, Application.Facce2);
        if (IsSelected.equals("Option"))
            DrawParts(g, Application.Moption, Application.Foption);
        if (IsSelected.equals("Tail"))
            DrawParts(g, Application.Mtail, Application.Ftail);
        if (IsSelected.equals("Ears"))
            DrawParts(g, Application.Mears, Application.Fears);
        if (IsSelected.equals("Bangs"))
            DrawParts(g, Application.Mbangs, Application.Fbangs);
        if (IsSelected.equals("Armor"))
            DrawParts(g, Application.Marmor, Application.Farmor);
    }

    public void DrawParts(Graphics2D g, Image Malepart, Image Femalepart) {
        if (Application.PickSex.equals("Male")) {
            g.drawImage(MaleNoneAll, Application.PartSelectWindowX, Application.PartSelectWindowY - ImageH, null);
            g.drawImage(Malepart, Application.PartSelectWindowX, Application.PartSelectWindowY, null);
        } else if (Application.PickSex.equals("Female")) {
            g.drawImage(FemaleNoneAll, Application.PartSelectWindowX, Application.PartSelectWindowY - ImageH, null);
            g.drawImage(Femalepart, Application.PartSelectWindowX, Application.PartSelectWindowY, null);
        }
    }

    private int[] GetOverrides(int[][] i, int part) {
        int[] toReturn = new int[categories + 1];
        for (int a = 0; a <= categories; a++)
            toReturn[a] = -1;
        if (i[part][0] == -1)
            return toReturn;
        else
            for (int xx = 0; xx <= categories; xx++)
                toReturn[xx] = i[part][xx];
        return toReturn;
    }

    public void drawBoard() {
        if (!doneWithFirstBoard) {
            /*
             * Male Start
			 * */
            Application.Mbody = setImage(Male_Body, null, IApplication.usedColors, Application.mbodyI, Application.mfront, 5, 2,        //set the image as if no override
                    GetOverrides(IOHandler.overridesCFG, IApplication.mbodyCFG), Application.mback, 8, 2);                                //Check for override in config.cfg

            Application.Mhair = setImage(null, Male_Hair, IApplication.usedColors, Application.mhairI, Application.mfront, 5, 2,
                    GetOverrides(IOHandler.overridesCFG, IApplication.mhairCFG), Application.mback, 8, 2);

            Application.Mhairop = setImage(null, Male_Hairop, IApplication.usedColors, Application.mhairopI, Application.mback, 8, 1,
                    GetOverrides(IOHandler.overridesCFG, IApplication.mhairopCFG), Application.mfront, 5, 1);

            Application.Mmantle = setImage(null, Male_Mantle, IApplication.usedColors, Application.mantleI, Application.mback, 8, 2,
                    GetOverrides(IOHandler.overridesCFG, IApplication.mantleCFG), Application.mfront, 5, 2);

            Application.Moption = setImage(null, Male_Option, IApplication.usedColors, Application.optionI, Application.mback, 8, 2,
                    GetOverrides(IOHandler.overridesCFG, IApplication.optionCFG), Application.mfront, 5, 1);

            Application.Macce1 = setImage(null, Male_Acce1, IApplication.usedColors, Application.macce1I, Application.mfront, 5, 1,
                    GetOverrides(IOHandler.overridesCFG, IApplication.macce1CFG), Application.mback, 8, 1);

            Application.Macce2 = setImage(null, Male_Acce2, IApplication.usedColors, Application.acce2I, Application.mfront, 5, 2,
                    GetOverrides(IOHandler.overridesCFG, IApplication.acce2CFG), Application.mback, 8, 2);

            Application.Mtail = setImage(null, Male_Tail, IApplication.usedColors, Application.tailI, Application.mside, 7, 1,
                    GetOverrides(IOHandler.overridesCFG, IApplication.tailCFG), Application.mback, 8, 1);

            Application.Mears = setImage(null, Male_Ears, IApplication.usedColors, Application.earsI, Application.mfront, 5, 2,
                    GetOverrides(IOHandler.overridesCFG, IApplication.earsCFG), Application.mback, 8, 1);

            Application.Mbangs = setImage(null, Male_Bangs, IApplication.usedColors, Application.mbangsI, Application.mfront, 5, 2,
                    GetOverrides(IOHandler.overridesCFG, IApplication.mbangsCFG), Application.mback, 8, 2);

            Application.Mface = setImage(null, Male_Face, IApplication.usedColors, Application.faceI, Application.mfront, 5, 2,
                    GetOverrides(IOHandler.overridesCFG, IApplication.faceCFG), Application.mback, 8, 2);

            Application.Marmor = setImage(null, Male_Armor, IApplication.usedColors, Application.armorI, Application.mback, 8, 2,
                    GetOverrides(IOHandler.overridesCFG, IApplication.armorCFG), Application.mfront, 5, 2);
				
			/*
			 * Female Start
			 * */
            Application.Fbody = setImage(Female_Body, null, IApplication.usedColors, Application.fbodyI, Application.ffront, 5, 2,
                    GetOverrides(IOHandler.overridesCFG, IApplication.fbodyCFG), Application.fback, 8, 2);

            Application.Fhair = setImage(null, Female_Hair, IApplication.usedColors, Application.fhairI, Application.ffront, 5, 2,
                    GetOverrides(IOHandler.overridesCFG, IApplication.fhairCFG), Application.fback, 8, 2);

            Application.Fhairop = setImage(null, Female_Hairop, IApplication.usedColors, Application.fhairopI, Application.fback, 8, 1,
                    GetOverrides(IOHandler.overridesCFG, IApplication.fhairopCFG), Application.ffront, 5, 1);

            Application.Fmantle = setImage(null, Female_Mantle, IApplication.usedColors, Application.mantleI, Application.fback, 8, 2,
                    GetOverrides(IOHandler.overridesCFG, IApplication.mantleCFG), Application.ffront, 5, 2);

            Application.Foption = setImage(null, Female_Option, IApplication.usedColors, Application.optionI, Application.fback, 8, 2,
                    GetOverrides(IOHandler.overridesCFG, IApplication.optionCFG), Application.ffront, 5, 2);

            Application.Facce1 = setImage(null, Female_Acce1, IApplication.usedColors, Application.facce1I, Application.ffront, 5, 1,
                    GetOverrides(IOHandler.overridesCFG, IApplication.facce1CFG), Application.fback, 8, 1);

            Application.Facce2 = setImage(null, Female_Acce2, IApplication.usedColors, Application.acce2I, Application.ffront, 5, 2,
                    GetOverrides(IOHandler.overridesCFG, IApplication.acce2CFG), Application.fback, 8, 2);

            Application.Ftail = setImage(null, Female_Tail, IApplication.usedColors, Application.tailI, Application.fside, 7, 1,
                    GetOverrides(IOHandler.overridesCFG, IApplication.tailCFG), Application.fback, 8, 1);

            Application.Fears = setImage(null, Female_Ears, IApplication.usedColors, Application.earsI, Application.ffront, 5, 2,
                    GetOverrides(IOHandler.overridesCFG, IApplication.earsCFG), Application.fback, 8, 1);

            Application.Fbangs = setImage(null, Female_Bangs, IApplication.usedColors, Application.fbangsI, Application.ffront, 5, 2,
                    GetOverrides(IOHandler.overridesCFG, IApplication.fbangsCFG), Application.fback, 8, 2);

            Application.Fface = setImage(null, Female_Face, IApplication.usedColors, Application.faceI, Application.ffront, 5, 2,
                    GetOverrides(IOHandler.overridesCFG, IApplication.faceCFG), Application.fback, 8, 2);

            Application.Farmor = setImage(null, Female_Armor, IApplication.usedColors, Application.armorI, Application.fback, 8, 2,
                    GetOverrides(IOHandler.overridesCFG, IApplication.armorCFG), Application.ffront, 5, 2);

        }
    }

    public BufferedImage createResizedCopy(BufferedImage originalImage, int scaledWidth, int scaledHeight) {
        BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = scaledBI.createGraphics();
        g.setComposite(AlphaComposite.Src);
        g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
        g.dispose();
        return scaledBI;
    }

    private BufferedImage setImage(Image[][] img, Image[][][] img2, int col, int count, Image back, int grabframe, int layer, int[] ovr, Image oImage, int ovrFrame, int ovrLayer) {
        int keepcount = 0;
        BufferedImage dest = new BufferedImage(col * ImageW * 2, ((count / 2) + 1) * ImageH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = dest.createGraphics();
        boolean[] over = new boolean[count + 1];
        for (int lo = 0; lo <= count; lo++) {
            over[lo] = new Boolean(false);
            if (ovr[keepcount] == lo) {
                over[lo] = true;
                keepcount++;
            } else
                over[lo] = false;
        }
        for (int icount = 0; icount <= count; icount++) {
            if (icount <= count / 2) {
                if (ovr == null || !over[icount])
                    g2.drawImage(back, 0, icount * ImageH - ImageH, null);
                else
                    g2.drawImage(oImage, 0, icount * ImageH - ImageH, null);
            } else {
                if (icount <= count) {
                    if (ovr == null || !over[icount])
                        g2.drawImage(back, IApplication.drawAcross, icount * ImageH - ImageH - (count / 2 * ImageH), null);
                    else
                        g2.drawImage(oImage, IApplication.drawAcross, icount * ImageH - ImageH - (count / 2 * ImageH), null);
                }
            }
            for (int icol = 0; icol <= col; icol++) {
                if (icount <= count / 2) {
                    //This controls the first half of the selection window
                    if (img2 == null) {
                        if (ovr == null || !over[icount])
                            g2.drawImage(MakeSmaller(img[icol][icount], ImageW, ImageH, ImageFrames, makeSmallerX, makeSmallerY)[grabframe],
                                    icol * ImageW - ImageW, icount * ImageH - ImageH, null);
                        else
                            g2.drawImage(MakeSmaller(img[icol][icount], ImageW, ImageH, ImageFrames, makeSmallerX, makeSmallerY)[ovrFrame],
                                    icol * ImageW - ImageW, icount * ImageH - ImageH, null);
                    } else {
                        if (ovr == null || !over[icount])
                            g2.drawImage(MakeSmaller(img2[icol][icount][layer], ImageW, ImageH, ImageFrames, makeSmallerX, makeSmallerY)[grabframe],
                                    icol * ImageW - ImageW, icount * ImageH - ImageH, null);
                        else
                            g2.drawImage(MakeSmaller(img2[icol][icount][ovrLayer], ImageW, ImageH, ImageFrames, makeSmallerX, makeSmallerY)[ovrFrame],
                                    icol * ImageW - ImageW, icount * ImageH - ImageH, null);
                    }
                } else {
                    //This controls the second half of the selection window
                    if (img2 == null) {
                        if (ovr == null || !over[icount])
                            g2.drawImage(MakeSmaller(img[icol][icount], ImageW, ImageH, ImageFrames, makeSmallerX, makeSmallerY)[grabframe],
                                    IApplication.drawAcross - ImageW + icol * ImageW, icount * ImageH - ImageH - (count / 2 * ImageH), null);
                        else
                            g2.drawImage(MakeSmaller(img[icol][icount], ImageW, ImageH, ImageFrames, makeSmallerX, makeSmallerY)[ovrFrame],
                                    IApplication.drawAcross - ImageW + icol * ImageW, icount * ImageH - ImageH - (count / 2 * ImageH), null);
                    } else {
                        if (ovr == null || !over[icount])
                            g2.drawImage(MakeSmaller(img2[icol][icount][layer], ImageW, ImageH, ImageFrames, makeSmallerX, makeSmallerY)[grabframe],
                                    IApplication.drawAcross - ImageW + icol * ImageW, icount * ImageH - ImageH - (count / 2 * ImageH), null);
                        else
                            g2.drawImage(MakeSmaller(img2[icol][icount][ovrLayer], ImageW, ImageH, ImageFrames, makeSmallerX, makeSmallerY)[ovrFrame],
                                    IApplication.drawAcross - ImageW + icol * ImageW, icount * ImageH - ImageH - (count / 2 * ImageH), null);
                    }
                }
            }
        }
        g2.dispose();
        return dest;
    }

    private void LoadSpriteIn(Image[][] MSpr, Image[][] FSpr, int CI, int NI, int INum, int IColors, String colorString, String partString) {
        String LoadedString;
        if (MSpr != null) {
            LoadedString = ImageLocation + "Male/" + partString + Integer.toString(INum) + "_" + colorString;
            MSpr[CI][NI] = load(LoadedString + ".png");
        }
        if (FSpr != null) {
            LoadedString = ImageLocation + "Female/" + partString + Integer.toString(INum) + "_" + colorString;
            FSpr[CI][NI] = load(LoadedString + ".png");
        }
    }

    private void LoadSpriteIn(Image[][][] MSpr3, Image[][][] FSpr3, boolean GetFront, boolean GetMiddle, boolean GetBack, int CI, int NI, boolean LoadBothFromSame, int INum, int IColors, String colorString, String partString) {
        String LoadedString;
        if (MSpr3 != null) {
            if (!LoadBothFromSame)
                LoadedString = ImageLocation + "Male/" + partString + Integer.toString(INum) + "_" + colorString;
            else
                LoadedString = ImageLocation + partString + Integer.toString(INum) + "_" + colorString;

            if (GetBack)
                MSpr3[CI][NI][1] = load(LoadedString + "_back" + ".png");

            if (GetFront)
                MSpr3[CI][NI][2] = load(LoadedString + "_front" + ".png");

            if (GetMiddle)
                MSpr3[CI][NI][3] = load(LoadedString + "_middle" + ".png");
        }
        if (FSpr3 != null) {
            if (!LoadBothFromSame)
                LoadedString = ImageLocation + "Female/" + partString + Integer.toString(INum) + "_" + colorString;
            else
                LoadedString = ImageLocation + partString + Integer.toString(INum) + "_" + colorString;

            if (GetBack)
                FSpr3[CI][NI][1] = load(LoadedString + "_back" + ".png");

            if (GetFront)
                FSpr3[CI][NI][2] = load(LoadedString + "_front" + ".png");

            if (GetMiddle)
                FSpr3[CI][NI][3] = load(LoadedString + "_middle" + ".png");
        }
    }

    public void LoadAllSprites() {

        String colorString, partString;

        for (int IColors = 1; IColors <= IApplication.usedColors; IColors++) {
            colorString = colorArray[IColors];

            for (int INum = 1; INum <= IApplication.maxI; INum++) {
                partString = "Hair/";
                if (INum <= Application.fhairI)
                    LoadSpriteIn(null, Female_Hair, true, false, true, IColors, INum, false, INum, IColors, colorString, partString);
                if (INum <= Application.mhairI)
                    LoadSpriteIn(Male_Hair, null, true, false, true, IColors, INum, false, INum, IColors, colorString, partString);

                partString = "Body/";
                if (INum <= Application.fbodyI)
                    LoadSpriteIn(null, Female_Body, IColors, INum, INum, IColors, colorString, partString);
                if (INum <= Application.mbodyI)
                    LoadSpriteIn(Male_Body, null, IColors, INum, INum, IColors, colorString, partString);

                partString = "Bangs/";
                if (INum <= Application.fbangsI)
                    LoadSpriteIn(null, Female_Bangs, true, false, false, IColors, INum, false, INum, IColors, colorString, partString);
                if (INum <= Application.mbangsI)
                    LoadSpriteIn(Male_Bangs, null, true, false, false, IColors, INum, false, INum, IColors, colorString, partString);

                partString = "Mantle/";
                if (INum <= Application.mantleI)
                    LoadSpriteIn(Male_Mantle, Female_Mantle, true, false, true, IColors, INum, true, INum, IColors, colorString, partString);

                partString = "Hairop/";
                if (INum <= Application.fhairopI)
                    LoadSpriteIn(null, Female_Hairop, true, false, true, IColors, INum, false, INum, IColors, colorString, partString);
                if (INum <= Application.mhairopI)
                    LoadSpriteIn(Male_Hairop, null, true, false, true, IColors, INum, false, INum, IColors, colorString, partString);

                partString = "Acce2/";
                if (INum <= Application.acce2I)
                    LoadSpriteIn(Male_Acce2, Female_Acce2, true, false, false, IColors, INum, true, INum, IColors, colorString, partString);

                partString = "Acce1/";
                if (INum <= Application.facce1I)
                    LoadSpriteIn(null, Female_Acce1, true, false, true, IColors, INum, false, INum, IColors, colorString, partString);
                if (INum <= Application.macce1I)
                    LoadSpriteIn(Male_Acce1, null, true, false, true, IColors, INum, false, INum, IColors, colorString, partString);

                partString = "Tail/";
                if (INum <= Application.tailI)
                    LoadSpriteIn(Male_Tail, Female_Tail, false, true, true, IColors, INum, true, INum, IColors, colorString, partString);

                partString = "Ears/";
                if (INum <= Application.earsI)
                    LoadSpriteIn(Male_Ears, Female_Ears, true, true, true, IColors, INum, true, INum, IColors, colorString, partString);

                partString = "Option/";
                if (INum <= Application.optionI)
                    LoadSpriteIn(Male_Option, Female_Option, true, false, true, IColors, INum, true, INum, IColors, colorString, partString);

                partString = "Face/";
                if (INum <= Application.faceI)
                    LoadSpriteIn(Male_Face, Female_Face, true, false, true, IColors, INum, true, INum, IColors, colorString, partString);

                partString = "Armor/";
                if (INum <= Application.armorI)
                    LoadSpriteIn(Male_Armor, Female_Armor, true, false, true, IColors, INum, true, INum, IColors, colorString, partString);
            }
        }
    }

    public BufferedImage StackImage() {
        src0 = toBufferedImage(Application.AllBlank);
        if (Application.PickSex.equals("Male")) {
            for (int i = IApplication.StackFirst; i <= IApplication.StackLast; i++) // 17 images starting at 2 ( I don't know why @ 2 )
            {
                if (i == IApplication.Base) {
                    if (Application.MHaveBody)
                        src[i] = ReturnBody(Application.MTypeBody, "Male");
                } else
                    src[i] = toBufferedImage(Application.Mimg[i]);
            }
        }
        if (Application.PickSex.equals("Female")) {
            for (int i = IApplication.StackFirst; i <= IApplication.StackLast; i++) {
                if (i == IApplication.Base) {
                    if (Application.FHaveBody)
                        src[i] = ReturnBody(Application.FTypeBody, "Female");
                } else
                    src[i] = toBufferedImage(Application.Fimg[i]);
            }
        }
        Graphics2D g3 = src0.createGraphics();
        for (int i = IApplication.StackFirst; i <= IApplication.StackLast; i++) {
            if (i == IApplication.Base) {
                if (Application.MHaveBody && Application.PickSex.equals("Male") || Application.FHaveBody && Application.PickSex.equals("Female"))
                    g3.drawImage(src[i], 0, 0, null);
            } else
                g3.drawImage(src[i], 0, 0, null);
        }
        if (Application.PickSex.equals("Female") && Application.FisGhost || Application.PickSex.equals("Male") && Application.MisGhost) {
            src0 = Ghostify(src0);
        }
        return src0;
    }

    public BufferedImage SaveASVX() {
        BufferedImage dest = new BufferedImage(128, 128, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = dest.createGraphics();
        BufferedImage bi = StackImage();
        g2.drawImage(bi, -32, 0, null);
        g2.drawImage(bi, 32, 0, null);
        g2.dispose();
        return dest;
    }

    public BufferedImage ReturnBody(String Body, String sex) {
        int inc = 0;
        for (String s : cbody) {
            if (Body.equals(s)) {
                if (Application.PickSex.equals("Male"))
                    return toBufferedImage(Application.Mbase[inc]);
                if (Application.PickSex.equals("Female"))
                    return toBufferedImage(Application.Fbase[inc]);
            }
            inc++;
        }
        //Something went wrong if the program even reaches this point
        return null;
    }

    public BufferedImage toBufferedImage(Image src) {
        BufferedImage dest = new BufferedImage(IApplication.TileW, IApplication.TileH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = dest.createGraphics();
        g2.drawImage(src, 0, 0, null);
        g2.dispose();
        return dest;
    }

    public BufferedImage Ghostify(BufferedImage bi) {
        BufferedImage dest = new BufferedImage(IApplication.TileW, IApplication.TileH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = dest.createGraphics();
        if (Application.PickSex.equals("Male"))
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, Application.Mopacity));
        if (Application.PickSex.equals("Female"))
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, Application.Fopacity));
        g2.drawImage(bi, 0, 0, null);
        g2.dispose();
        return dest;
    }

    public BufferedImage[] MakeSmaller(Image src, int XSize, int YSize, int framesToBuff, int XMaxB, int YMaxB) {
        BufferedImage[] dest = new BufferedImage[framesToBuff + 1];
        Graphics2D[] g2 = new Graphics2D[framesToBuff + 1];
        for (int i = 1; i <= framesToBuff; i++) {
            //Create the buffered image with Alpha attributes ( limits me to png?? cause JPEG and BMP wont save )
            dest[i] = new BufferedImage(XSize, YSize, BufferedImage.TYPE_INT_ARGB);
            g2[i] = dest[i].createGraphics();
        }

        for (int x = 0, i = 1; x >= XMaxB; x -= XSize)// - numbers because we read the image backwards
            for (int y = 0; y >= YMaxB; y -= YSize, i++)// - numbers because we read the image backwards
                g2[i].drawImage(src, x, y, null);

        for (int i = 1; i <= framesToBuff; i++)
            g2[i].dispose();
        return dest;
    }

    private URL getURL(String filename) {
        URL url = null;
        try {
            url = ClassLoader.getSystemResource(filename);
        } catch (Exception e) {
        }
        return url;
    }

    public Image load(String filename) {
        return Toolkit.getDefaultToolkit().getImage(getURL(filename));
    }
}

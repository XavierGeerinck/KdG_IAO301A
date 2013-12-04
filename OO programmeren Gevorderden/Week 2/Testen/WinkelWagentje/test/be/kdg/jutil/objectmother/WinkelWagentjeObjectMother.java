package be.kdg.jutil.objectmother;

import be.kdg.jutil.WinkelWagentje;

public class WinkelWagentjeObjectMother {
    public static WinkelWagentje maakLeegWagentje() {
        return new WinkelWagentje();
    }

    public static WinkelWagentje maakWagentjeMetEenBoek() {
        WinkelWagentje wagentje = new WinkelWagentje();
        wagentje.voegToe(ProductObjectMother.maakXPBoek());
        return wagentje;
    }

    public static WinkelWagentje maakWagentjeMetTweeBoeken() {
        WinkelWagentje wagentje = maakWagentjeMetEenBoek();
        wagentje.voegToe(ProductObjectMother.maakRefactoringBoek());
        return wagentje;
    }
}

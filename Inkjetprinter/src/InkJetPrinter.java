public class InkJetPrinter {
    private int MaxLevel;
    private int cartridge[];
    private final int NCart = 4;


    public InkJetPrinter(int maxLevel) {
        MaxLevel = maxLevel;
        this.cartridge = new int[NCart];
        InitCart();
    }

    private void InitCart(){
        for(Colore c : Colore.values()){
            this.cartridge[c.ordinal()] = MaxLevel;
        }
    }

    public void ChangeCart(Colore colore){
        cartridge[colore.ordinal()] = MaxLevel;
    }

    public void CheckCart(){
            for(Colore c : Colore.values()){
                System.out.println(""+c.name()+ ":" +cartridge[c.ordinal()]);
            }
    }

    public boolean CheckPrint(ImgVect imv){
        for(Colore c : Colore.values()){
            if(imv.SommAreeC(c) > cartridge[c.ordinal()]){
                return false;
            }
        }
        return true;
    }

    public void Print(ImgVect imv){
        for(Colore c : Colore.values()){
            cartridge[c.ordinal()] -= imv.SommAreeC(c);
        }
    }

}

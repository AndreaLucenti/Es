package Ristoranti;
import Alimenti.*;
import Menu.*;

public class Enoteca extends  EsRistoraz{
    private String nome;
    private Menu menu;

    public Enoteca(String nome, Menu menu) {
        this.nome = nome;
        this.menu = menu;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public Menu getMenu() {
        return menu;
    }

    public boolean Add(Alimento A1, double Prezzo){
        ElementoMenu el = new ElementoMenu(Prezzo, A1);
        if((el.getAlimento() instanceof Vino)){
            if(menu.AddEl(el)) {
                return true;
            }
        }
        return false;
    }
    public boolean Rem(Alimento A1, double Prezzo){
        ElementoMenu el = new ElementoMenu(Prezzo, A1);
        if(menu.RemEl(el)){
            return true;
        }
        return false;
    }

    public String toString() {
        Menu m = menu;
        String s = m.toString();
        return s;
    }
}

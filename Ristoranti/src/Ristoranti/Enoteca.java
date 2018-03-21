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

    public boolean Add(ElementoMenu el){
        if(menu.AddEl(el) && (el.getAlimento() instanceof Vino)){
            return true;
        }
        return false;
    }
    public boolean Rem(ElementoMenu el){
        if(menu.RemEl(el)){
            return true;
        }
        return false;
    }
}

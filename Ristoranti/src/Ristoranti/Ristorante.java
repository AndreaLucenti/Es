package Ristoranti;
import Menu.*;

public class Ristorante extends EsRistoraz{
    private String nome;
    private Menu menu;

    public Ristorante(String nome, Menu menu) {
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
        if(menu.AddEl(el)){
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

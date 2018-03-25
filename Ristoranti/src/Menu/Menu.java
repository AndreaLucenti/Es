package Menu;

import java.util.*;

public class Menu {
    private Map<Integer, ElementoMenu> menu;

    public Menu() {
        this.menu = new LinkedHashMap<>();
    }

    public Map<Integer, ElementoMenu> getMenu() {
        return menu;
    }

    public Boolean AddEl(ElementoMenu el){
        if(menu.equals(el)){
            return false;
        }
        menu.put(menu.size()+1, el);
        return true;
    }

    public Boolean RemEl(ElementoMenu el){
        if(menu.equals(el)){
            menu.remove(el);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
       String s = menu.toString();
       return s;
    }
}

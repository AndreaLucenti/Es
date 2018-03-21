package Menu;

import java.util.*;

public class Menu {
    private Map<ElementoMenu, Integer> menu;

    public Menu() {
        this.menu = new LinkedHashMap<>();
    }

    public Map<ElementoMenu, Integer> getMenu() {
        return menu;
    }

    public Boolean AddEl(ElementoMenu el){
        if(menu.containsValue(el)){
            return false;
        }
        menu.put(el , menu.size()+1);
        return true;
    }

    public Boolean RemEl(ElementoMenu el){
        if(menu.containsValue(el)){
            menu.remove(el);
            return true;
        }
        return false;
    }
}

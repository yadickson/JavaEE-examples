package org.sotux.strutsmvc.web.action;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.Action;
import org.apache.struts2.ResultNames;
import org.sotux.strutsmvc.model.bean.MenuOption;

public class MainMenuAction implements Action {

    private List<MenuOption> menuOptions;
    
    @Override
    public String execute() {
        
        menuOptions = new ArrayList<MenuOption>();
        
        getMenuOptions().add(new MenuOption("newAccountPage","main.menu.new.account"));
        getMenuOptions().add(new MenuOption("addAccountPage","main.menu.add.account"));
        getMenuOptions().add(new MenuOption("subAccountPage","main.menu.sub.account"));
        getMenuOptions().add(new MenuOption("removeAccountPage","main.menu.remove.account"));

        return ResultNames.SUCCESS;
    }

    public List<MenuOption> getMenuOptions() {
        return menuOptions;
    }
}

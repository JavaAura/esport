package com.Esport.presentation.Menu;

import com.Esport.Service.interfaces.TournoiService;
import com.Esport.Util.LoggerUtil;

public class MenuTournoi {

    private final TournoiService tournoiService;

    public MenuTournoi(TournoiService tournoiService) {
        this.tournoiService = tournoiService;
    }

    public static void afficherMenuTournoi(){
        LoggerUtil.info("Menu Tournoi");
    }

}

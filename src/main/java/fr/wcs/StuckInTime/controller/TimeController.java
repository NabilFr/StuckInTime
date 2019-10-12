package fr.wcs.StuckInTime.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TimeController {

   // @PostMapping("/{weaponid}")
   @PostMapping("/weapon")
    //public String weaponChoice(Model model, @PathVariable int weaponid) {
   public String weaponChoice(Model model, @RequestParam(name = "weapon") int weapon) {

        String [] arme = {"épée", "fourchette", "Bouclier"};

       model.addAttribute("arme", arme[weapon]);

        return "/attack";
    }

    @PostMapping("/win")
    //public String weaponChoice(Model model, @PathVariable int weaponid) {
   public String attackChoice(Model model, @RequestParam(name = "attack") int attack) {

        String [] attackChoice = {"frontale", "dans l'oeil", "insulte"};

       model.addAttribute("attack", attackChoice[attack]);

        return "/win";
    }

}

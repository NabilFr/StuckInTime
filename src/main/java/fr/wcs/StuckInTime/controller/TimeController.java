package fr.wcs.StuckInTime.controller;

import fr.wcs.StuckInTime.Hero;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TimeController {

    private Hero personnage1 = new Hero("default","default","default");

    @PostMapping("/poneymagique")
    public String indexContinue(@RequestParam(name = "continue") int choice) {

        return "/weapon";
    }

    @PostMapping("/attack")
    public String weaponChoice(Model model, @RequestParam(name = "weapon") int weapon) {

        String[] arme = {"épée", "fourchette", "Bouclier"};

        model.addAttribute("arme", arme[weapon]);
        personnage1.setArme(arme[weapon]);
        return "/attack";
    }

    @PostMapping("/win")
    public String attackChoices(Model model, @RequestParam(name = "attack") int attack) {

        String[] attackChoice = {"frontale", "dans l'oeil", "insulte"};

        model.addAttribute("attack", attackChoice[attack]);
        personnage1.setAttack(attackChoice[attack]);
        if (personnage1.getAttack().equals("frontale") && personnage1.getArme().equals("fourchette")) {
            return "/win";
        }else {
            return "/lose";
        }
    }
}

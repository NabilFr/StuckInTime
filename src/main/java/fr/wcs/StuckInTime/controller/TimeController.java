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
    String[] heroes = {"JCVD", "Bob l'éponge", "MacroJoke", };
    private Hero personnage1 = new Hero("","","");
    static String name = "";

    @PostMapping("/weapon")
    public String indexContinue(Model model, @RequestParam(name = "weapon") int choice) {

           personnage1.setName(heroes[choice]);
           name = personnage1.getName();

        model.addAttribute("name", name);

        return "/weapon";
    }

    @PostMapping("/attack")
    public String weaponChoice(Model model, @RequestParam(name = "weapon") int weapon) {

        String[] arme = {"Baguette Magique", "Pierre", "Epée"};
        model.addAttribute("name", name);
        model.addAttribute("arme", arme[weapon]);
        personnage1.setArme(arme[weapon]);
        if (personnage1.getName().equals("Joker")) {
            return "/attackJoker";
        }
        else if(name.equals("Pika")) {
            return "/attackPika";
        }
        else {
            return "/attackTheMask";
        }
    }

    @PostMapping("/win")
    public String attackChoices(Model model, @RequestParam(name = "attack") int attack) {

        String[] attackChoice = {"frontale", "dans l'oeil", "insulte"};
        model.addAttribute("name", name);
        model.addAttribute("attack", attackChoice[attack]);
        personnage1.setAttack(attackChoice[attack]);
        if (name.equals("Joker") && personnage1.getAttack().equals("frontale")
                && personnage1.getArme().equals("Pierre")) {
            return "/win";
        }else if (name.equals("Pika") && personnage1.getAttack().equals("dans l'oeil")
                && personnage1.getArme().equals("Baguette Magique")){
            return "/win";
        }else if (name.equals("MacroJoke") && personnage1.getAttack().equals("insulte")
                && personnage1.getArme().equals("Epée")){
            return "/win";
        }
        else {
            return "/lose";
        }
    }
}

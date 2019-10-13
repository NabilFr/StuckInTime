package fr.wcs.StuckInTime.controller;

import fr.wcs.StuckInTime.Hero;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
public class TimeController {
    private Hero personnage1 = new Hero();

    @GetMapping("/")
    public String mainRoute(Model model) {
        model.addAttribute(personnage1.getScore());
        return "/index";
    }


    @PostMapping("/choiceHero")
    public String chooseYourName(Model model, @RequestParam(name = "username")String name) {
        personnage1.setName(name);
        model.addAttribute("name", name);
        model.addAttribute("sccore", personnage1.getScore());
        return "/choiceHero";
    }


    @PostMapping("/weapon")
    public String indexContinue(Model model, @RequestParam(name = "weapon") int choice) {
        personnage1.setHeroIndex(choice);
        String hero = personnage1.getHero();
        model.addAttribute("hero", hero);
        model.addAttribute("name", personnage1.getName());
        model.addAttribute("sccore", personnage1.getScore());
        if (choice == 0 || choice == 3) {
            return "/weapon";
        }
        else {
            return "/holidays";
        }
    }

    @PostMapping("/attack")
    public String weaponChoice(Model model, @RequestParam(name = "weapon") int weapon) {

        String[] arme = {"la baguette magique", "la pierre", "l'épée"};
        model.addAttribute("name", personnage1.getHero());
        model.addAttribute("arme", arme[weapon]);
        model.addAttribute("sccore", personnage1.getScore());
        String attack1;
        String attack2;
        if (weapon == 0) {
            attack1 = personnage1.getAttack(0);
            attack2 = personnage1.getAttack(1);
        }
        else if (weapon == 1) {
            attack1 = personnage1.getAttack(2);
            attack2 = personnage1.getAttack(3);
        }
        else {
            attack1 = personnage1.getAttack(4);
            attack2 = personnage1.getAttack(5);
        }

        model.addAttribute("attack1", attack1);
        model.addAttribute("attack2", attack2);
        personnage1.setArme(weapon);
        return "/attack";

    }

    @PostMapping("/win")
    public String attackChoices(Model model, @RequestParam(name = "attack") int attack) {

        String[] attackChoice = {"frontale", "dans l'oeil", "insulte"};
        model.addAttribute("name", personnage1.getName());
        model.addAttribute("attack", attackChoice[attack]);
        model.addAttribute("sccore", personnage1.getScore());

        personnage1.setAttack(attack);
        int[] scenario = {personnage1.getHeroIndexIndex(), personnage1.getArme(), personnage1.getAttack()};
        String ending = "";
        int score = 0;
        switch (Arrays.toString(scenario)) {
            case "[0, 0, 0]":
                ending = String.format("JC est dégoûté par le choix de %s d'une arme en plastique non recyclable et envoie valser l'objet d'un magnifique coup de pied retourné. Il abandonne %s à sa non awareness qui se fait écrabouiller comme une merde par le géant.", personnage1.getName(), personnage1.getName());
                score = 5;
                personnage1.setScore(score);
                break;
            case "[0, 0, 1]":
                ending = "La baguette fait réaliser à JC qu'il devrait être auprès de ses children parce que la vie c'est quelque chose de très fort et de tres beau... La vie appartient à tous les vivants. It's both a dream and a feeling. C'est être ce que nous ne sommes pas sans le rester. La vie c'est mourir aussi... Et mourir c'est vraiment strong. C'est rester en vie au-delà de la mort. Tous ceux qui sont morts n'ignorent pas de le savoir. JC finit par se barrer et le géant, peu convaincu, vous zigouille.";
                score = 5;
                personnage1.setScore(score);
                break;
            case "[0, 1, 0]":
                ending = "JC met un coup de pied retourné dans la pierre et s'entaille le petit orteil parce qu'il avait oublié de mettre des chaussettes. Comme il ne supporte pas la vue du sang, il perd ses moyens et vous vous prenez également la fin de son coup de pied (parce que les coups de pieds de JC tournent long time). Le géant profite que vous soyez tous les deux évanouis pour vous zigouiller.";
                score = -5;
                personnage1.setScore(score);
                break;
            case "[0, 1, 1]":
                ending = "JC se demande si la pierre vaincrait le géant si celui-ci sortait une feuille. Du coup il décide de lui lancer plutôt une paire de ciseaux qui atterrissent directement dans son oeil. Le géant perd l'équilibre et vous écrabouille comme une bouse. Finalement JC enveloppe le géant dans une feuille et le pousse dans un puits. Mais vous, vous êtes mort.";
                score = 20;
                personnage1.setScore(score);
                break;
            case "[0, 2, 0]":
                ending = "JC enchaîne des mouvements super aware que lui a appris un moine Shaolin qu'il a croisé dans sa quête de l'infini relativité du subconscient temporel. Le géant, grand fan de JC et impressionné, demande à JC de lui apprendre sa technique de coup de pied retourné. JC accepte et vous confie l'arme en attendant. Vous tentez alors de vous occuper d'occir le monstre mais vous vous tranchez le bras et la jambe en la manipulant. Vous vous videz de votre sang et finissez en viandox pour géant.";
                score = -20;
                personnage1.setScore(score);
                break;
            case "[0, 2, 1]":
                ending = "JC dépose l'épée de légende au sol pour essayer de convaincre le géant que la paix is the best way. Malheureusement ça ne prend pas, le géant connaît bien JCVD et l'a vu castagner un tas d'ennemis dans ses nombreux films, il ne lui fait donc pas confiance. Il saisit l'épée et vous embroche tous les deux avant de vous déposer sur son tourne-broche.";
                score = -20;
                personnage1.setScore(score);
                break;



            case "[3, 0, 0]":
                ending = "Le Mask agite la baguette, qui commence à briller. Alors qu'il exécute un magnifique flamenco avec la baguette entre les dents, le monstre finit par s'impatienter et vous écrase. C'était une belle prestation, mais un échec cuisant. Un petit « splendide... » peut être entendu depuis le dessous du pied du monstre.";
                score = 5;
                personnage1.setScore(score);
                break;
            case "[3, 0, 1]":
                ending = "Le Mask fait quelques étirements, craque sa nuque, puis, avec de la peinture de guerre étalée sur les joues, il court en hurlant un cri de guerre en direction du monstre... Sauf qu'il trébuche sur une racine et se la plante dans l’œil. C'était bien tenté. Quel dommage qu'il y ait eu cette racine au milieu de la prairie...";
                score = -5;
                personnage1.setScore(score);
                break;
            case "[3, 1, 0]":
                ending = "Le Mask prend la pose d'un lanceur de baseball, levant souplement la jambe devant lui qui exécutant une rotation contrôlée du torse. La pierre fuse en direction du ciel, et s'éloigne... et s'éloigne... « HOME RUN !!! » hurle le Mask en partant en courant, jetant une casquette dont vous ignorez la provenance dans un public invisible. Vous auriez dû l'avertir que vous n'étiez pas en pleine partie de baseball... Il est partis courir les bases.";
                score = -10;
                personnage1.setScore(score);
                break;
            case "[3, 1, 1]":
                ending = "Le Mask fait apparaître un canon digne des plus grands pirates des siècles derniers. Sous votre œil médusé, il enfonce la pierre à l'intérieur et il allume la mèche, s'accroupissant derrière l'énorme pièce de métal en se bouchant les oreilles. « BAAM!! La pierre siffle dans l'air, alors qu'elle fuse en une jolie courbe en direction du monstre.\n Vous ne savez pas trop comment le Mask s'y est prit, mais il semblerait que le point faible du monstre était son petit orteil droit ; il tombe raide mort avec un grognement de douleur et de surprise.\n… Il tombe sur vous. Dommage.";
                score = 20;
                personnage1.setScore(score);
                break;
            case "[3, 2, 0]":
                ending = "Le Mask glisse un main derrière son dos, de jolies moustaches apparaissant au dessus de sa bouche, ainsi qu'un masque noir sur ses yeux. Cette pose est élégante... Certes... Mais pas très pertinente face à un monstre de vingt mètres. Nous ne sommes pas dans un combat singulier. Le Mask se fait déchirer en deux pas le monstre. \n Et devinez quoi ? Vous êtes le suivant.";
                score = -20;
                personnage1.setScore(score);
                break;
            case "[3, 2, 1]":
                ending = "Le Mask se saisit de l'épée, la brandissant en l'air dans une pose héroïque. Le soleil se reflète sur la lame et éblouit le monstre, qui trébuche en arrière en se couvrant les yeux. Finalement, dans la panique pour se rattraper, et ayant les mains occupées, le monstre s'écrase en avant... Droit sur le Mask. Votre héros s'enfonce dans la narine du monstre, et après un long moment silencieux, il en ressort en crachotant un peu de morve. Vous... Vous avez gagné ?!\n Vous vous approchez du Mask pour le féliciter... Puis vous remarquez le détonateur dans sa main droite. Qu'est-ce que... ? \n« BOOM ! » Ouais... Il a fait exploser le monstre.. Et vous avec.";
                score = 10;
                personnage1.setScore(score);
                break;
        }
        model.addAttribute("ending", ending);
        model.addAttribute("points", score);
        return "/win";
    }
    @PostMapping("/startAgain")

    public String startAgain(Model model, @RequestParam (name="start")int choice) {
        model.addAttribute("name", personnage1.getName());
        model.addAttribute("sccore", personnage1.getScore());


        if (choice == 0) {
            return "/choiceHero";
        }
        return "/youSuck";
    }
}
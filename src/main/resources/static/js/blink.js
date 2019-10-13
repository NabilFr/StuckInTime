var clignotement = function () {
    if (document.getElementById('blink').style.visibility == 'visible') {
        document.getElementById('blink').style.visibility = 'hidden';
    } else {
        document.getElementById('blink').style.visibility = 'visible';
    }
}
setInterval(clignotement, 500);


var chaine = document.getElementById("story").innerHTML;
var nb_car = chaine.length;
var tableau = chaine.split("");
texte = new Array;
var txt = '';
var nb_msg = nb_car - 1;
for (i=0; i<nb_car; i++) {
    texte[i] = txt+tableau[i];
    var txt = texte[i];
}

actual_texte = 0;
var defilement = null;
function changeMessage() {
    document.getElementById("story2").innerHTML = texte[actual_texte];
    actual_texte++;
    if(actual_texte >= texte.length) {
        actual_texte = nb_msg;
        clearInterval(defilement);
        document.getElementById('form').style.visibility = 'visible';
        setInterval(youaredead, 500);
    }
}

var youaredead = function () {
    if (document.getElementById('dead').style.visibility == 'visible') {
        document.getElementById('dead').style.visibility = 'hidden';
    } else {
        document.getElementById('dead').style.visibility = 'visible';
    }
}

if(document.getElementById) {
    defilement = setInterval(changeMessage,80)
}
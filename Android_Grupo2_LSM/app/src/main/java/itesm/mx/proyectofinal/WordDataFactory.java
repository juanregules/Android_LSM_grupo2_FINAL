package itesm.mx.proyectofinal;

import java.util.Arrays;
import java.util.List;

public class WordDataFactory {

    public static List<Word> makeWords() {
        return Arrays.asList(
                makeAbejaWord(),
                makeAguilaWord(),
                makeAranaWord(),
                makeArdillaWord(),
                makeBurroWord(),
                makeCaballoWord(),
                makeCerdoWord(),
                makeChangoWord(),
                makeConejoWord(),
                makeGatoWord(),
                makeGorillaWord(),
                makeGusanoWord(),
                makeJirafaWord(),
                makeLeonWord(),
                makeMariposaWord(),
                makeOsoWord(),
                makePajaroWord(),
                makePalomaWord(),
                makePatoWord(),
                makePerroWord(),
                makePezWord(),
                makeRatonWord(),
                makeTigreWord(),
                makeToroWord(),
                makeTortugaWord(),
                makeVacaWord(),
                makeVivoraWord());
    }


    public static Word makeAbejaWord() {
        return new Word("Abeja", makeAbejaContents(), R.drawable.abeja);
    }


    public static List<Content> makeAbejaContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.abeja;
        Content video = new Content(name, true);
    /*
    Content styx = new Content("Styx", false);
    Content reoSpeedwagon = new Content("REO Speedwagon", false);
    Content boston = new Content("Boston", true);
    */
        //return Arrays.asList(queen, styx, reoSpeedwagon, boston);
        return Arrays.asList(video);
    }

    public static Word makeAguilaWord() {
        return new Word("Aguila", makeAguilaContents(), R.drawable.aguila);
    }

    public static List<Content> makeAguilaContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.aguila;
        Content video = new Content(name, true);
        return Arrays.asList(video);
    }

    public static Word makeAranaWord() {
        return new Word("Araña", makeAranaContents(), R.drawable.arana);
    }

    public static List<Content> makeAranaContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.arana;
        Content video = new Content(name, true);
        return Arrays.asList(video);
    }

    public static Word makeArdillaWord() {
        return new Word("Ardilla", makeArdillaContents(), R.drawable.ardilla);
    }

    public static List<Content> makeArdillaContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.ardilla;
        Content video = new Content(name, true);
        return Arrays.asList(video);
    }

    public static Word makeBurroWord() {
        return new Word("Burro", makeBurroContents(), R.drawable.burro);
    }

    public static List<Content> makeBurroContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.burro;
        Content video = new Content(name, true);
        return Arrays.asList(video);
    }

    public static Word makeCaballoWord() {
        return new Word("Caballo", makeCaballoContents(), R.drawable.caballo);
    }

    public static List<Content> makeCaballoContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.caballo;
        Content video = new Content(name, true);
        return Arrays.asList(video);
    }

    public static Word makeCerdoWord() {
        return new Word("Cerdo", makeCerdoContents(), R.drawable.cerdo);
    }

    public static List<Content> makeCerdoContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.cerdo;
        Content video = new Content(name, true);
        return Arrays.asList(video);
    }

    public static Word makeChangoWord() {
        return new Word("Chango", makeChangoContents(), R.drawable.chango);
    }

    public static List<Content> makeChangoContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.chango;
        Content video = new Content(name, true);
        return Arrays.asList(video);
    }

    public static Word makeConejoWord() {
        return new Word("Conejo", makeConejoContents(), R.drawable.conejo);
    }

    public static List<Content> makeConejoContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.conejo;
        Content video = new Content(name, true);
        return Arrays.asList(video);
    }

    public static Word makeGatoWord() {
        return new Word("Gato", makeGatoContents(), R.drawable.gato);
    }

    public static List<Content> makeGatoContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.gato;
        Content video = new Content(name, true);
        return Arrays.asList(video);
    }

    public static Word makeGorillaWord() {
        return new Word("Gorila", makeGorillaContents(), R.drawable.gorila);
    }

    public static List<Content> makeGorillaContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.gorila;
        Content video = new Content(name, true);
        return Arrays.asList(video);
    }

    public static Word makeGusanoWord() {
        return new Word("Gusano", makeGusanoContents(), R.drawable.gusano);
    }

    public static List<Content> makeGusanoContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.gusano;
        Content video = new Content(name, true);
        return Arrays.asList(video);
    }

    public static Word makeJirafaWord() {
        return new Word("Jirafa", makeJirafaContents(), R.drawable.jirafa);
    }

    public static List<Content> makeJirafaContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.jirafa;
        Content video = new Content(name, true);
        return Arrays.asList(video);
    }

    public static Word makeLeonWord() {
        return new Word("Leon", makeLeonContents(), R.drawable.leon);
    }

    public static List<Content> makeLeonContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.leon;
        Content video = new Content(name, true);
        return Arrays.asList(video);
    }

    public static Word makeMariposaWord() {
        return new Word("Mariposa", makeMariposaContents(), R.drawable.mariposa);
    }

    public static List<Content> makeMariposaContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.mariposa;
        Content video = new Content(name, true);
        return Arrays.asList(video);
    }

    public static Word makeOsoWord() {
        return new Word("Oso", makeOsoContents(), R.drawable.oso);
    }

    public static List<Content> makeOsoContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.oso;
        Content video = new Content(name, true);
        return Arrays.asList(video);
    }

    public static Word makePajaroWord() {
        return new Word("Pájaro", makePajaroContents(), R.drawable.pajaro);
    }

    public static List<Content> makePajaroContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.pajaro;
        Content video = new Content(name, true);
        return Arrays.asList(video);
    }

    public static Word makePalomaWord() {
        return new Word("Paloma", makePalomaContents(), R.drawable.paloma);
    }

    public static List<Content> makePalomaContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.paloma;
        Content video = new Content(name, true);
        return Arrays.asList(video);
    }

    public static Word makePatoWord() {
        return new Word("Pato", makePatoContents(), R.drawable.pato);
    }

    public static List<Content> makePatoContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.pato;
        Content video = new Content(name, true);
        return Arrays.asList(video);
    }

    public static Word makePerroWord() {
        return new Word("Paloma", makePalomaContents(), R.drawable.perro);
    }

    public static List<Content> makePerroContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.perro;
        Content video = new Content(name, true);
        return Arrays.asList(video);
    }

    public static Word makePezWord() {
        return new Word("Pez", makePezContents(), R.drawable.pez);
    }

    public static List<Content> makePezContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.pez;
        Content video = new Content(name, true);
        return Arrays.asList(video);
    }

    public static Word makeRatonWord() {
        return new Word("Ratón", makeRatonContents(), R.drawable.raton);
    }

    public static List<Content> makeRatonContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.raton;
        Content video = new Content(name, true);
        return Arrays.asList(video);
    }

    public static Word makeTigreWord() {
        return new Word("Tigre", makeTigreContents(), R.drawable.tigre);
    }

    public static List<Content> makeTigreContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.tigre;
        Content video = new Content(name, true);
        return Arrays.asList(video);
    }

    public static Word makeToroWord() {
        return new Word("Toro", makeToroContents(), R.drawable.toro);
    }

    public static List<Content> makeToroContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.toro;
        Content video = new Content(name, true);
        return Arrays.asList(video);
    }

    public static Word makeTortugaWord() {
        return new Word("Tortuga", makeTortugaContents(), R.drawable.tortuga);
    }

    public static List<Content> makeTortugaContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.tortuga;
        Content video = new Content(name, true);
        return Arrays.asList(video);
    }

    public static Word makeVacaWord() {
        return new Word("Tortuga", makeVacaContents(), R.drawable.vaca);
    }

    public static List<Content> makeVacaContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.vaca;
        Content video = new Content(name, true);
        return Arrays.asList(video);
    }

    public static Word makeVivoraWord() {
        return new Word("Tortuga", makeVivoraContents(), R.drawable.vivora);
    }

    public static List<Content> makeVivoraContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.vibora;
        Content video = new Content(name, true);
        return Arrays.asList(video);
    }


}


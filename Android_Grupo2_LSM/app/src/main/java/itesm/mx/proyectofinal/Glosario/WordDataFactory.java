package itesm.mx.proyectofinal.Glosario;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.Arrays;
import java.util.List;

import itesm.mx.proyectofinal.principal.MainActivity;
import itesm.mx.proyectofinal.R;

public class WordDataFactory {
    private static Context context;
    public static List<Word> makeWords(String type, Context current) {
        context = current;
        if (type == "animales")
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
        else if (type == "abecedario")
            return Arrays.asList(
                    makeALetterWord(),
                    makeBLetterWord(),
                    makeCLetterWord(),
                    makeDLetterWord(),
                    makeELetterWord(),
                    makeFLetterWord(),
                    makeGLetterWord(),
                    makeHLetterWord(),
                    makeILetterWord(),
                    makeJLetterWord(),
                    makeKLetterWord(),
                    makeLLetterWord(),
                    makeLLLetterWord(),
                    makeMLetterWord(),
                    makeNLetterWord(),
                    makeNNLetterWord(),
                    makeOLetterWord(),
                    makePLetterWord(),
                    makeQLetterWord(),
                    makeRLetterWord(),
                    makeRRLetterWord(),
                    makeSLetterWord(),
                    makeTLetterWord(),
                    makeULetterWord(),
                    makeVLetterWord(),
                    makeWLetterWord(),
                    makeXLetterWord(),
                    makeYLetterWord(),
                    makeZLetterWord());
        else if (type == "colores")
            return Arrays.asList(
                    MakeAzulWord(),
                    MakeBlancoWord(),
                    MakeCafeWord(),
                    MakeGrisWord(),
                    MakeMoradoWord(),
                    MakeNaranjaWord(),
                    MakeNegroWord(),
                    MakeOroWord(),
                    MakePlataWord(),
                    MakeRojoWord(),
                    MakeRosaWord(),
                    MakeAmarilloWord(),
                    MakeVerdeWord());
        else if (type == "dias")
            return Arrays.asList(
                    MakeLunesWord(),
                    MakeMartesWord(),
                    MakeMiercolesWord(),
                    MakeJuevesWord(),
                    MakeViernesWord(),
                    MakeSabadoWord(),
                    MakeDomingoWord());
        else if (type == "meses")
            return Arrays.asList(
                    MakeEneroWord(),
                    MakeFebreroWord(),
                    MakeMarzoWord(),
                    MakeAbrilWord(),
                    MakeMayoWord(),
                    MakeJunioWord(),
                    MakeJulioWord(),
                    MakeAgostoWord(),
                    MakeSeptiempreWord(),
                    MakeOctubreWord(),
                    MakeNoviembreWord(),
                    MakeDiciembreWord() );
        else if (type == "comida")
            return Arrays.asList();

        else return null;
    }


    public static Word makeAbejaWord() {
        return new Word("Abeja", makeAbejaContents(), R.drawable.abeja);
    }


    public static List<Content> makeAbejaContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.abeja;
        Content video = new Content(name, false);
    /*
    Content styx = new Content("Styx", false);
    Content reoSpeedwagon = new Content("REO Speedwagon", false);
    Content boston = new Content("Boston", false);
    */
        //return Arrays.asList(queen, styx, reoSpeedwagon, boston);
        return Arrays.asList(video);
    }

    public static Word makeAguilaWord() {
        return new Word("Aguila", makeAguilaContents(), R.drawable.aguila);
    }

    public static List<Content> makeAguilaContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.aguila;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word makeAranaWord() {
        return new Word("Araña", makeAranaContents(), R.drawable.arana);
    }

    public static List<Content> makeAranaContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.arana;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word makeArdillaWord() {
        return new Word("Ardilla", makeArdillaContents(), R.drawable.ardilla);
    }

    public static List<Content> makeArdillaContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.ardilla;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word makeBurroWord() {
        return new Word("Burro", makeBurroContents(), R.drawable.burro);
    }

    public static List<Content> makeBurroContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.burro;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word makeCaballoWord() {
        return new Word("Caballo", makeCaballoContents(), R.drawable.caballo);
    }

    public static List<Content> makeCaballoContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.caballo;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word makeCerdoWord() {
        return new Word("Cerdo", makeCerdoContents(), R.drawable.cerdo);
    }

    public static List<Content> makeCerdoContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.cerdo;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word makeChangoWord() {
        return new Word("Chango", makeChangoContents(), R.drawable.chango);
    }

    public static List<Content> makeChangoContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.chango;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word makeConejoWord() {
        return new Word("Conejo", makeConejoContents(), R.drawable.conejo);
    }

    public static List<Content> makeConejoContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.conejo;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word makeGatoWord() {
        return new Word("Gato", makeGatoContents(), R.drawable.gato);
    }

    public static List<Content> makeGatoContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.gato;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word makeGorillaWord() {
        return new Word("Gorila", makeGorillaContents(), R.drawable.gorila);
    }

    public static List<Content> makeGorillaContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.gorila;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word makeGusanoWord() {
        return new Word("Gusano", makeGusanoContents(), R.drawable.gusano);
    }

    public static List<Content> makeGusanoContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.gusano;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word makeJirafaWord() {
        return new Word("Jirafa", makeJirafaContents(), R.drawable.jirafa);
    }

    public static List<Content> makeJirafaContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.jirafa;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word makeLeonWord() {
        return new Word("Leon", makeLeonContents(), R.drawable.leon);
    }

    public static List<Content> makeLeonContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.leon;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word makeMariposaWord() {
        return new Word("Mariposa", makeMariposaContents(), R.drawable.mariposa);
    }

    public static List<Content> makeMariposaContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.mariposa;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word makeOsoWord() {
        return new Word("Oso", makeOsoContents(), R.drawable.oso);
    }

    public static List<Content> makeOsoContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.oso;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word makePajaroWord() {
        return new Word("Pájaro", makePajaroContents(), R.drawable.pajaro);
    }

    public static List<Content> makePajaroContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.pajaro;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word makePalomaWord() {
        return new Word("Paloma", makePalomaContents(), R.drawable.paloma);
    }

    public static List<Content> makePalomaContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.paloma;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word makePatoWord() {
        return new Word("Pato", makePatoContents(), R.drawable.pato);
    }

    public static List<Content> makePatoContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.pato;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word makePerroWord() {
        return new Word("Paloma", makePalomaContents(), R.drawable.perro);
    }

    public static List<Content> makePerroContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.perro;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word makePezWord() {
        return new Word("Pez", makePezContents(), R.drawable.pez);
    }

    public static List<Content> makePezContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.pez;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word makeRatonWord() {
        return new Word("Ratón", makeRatonContents(), R.drawable.raton);
    }

    public static List<Content> makeRatonContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.raton;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word makeTigreWord() {
        return new Word("Tigre", makeTigreContents(), R.drawable.tigre);
    }

    public static List<Content> makeTigreContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.tigre;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word makeToroWord() {
        return new Word("Toro", makeToroContents(), R.drawable.toro);
    }

    public static List<Content> makeToroContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.toro;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word makeTortugaWord() {
        return new Word("Tortuga", makeTortugaContents(), R.drawable.tortuga);
    }

    public static List<Content> makeTortugaContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.tortuga;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word makeVacaWord() {
        return new Word("Tortuga", makeVacaContents(), R.drawable.vaca);
    }

    public static List<Content> makeVacaContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.vaca;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word makeVivoraWord() {
        return new Word("Tortuga", makeVivoraContents(), R.drawable.vivora);
    }

    public static List<Content> makeVivoraContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.vibora;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }



    public static Word makeALetterWord() {
        return new Word("A", makeALetterContents(), R.drawable.a);
    }

    public static List<Content> makeALetterContents() {
        Drawable drawable = context.getResources().getDrawable(R.drawable.amin);
        Content video = new Content("", drawable, true);
        return Arrays.asList(video);
    }

    public static Word makeBLetterWord() {
        return new Word("B", makeBLetterContents(), R.drawable.b);
    }

    public static List<Content> makeBLetterContents() {
        Drawable drawable = context.getResources().getDrawable(R.drawable.bmin);
        Content video = new Content("", drawable, true);
        return Arrays.asList(video);
    }

    public static Word makeCLetterWord() {
        return new Word("C", makeCLetterContents(), R.drawable.c);
    }

    public static List<Content> makeCLetterContents() {
        Drawable drawable = context.getResources().getDrawable(R.drawable.cmin);
        Content video = new Content("", drawable, true);
        return Arrays.asList(video);
    }

    public static Word makeDLetterWord() {
        return new Word("D", makeDLetterContents(), R.drawable.d);
    }

    public static List<Content> makeDLetterContents() {
        Drawable drawable = context.getResources().getDrawable(R.drawable.dmin);
        Content video = new Content("", drawable, true);
        return Arrays.asList(video);
    }

    public static Word makeELetterWord() {
        return new Word("E", makeELetterContents(), R.drawable.e);
    }

    public static List<Content> makeELetterContents() {
        Drawable drawable = context.getResources().getDrawable(R.drawable.emin);
        Content video = new Content("", drawable, true);
        return Arrays.asList(video);
    }


    public static Word makeFLetterWord() {
        return new Word("F", makeFLetterContents(), R.drawable.f);
    }

    public static List<Content> makeFLetterContents() {
        Drawable drawable = context.getResources().getDrawable(R.drawable.fmin);
        Content video = new Content("", drawable, true);
        return Arrays.asList(video);
    }

    public static Word makeGLetterWord() {
        return new Word("G", makeGLetterContents(), R.drawable.g);
    }

    public static List<Content> makeGLetterContents() {
        Drawable drawable = context.getResources().getDrawable(R.drawable.gmin);
        Content video = new Content("", drawable, true);
        return Arrays.asList(video);
    }


    public static Word makeHLetterWord() {
        return new Word("H", makeHLetterContents(), R.drawable.h);
    }

    public static List<Content> makeHLetterContents() {
        Drawable drawable = context.getResources().getDrawable(R.drawable.hmin);
        Content video = new Content("", drawable, true);
        return Arrays.asList(video);
    }


    public static Word makeILetterWord() {
        return new Word("I", makeILetterContents(), R.drawable.i);
    }

    public static List<Content> makeILetterContents() {
        Drawable drawable = context.getResources().getDrawable(R.drawable.imin);
        Content video = new Content("", drawable, true);
        return Arrays.asList(video);
    }


    public static Word makeJLetterWord() {
        return new Word("J", makeJLetterContents(), R.drawable.j);
    }

    public static List<Content> makeJLetterContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.j;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }


    public static Word makeKLetterWord() {
        return new Word("K", makeKLetterContents(), R.drawable.k);
    }

    public static List<Content> makeKLetterContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.k;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }


    public static Word makeLLetterWord() {
        return new Word("L", makeLLetterContents(), R.drawable.l);
    }

    public static List<Content> makeLLetterContents() {
        Drawable drawable = context.getResources().getDrawable(R.drawable.lmin);
        Content video = new Content("", drawable, true);
        return Arrays.asList(video);
    }

    public static Word makeLLLetterWord() {
        return new Word("Ll", makeLLLetterContents(), R.drawable.l);
    }

    public static List<Content> makeLLLetterContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.ll;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }



    public static Word makeMLetterWord() {
        return new Word("M", makeMLetterContents(), R.drawable.m);
    }

    public static List<Content> makeMLetterContents() {
        Drawable drawable = context.getResources().getDrawable(R.drawable.mmin);
        Content video = new Content("", drawable, true);
        return Arrays.asList(video);
    }


    public static Word makeNLetterWord() {
        return new Word("N", makeNLetterContents(), R.drawable.n);
    }

    public static List<Content> makeNLetterContents() {
        Drawable drawable = context.getResources().getDrawable(R.drawable.nmin);
        Content video = new Content("", drawable, true);
        return Arrays.asList(video);
    }

    public static Word makeNNLetterWord() {
        return new Word("Ñ", makeNNLetterContents(), R.drawable.nn);
    }

    public static List<Content> makeNNLetterContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.nn;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }


    public static Word makeOLetterWord() {
        return new Word("O", makeOLetterContents(), R.drawable.o);
    }

    public static List<Content> makeOLetterContents() {
        Drawable drawable = context.getResources().getDrawable(R.drawable.omin);
        Content video = new Content("", drawable, true);
        return Arrays.asList(video);
    }


    public static Word makePLetterWord() {
        return new Word("P", makePLetterContents(), R.drawable.p);
    }

    public static List<Content> makePLetterContents() {
        Drawable drawable = context.getResources().getDrawable(R.drawable.pmin);
        Content video = new Content("", drawable, true);
        return Arrays.asList(video);
    }


    public static Word makeQLetterWord() {
        return new Word("Q", makeQLetterContents(), R.drawable.q);
    }

    public static List<Content> makeQLetterContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.q;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }


    public static Word makeRLetterWord() {
        return new Word("R", makeRLetterContents(), R.drawable.r);
    }

    public static List<Content> makeRLetterContents() {
        Drawable drawable = context.getResources().getDrawable(R.drawable.rmin);
        Content video = new Content("", drawable, true);
        return Arrays.asList(video);
    }

    public static Word makeRRLetterWord() {
        return new Word("RR", makeRRLetterContents(), R.drawable.r);
    }

    public static List<Content> makeRRLetterContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.rr;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }



    public static Word makeSLetterWord() {
        return new Word("S", makeSLetterContents(), R.drawable.s);
    }

    public static List<Content> makeSLetterContents() {
        Drawable drawable = context.getResources().getDrawable(R.drawable.smin);
        Content video = new Content("", drawable, true);
        return Arrays.asList(video);
    }


    public static Word makeTLetterWord() {
        return new Word("T", makeTLetterContents(), R.drawable.t);
    }

    public static List<Content> makeTLetterContents() {
        Drawable drawable = context.getResources().getDrawable(R.drawable.tmin);
        Content video = new Content("", drawable, true);
        return Arrays.asList(video);
    }


    public static Word makeULetterWord() {
        return new Word("U", makeULetterContents(), R.drawable.u);
    }

    public static List<Content> makeULetterContents() {
        Drawable drawable = context.getResources().getDrawable(R.drawable.umin);
        Content video = new Content("", drawable, true);
        return Arrays.asList(video);
    }


    public static Word makeVLetterWord() {
        return new Word("V", makeVLetterContents(), R.drawable.v);
    }

    public static List<Content> makeVLetterContents() {
        Drawable drawable = context.getResources().getDrawable(R.drawable.vmin);
        Content video = new Content("", drawable, true);
        return Arrays.asList(video);
    }


    public static Word makeWLetterWord() {
        return new Word("W", makeWLetterContents(), R.drawable.w);
    }

    public static List<Content> makeWLetterContents() {
        Drawable drawable = context.getResources().getDrawable(R.drawable.wmin);
        Content video = new Content("", drawable, true);
        return Arrays.asList(video);
    }



    public static Word makeXLetterWord() {
        return new Word("X", makeXLetterContents(), R.drawable.x);
    }

    public static List<Content> makeXLetterContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.x;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }


    public static Word makeYLetterWord() {
        return new Word("Y", makeYLetterContents(), R.drawable.y);
    }

    public static List<Content> makeYLetterContents() {
        Drawable drawable = context.getResources().getDrawable(R.drawable.ymin);
        Content video = new Content("", drawable, true);
        return Arrays.asList(video);
    }



    public static Word makeZLetterWord() {
        return new Word("Z", makeZLetterContents(), R.drawable.z);
    }

    public static List<Content> makeZLetterContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.z;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }
    public static Word MakeAzulWord() {
        return new Word("Azul", makeAzulContents(), R.drawable.azul);
    }

    public static List<Content> makeAzulContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.azul;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }


    public static Word MakeBlancoWord() {
        return new Word("Blanco", makeBlancoContents(), R.drawable.blanco);
    }

    public static List<Content> makeBlancoContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.blanco;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word MakeCafeWord() {
        return new Word("Cafe", makeCafeContents(), R.drawable.cafe);
    }

    public static List<Content> makeCafeContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.cafe;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word MakeGrisWord() {
        return new Word("Gris", makeGrisContents(), R.drawable.gris);
    }

    public static List<Content> makeGrisContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.gris;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word MakeMoradoWord() {
        return new Word("Morado", makeMoradoContents(), R.drawable.morado);
    }

    public static List<Content> makeMoradoContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.morado;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }


    public static Word MakeNaranjaWord() {
        return new Word("Naranja", makeNaranjaContents(), R.drawable.naranja);
    }

    public static List<Content> makeNaranjaContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.naranja;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }
    public static Word MakeNegroWord() {
        return new Word("Negro", makeNegroContents(), R.drawable.negro);
    }

    public static List<Content> makeNegroContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.negro;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }
    public static Word MakeOroWord() {
        return new Word("Oro", makeOroContents(), R.drawable.oro);
    }

    public static List<Content> makeOroContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.oro;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }
    public static Word MakePlataWord() {
        return new Word("Plata", makePlataContents(), R.drawable.plata);
    }

    public static List<Content> makePlataContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.plata;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }
    public static Word MakeRojoWord() {
        return new Word("Rojo", makeRojoContents(), R.drawable.rojo);
    }

    public static List<Content> makeRojoContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.rojo;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }
    public static Word MakeRosaWord() {
        return new Word("Rosa", makeRosaContents(), R.drawable.rosa);
    }

    public static List<Content> makeRosaContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.rosa;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }
    public static Word MakeVerdeWord() {
        return new Word("Verde", makeVerdeContents(), R.drawable.verde);
    }

    public static List<Content> makeVerdeContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.verde;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }
    public static Word MakeAmarilloWord() {
        return new Word("Amarillo", makeAmarilloContents(), R.drawable.amarillo);
    }

    public static List<Content> makeAmarilloContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.amarillo;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    //Dias de la semana
    public static Word MakeLunesWord() {
        return new Word("Lunes", makeLunesContents(), R.drawable.blanco);
    }

    public static List<Content> makeLunesContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.lunes;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word MakeMartesWord() {
        return new Word("Martes", makeMartesContents(), R.drawable.blanco);
    }

    public static List<Content> makeMartesContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.martes;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }


    public static Word MakeMiercolesWord() {
        return new Word("Miercoles", makeMiercolesContents(), R.drawable.blanco);
    }

    public static List<Content> makeMiercolesContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.miercoles;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word MakeJuevesWord() {
        return new Word("Jueves", makeJuevesContents(), R.drawable.blanco);
    }

    public static List<Content> makeJuevesContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.jueves;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word MakeViernesWord() {
        return new Word("Viernes", makeViernesContents(), R.drawable.blanco);
    }

    public static List<Content> makeViernesContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.viernes;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word MakeSabadoWord() {
        return new Word("Sábado", makeSabadoContents(), R.drawable.blanco);
    }

    public static List<Content> makeSabadoContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.sabado;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word MakeDomingoWord() {
        return new Word("Domingo", makeDomingoContents(), R.drawable.blanco);
    }

    public static List<Content> makeDomingoContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.domingo;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word MakeEneroWord() {
        return new Word("Enero", makeEneroContents(), R.drawable.enero);
    }

    public static List<Content> makeEneroContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.enero;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word MakeFebreroWord() {
        return new Word("Febrero", makeFebreroContents(), R.drawable.febrero);
    }

    public static List<Content> makeFebreroContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.febrero;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word MakeMarzoWord() {
        return new Word("Marzo", makeMarzoContents(), R.drawable.marzo);
    }

    public static List<Content> makeMarzoContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.marzo;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word MakeAbrilWord() {
        return new Word("Abril", makeAbrilContents(), R.drawable.abril);
    }

    public static List<Content> makeAbrilContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.abril;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word MakeMayoWord() {
        return new Word("Mayo", makeMayoContents(), R.drawable.mayo);
    }

    public static List<Content> makeMayoContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.mayo;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word MakeJunioWord() {
        return new Word("Junio", makeJunioContents(), R.drawable.junio);
    }

    public static List<Content> makeJunioContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.junio;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word MakeJulioWord() {
        return new Word("Julio", makeJulioContents(), R.drawable.julio);
    }

    public static List<Content> makeJulioContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.julio;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word MakeAgostoWord() {
        return new Word("Agosto", makeAgostoContents(), R.drawable.agosto);
    }

    public static List<Content> makeAgostoContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.agosto;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word MakeSeptiempreWord() {
        return new Word("Septiembre", makeSeptiembreContents(), R.drawable.septiembre);
    }

    public static List<Content> makeSeptiembreContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.septiembre;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word MakeOctubreWord() {
        return new Word("Octubre", makeOctubreContents(), R.drawable.octubre);
    }

    public static List<Content> makeOctubreContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.octubre;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word MakeNoviembreWord() {
        return new Word("Noviembre", makeNoviembreoContents(), R.drawable.noviembre);
    }

    public static List<Content> makeNoviembreoContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.noviembre;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

    public static Word MakeDiciembreWord() {
        return new Word("Diciembre", makeDiciembreContents(), R.drawable.diembre);
    }

    public static List<Content> makeDiciembreContents() {
        String name = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.diciembre;
        Content video = new Content(name, false);
        return Arrays.asList(video);
    }

}

package Skeleton;

import java.util.List;

public class Aszteroida {
    List<Aszteroida> szomszedok;
    int kulsoRetegek;
    Nyersanyag mag;
    List<Hajo> hajok;

    public void Fur() {

    }
    public Nyersanyag Kinyer(){
        return new Nyersanyag();
    }
    public boolean NapkozelbenE(){
        return true;
    }
    public void AddSzomszed(Mezo m){

    }
    public void RemoveSzomszed(Mezo m){

    }
    public void Napvihar(){

    }
    public boolean AddMag(Nyersanyag n){
        return false;
    }


}

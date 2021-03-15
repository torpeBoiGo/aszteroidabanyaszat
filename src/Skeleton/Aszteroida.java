package Skeleton;

import java.util.List;

public class Aszteroida implements Mezo{
    List<Aszteroida> szomszedok;
    int kulsoRetegek;
    Nyersanyag mag;
    List<Hajo> hajok;

    public Aszteroida(){
        SkeletonController.ObjectCreated(this);
    }
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

    @Override
    public void Robban() {

    }

    public void RemoveSzomszed(Mezo m){

    }

    @Override
    public void HajoErkezik(Hajo h) {

    }

    @Override
    public void HajoElhagy(Hajo h) {

    }

    public void Napvihar(){

    }
    public boolean AddMag(Nyersanyag n){
        return false;
    }


}

package Skeleton;


import java.util.ArrayList;

public class Telepes extends Hajo{

	ArrayList<Nyersanyag> Rakter = new ArrayList<Nyersanyag>();

    public Telepes(Aszteroida a) {
        SkeletonController.ObjectCreated(this);
        a.HajoErkezik(this);
        aszteroida = a;
        
    }

	@Override
	void Robbanas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void Lepes() {
		// TODO Auto-generated method stub
	}

	@Override
	boolean NyerEllenoriz(Epitheto e) {
		// TODO Auto-generated method stub
		return false;
	}

	void AnyagVisszatesz(Nyersanyag n){
	    aszteroida.addMag(n);

	}

	void AddRakter(Nyersanyag n){
		Rakter.add(n);
	}

	void Banyasz(){
		Nyersanyag n = aszteroida.Kinyer();
		if(n != null && Rakter.size()< 9){
			//Rakter.AddRakter(n);
		}

	}


}
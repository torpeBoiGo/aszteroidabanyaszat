package Skeleton;


public class Telepes extends Hajo{
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
}
package Skeleton;


public class Telepes extends Hajo{

    private std::ArrayList<Nyesanyag> Rakter;
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
	
	public void setName(String input) {
    	super.name = input;
    }

    public void Banyasz(){
            Nyesanyag ny = aszteroida.Kinyer();
            if(ny!=null && Rakter.size()<9){
                Rakter.add(ny);
            }
    }
}
package Skeleton;

public class Teleportkapu implements Mezo{
	Teleportkapu par;
	Aszteroida sajatAszteroida;
	boolean mukodikE;
	
	public void SetPar(Teleportkapu par) {
		this.par = par;
	}
	public void SetSajatAszteroida(Aszteroida a) {
		this.sajatAszteroida = a;
	}
	public void HajoTeleportErkezik(Hajo h) {
		SkeletonController.FunctionCall("Teleportkapu", "HajoTeleportErkezik");
		if (sajatAszteroida != null) {
			sajatAszteroida.HajoErkezik(h);
			
		}
		
		SkeletonController.FunctionReturn();
	}
	
	public void Elront() {
		
	}
	
	@Override
	public void Robban() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void RemoveSzomszed(Mezo m) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void HajoErkezik(Hajo h) {
		SkeletonController.FunctionCall("Teleportkapu", "HajoErkezik");
		if (par != null) {
			par.HajoTeleportErkezik(h);
		}
		
		SkeletonController.FunctionReturn();
	}
	@Override
	public void HajoElhagy(Hajo h) {
		// TODO Auto-generated method stub
		
	}
	
	
}

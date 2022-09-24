
public class JeuGuerrier {
	
	public static void main(String[] args) {
		EquipeGuerriers equipe = new EquipeGuerriers(3, 10);
		int pointsDeVieDuMal = 30;
		while(equipe.nombreGuerriersEnVie()>=1 && pointsDeVieDuMal>0){
			System.out.println();
			System.out.println("L'equipe compte " + equipe.nombreGuerriersEnVie() + " guerriers en vie");
			int de = lancerDe();
			Guerrier guerrier = equipe.jouer(de);
			System.out.println("Suite au combat entre la creature du mal et le guerrier n°" + guerrier.getNumero() + ":");
			System.out.println("Le guerrier vient de perdre " + de + " points de vie !");
			if(guerrier.getPointsDeVie()<=0){
				System.out.println("Le guerrier est mort");
			}else{
				System.out.println("Il lui reste " + guerrier.getPointsDeVie() + " points de vie");
			}
			de = lancerDe();
			pointsDeVieDuMal-=de;
			System.out.println("La creature du mal vient de perdre " + de + " points de vie");
			if(pointsDeVieDuMal<=0){
				pointsDeVieDuMal=0;
				System.out.println("La creature du mal est morte");
			}else{
				System.out.println("Il reste encore " + pointsDeVieDuMal + " points de vie");
			}
		}
		if(equipe.nombreGuerriersEnVie()==0) System.out.println("Tous les guerriers sont morts");
	}
	
	public static int lancerDe (){
		double nombreReel;
		nombreReel = Math.random();
		return (int) (nombreReel * 6) + 1;
	}
	
}

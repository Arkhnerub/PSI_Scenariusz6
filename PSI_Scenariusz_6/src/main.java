import java.util.Random;

public class main {
	public static void main(String[] args) {
		Random rand = new Random();
		int rozmx = 4;
		int rozmy = 5;
		double[][] all = new double[20][20];
		createWectors(all);
		perc[][] siatka= new perc[rozmx][rozmy];
		int wybrany = rand.nextInt(20);
		double wspolczynnikUczenia = 0.001;
		int obszarUczacy = 1;
		int id=0;
		int[] wyniki = new int[20];
		
		for(int i=0;i<rozmx;i++) {
			for(int j=0;j<rozmy;j++) {
				siatka[i][j] = new perc(all[wybrany]);
				siatka[i][j].setId(id);
				id++;
			}
		}
		///////////////////////////////////////
		//////////Uczenie//////////////////////
		///////////////////////////////////////

		for(int i=0;i<1000;i++) {
			wybrany = rand.nextInt(20);
			double makssum = 0;
			int maksi = 0;
			int maksj = 0;
			for(int j=0;j<rozmx;j++) {
				for(int k=0;k<rozmy;k++) {
					siatka[j][k].setVector(all[wybrany]);
					if(siatka[j][k].sum()>makssum) {
						makssum = siatka[j][k].getSuma();
						maksi = j;
						maksj = k;
					}
				}
			}
			for(int j = -obszarUczacy;j<obszarUczacy;j++) {
				for(int k = -obszarUczacy;k<obszarUczacy;k++) {
					if((maksi+j>=0 && maksi+j<rozmx)&&(maksj+k>=0 && maksj+k<rozmy)) {
						siatka[maksi+j][maksj+k].ucz(wspolczynnikUczenia, all[wybrany]);
					}
				}	
			}
			siatka[maksi][maksj].ucz(wspolczynnikUczenia, all[wybrany]);
		}
		
		
		//////////////////////////////////////
		///////////////Testowanie/////////////
		//////////////////////////////////////
		for(int i=0;i<100;i++) {
			wybrany = rand.nextInt(20);
			double makssum = 0;
			int maksi = 0;
			int maksj = 0;
			for(int j=0;j<rozmx;j++) {
				for(int k=0;k<rozmy;k++) {
					siatka[j][k].setVector(all[wybrany]);
					if(siatka[j][k].sum()>makssum) {
						makssum = siatka[j][k].getSuma();
						maksi = j;
						maksj = k;
					}
				}
			}
			wyniki[siatka[maksi][maksj].getId()]+=1;
			System.out.println("Na wzor nr "+wybrany+" zareagowal perceptron o id "+siatka[maksi][maksj].getId());	
		}

		
	}
	
	public static void createWectors(double[][] all) {
		double[] A={0,1,1,0,1,0,0,1,1,1,1,1,1,0,0,1,1,0,0,1};
		double[] B={1,1,1,0,1,0,0,1,1,1,1,0,1,0,0,1,1,1,1,0};
		double[] C={0,1,1,0,1,0,0,1,1,0,0,0,1,0,0,1,0,1,1,0};
		double[] D={1,1,1,0,1,0,0,1,1,0,0,1,1,0,0,1,1,1,1,0};
		double[] E={1,1,1,1,1,0,0,0,1,1,1,1,1,0,0,0,1,1,1,1};
		double[] F={1,1,1,1,1,0,0,0,1,1,1,0,1,0,0,0,1,0,0,0};
		double[] G={0,1,1,0,1,0,0,0,1,0,1,0,1,0,0,1,0,1,1,0};
		double[] H={1,0,0,1,1,0,0,1,1,1,1,1,1,0,0,1,1,0,0,1};
		double[] I={0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0};
		double[] J={0,1,1,1,0,0,0,1,0,0,0,1,0,0,0,1,1,1,1,0};
		double[] K={1,0,0,1,1,0,1,0,1,1,0,0,1,0,1,0,1,0,0,1};			
		double[] L={1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,1,1,0};
		double[] N={1,0,0,1,1,1,0,1,1,0,1,1,1,0,0,1,1,0,0,1};
		double[] O={0,1,1,0,1,0,0,1,1,0,0,1,1,0,0,1,0,1,1,0};
		double[] P={1,1,1,0,1,0,0,1,1,1,1,0,1,0,0,0,1,0,0,0};
		double[] R={1,1,1,0,1,0,0,1,1,1,1,0,1,0,1,0,1,0,0,1};
		double[] S={0,1,1,1,1,0,0,0,0,1,1,0,0,0,0,1,1,1,1,0};
		double[] T={1,1,1,1,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0};
		double[] U={1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,0,1,1,0};
		double[] Z={1,1,1,1,0,0,1,0,0,1,0,0,1,0,0,0,1,1,1,1};
		all[0]=A;
		all[1]=B;
		all[2]=C;
		all[3]=D;
		all[4]=E;
		all[5]=F;
		all[6]=G;
		all[7]=H;
		all[8]=I;
		all[9]=J;
		all[10]=K;
		all[11]=L;
		all[12]=N;
		all[13]=O;
		all[14]=P;
		all[15]=R;
		all[16]=S;
		all[17]=T;
		all[18]=U;
		all[19]=Z;
	}
}

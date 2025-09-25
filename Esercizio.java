import java.util.Scanner;

class Main {

  private static Scanner in = new Scanner(System.in);

  private static void azzeraVettore(int[] V, int N){
      int i = 0;
      while(i < N){
          V[i] = 0;
          ++i;
      }
  }

  private static int Menu(){
      int x;

	do{
          System.out.print("1: inserisci elemento, 2: elimina elemento, 3: ricerca elemento, 4 Elimina duplicati, 5 Visualizza vettore, 6: exit");
          x = Integer.parseInt(in.nextLine());
          if(x < 1 || x > 6){
              System.out.println("Inserire un operazione valida!");
          }
      }while(x < 1 || x > 6);

      System.out.println();
      
      return x;
  }

  private static int inserireElemento(int[] V, int N, int e, int ie){

      int i = 0;

      int[] W = new int[N+1];

      while(i < ie){
          W[i] = V[i];
          ++i;
      }

      W[ie] = e;

      while(i < N){
          W[i+1] = V[i];
          ++i;
      }

      i = 0;
      while(i < N+1){
          V[i] = W[i];
          ++i;
      }

      return N+1;
  }


  private static int eliminaElemento(int[] V, int N){
      return N;
  }

  private static int ricercaElemento(int[] V, int N, int e){
      int i = 0;
      boolean trovato = false;
      while(i < N && trovato == false){
          if(e == V[i]){
              trovato = true;
          }else{
              ++i;
          }
      }
      return i;
  }

  private static int eliminaDuplicati(int[] V, int N){
      return N;
  }

  private static void visualizzaVettore(int[] V, int N){
      int i = 0;
      while(i < N){
          System.out.println("Cella N." + i + " - Valore: " + V[i]);
          ++i;
      }
  }
  public static void main(String args[]){
    
      System.out.print("Inserire grandezza vettore: ");
      int N = Integer.parseInt(in.nextLine());
      int[] V = new int[N];
      azzeraVettore(V, N);

      int scelta;
      int valore;
      int posizione;


      do{

         scelta = Menu();
          if(scelta == 1){
              System.out.print("Inserire valore da inserire nel vettore: ");
              valore = Integer.parseInt(in.nextLine());
              do{
                  System.out.print("Inserire la posizione in cui inserire il valore: ");
                  posizione = Integer.parseInt(in.nextLine());
                  if(posizione < 0 || posizione >= N){
                      System.out.println("Inserire una posizione valida!");
                  }
              }while(posizione < 0 || posizione >= N);

              N = inserireElemento(V,N,valore,posizione);
          }
          if(scelta == 2){
            
          }
          if(scelta == 3){

              posizione = -1;

              System.out.print("Inserire valore da ricercare nel vettore: ");
              valore = Integer.parseInt(in.nextLine());

              posizione = ricercaElemento(V,N,valore);
              if(posizione != -1){
                  System.out.println("Elemento trovato nella posizione: " + posizione);
              }else{
                  System.out.println("Elemento non trovato");
              }
          }
          if(scelta == 4){

          }
          if(scelta == 5){
              visualizzaVettore(V,N);
          }
      }while(scelta != 6);
  }
}


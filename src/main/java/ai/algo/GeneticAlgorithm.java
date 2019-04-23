package ai.algo;

public class GeneticAlgorithm {

    public static int [] solvbyGenetic(int numofgene, int populationsize){

        if (populationsize%2!=0)
            populationsize-=1;

        System.out.println(1);
//        int maxvalue=maxfitness(numofgene);
        int [][]population=new int [populationsize][numofgene];

        for (int i=0;i<populationsize;i++){
            population[i]=randomstate(numofgene);
        }
        System.out.println("=====================");
        System.out.println(2);

        while (true){
            int count=0;
            crossover(population);
            for (int[] ints : population) {  //foreach in java5
                if (getfitness(ints) == maxfitness(ints.length))
                    return ints;
                meutation(ints);
                if (getfitness(ints) == maxfitness(ints.length))
                    return ints;
            }
        }
    }


    private static void meutation(int[] chro){
        chro[(int)(Math.random()*chro.length)]=(int)(Math.random()*chro.length);
    }


    private static int [] randomstate(int n){
        int []arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=((int) (Math.random() * n));
        }
        return arr;
    }

    private static int heurastic(int[] chromosome){  //goal minimize heuristic
        int heu=0;
        for (int i=0;i<chromosome.length;i++){
            for (int j=i+1;j<chromosome.length;j++){
                if(chromosome[i]==chromosome[j]||chromosome[i]==chromosome[j]-(j-i)||chromosome[i]==chromosome[j]+(j-i))
                    heu++;
            }
        }
        return heu;
    }

    private static int maxfitness(int n){
        return (n*(n-1))/2;
    }

    private static int getfitness(int[] chro){
        return (maxfitness(chro.length)-heurastic(chro));
    }

    private static void crossover(int[][] population){
        for (int i=0;i<population.length;i+=2){
            int singlepoint=(int)(Math.random()*population[0].length);
            for (int x=0;x<=singlepoint;x++){
                int temp=population[i][x];
                population[i][x]=population[i+1][x];
                population[i+1][x]=temp;
            }
        }
    }
}

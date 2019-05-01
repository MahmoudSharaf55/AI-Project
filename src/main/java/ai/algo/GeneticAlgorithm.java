package ai.algo;

public class GeneticAlgorithm {

    public static int [] solvbyGenetic(int numofgene, int populationsize){

        if (populationsize%2!=0)
            populationsize-=1;

        System.out.println(1);
//        int maxvalue=maxFitness(numofgene);
        int [][]population=new int [populationsize][numofgene];

        for (int i=0;i<populationsize;i++){
            population[i]= randomState(numofgene);
        }
        System.out.println("=====================");
        System.out.println(2);

        while (true){
            crossover(population);
            for (int[] ints : population) {
                if (getFitness(ints) == maxFitness(ints.length))
                    return ints;
                mutation(ints);
                if (getFitness(ints) == maxFitness(ints.length))
                    return ints;
            }
        }
    }


    private static void mutation(int[] chro){
        chro[(int)(Math.random()*chro.length)]=(int)(Math.random()*chro.length);
    }


    private static int [] randomState(int n){
        int []arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=((int) (Math.random() * n));
        }
        return arr;
    }

    private static int heuristic(int[] chromosome){  //goal minimize heuristic
        int heu=0;
        for (int i=0;i<chromosome.length;i++){
            for (int j=i+1;j<chromosome.length;j++){
                if(chromosome[i]==chromosome[j]||chromosome[i]==chromosome[j]-(j-i)||chromosome[i]==chromosome[j]+(j-i))
                    heu++;
            }
        }
        return heu;
    }

    private static int maxFitness(int n){
        return (n*(n-1))/2;
    }

    private static int getFitness(int[] chro){
        return (maxFitness(chro.length)- heuristic(chro));
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

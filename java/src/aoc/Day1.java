package aoc;

public class Day1 {
    private static int[] top = {0,0,0};

    // PART 2
    //-------------
    private static void checkTop(int calories){
        if(top[0] < calories){
            top[2] = top[1];
            top[1] = top[0];
            top[0] = calories;
        }else if(top[1] < calories){
            top[2] = top[1];
            top[1] = calories;
        }else if(top[2] < calories){
            top[2] = calories;
        }
    }
    // ---------------

    public static void main(String[] args) {
        //FileHandle file = new FileHandle("inputs/prueba.txt");
        FileHandle file = new FileHandle("inputs/Day1.txt");


        // PART 1
        // -------
        int maxCalories = 0;
        int contCalories = 0;
        for(int i = 0; i < file.getLines().size(); i++){
            if(file.getLine(i).equals("")){
                checkTop(contCalories);
                maxCalories = Math.max(maxCalories, contCalories);
                contCalories = 0;
            }else{
                contCalories += file.getIntLine(i);
            }
        }
        // ----------
        System.out.println("MAX CALORIES: " + maxCalories);
        System.out.println("TOP in total: " + (top[0] + top[1] + top[2]));
    }
}
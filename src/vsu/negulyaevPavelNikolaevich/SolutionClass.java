package vsu.negulyaevPavelNikolaevich;

import ru.vsu.cs.util.ArrayUtils;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import static ru.vsu.cs.util.ArrayUtils.toIntArray2;

public class SolutionClass {

    public static int[][] readIntArrayFromConsole(){ // debugged
        return ArrayUtils.readIntArray2FromConsole();
    }

    public static void writeIntArrayToConsole(int[][] IntArray){ // debugged
        for(int rows = 0; rows < IntArray.length; rows++){
            for(int cols = 0; cols < IntArray[0].length; cols++){
                System.out.print(IntArray[rows][cols] + " ");
                if(cols == IntArray[0].length-1){
                    System.out.println();
                }
            }
        }
    }

    public static void SumAndSquare(Storage storage, int[][] mainIntArray){
        int squareSide = 2;
        double tempSum = 0;
        double sum = 0;
        ArrayList<ArrayList<Integer>> square = new ArrayList<ArrayList<Integer>>(); // двумерный список для сохранения квадрата
        for(int rows = 0; rows < mainIntArray .length; rows++){
            for(int cols = 0; cols < mainIntArray[0].length; cols++){
                tempSum = 0;
                if(rows == mainIntArray.length-squareSide-1 && cols == mainIntArray[0].length-squareSide-1){
                    squareSide++;
                    rows = 0;
                    cols = 0;
                }
                for(int i = 0; i < squareSide; i++){
                    if(rows + squareSide > mainIntArray.length || cols + squareSide > mainIntArray[0].length){
                        break;
                    }
                    for(int j = 0; j < squareSide; j++){
                        if(rows + squareSide > mainIntArray.length || cols + squareSide > mainIntArray[0].length){
                            break;
                        }
                        tempSum += mainIntArray[rows+i][cols+j];
                        if(j == squareSide-1 && i == squareSide-1){
                            if(tempSum>sum){
                                sum=tempSum;
                                for(int m = 0; m < squareSide; m++){
                                    square.add(m, new ArrayList<Integer>());
                                    for(int k = 0; k < squareSide; k++){
                                        square.get(m).add(k,(int)mainIntArray[rows+m][cols+k]);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        int[][] IntArray = new int[squareSide][squareSide]; // копируем данные списка в массив
        Integer temp = 0;
        for(int i = 0; i < squareSide; i++){
            for(int j = 0; j < squareSide; j++) {
                temp = square.get(i).get(j);
                IntArray[i][j] = temp.intValue();
            }
        }
        storage.squareSide = squareSide;
        storage.square = IntArray;
        storage.sum = sum;
    }

    public static int[][] SumAndSquareForGUI(int[][] mainIntArray){
        int squareSide = 2;
        double tempSum = 0;
        double sum = 0;
        ArrayList<ArrayList<Integer>> square = new ArrayList<ArrayList<Integer>>(); // двумерный список для сохранения квадрата
        for(int rows = 0; rows < mainIntArray .length; rows++){
            for(int cols = 0; cols < mainIntArray[0].length; cols++){
                tempSum = 0;
                if(rows == mainIntArray.length-squareSide-1 && cols == mainIntArray[0].length-squareSide-1){
                    squareSide++;
                    rows = 0;
                    cols = 0;
                }
                for(int i = 0; i < squareSide; i++){
                    if(rows + squareSide > mainIntArray.length || cols + squareSide > mainIntArray[0].length){
                        break;
                    }
                    for(int j = 0; j < squareSide; j++){
                        if(rows + squareSide > mainIntArray.length || cols + squareSide > mainIntArray[0].length){
                            break;
                        }
                        tempSum += mainIntArray[rows+i][cols+j];
                        if(j == squareSide-1 && i == squareSide-1){
                            if(tempSum>sum){
                                sum=tempSum;
                                for(int m = 0; m < squareSide; m++){
                                    square.add(m, new ArrayList<Integer>());
                                    for(int k = 0; k < squareSide; k++){
                                        square.get(m).add(k,(int)mainIntArray[rows+m][cols+k]);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        int[][] IntArray = new int[squareSide][squareSide]; // копируем данные списка в массив
        Integer temp = 0;
        for(int i = 0; i < squareSide; i++){
            for(int j = 0; j < squareSide; j++) {
                temp = square.get(i).get(j);
                IntArray[i][j] = temp.intValue();
            }
        }
        return IntArray;
    }

    public static int[][] readIntArray2FromFile(String fileName) {
        try {
            return toIntArray2(ArrayUtils.readLinesFromFile(fileName));
        }
        catch(FileNotFoundException e) {
            return null;
        }
    }


}

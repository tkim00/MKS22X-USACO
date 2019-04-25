import java.util.*;
import java.io.*;

public class USACO {
  private static int[][] pasture;
  private static String[] input;

  public static void main(String[] args) {
    try {
      System.out.println(bronze("makelake.2.in"));
    } catch(FileNotFoundException e) {
      System.out.println("the file is not found");
    }
  }

  public static int bronze(String filename) throws FileNotFoundException{
    File problem = new File(filename);
    Scanner inf = new Scanner(problem);
    String line = inf.nextLine();
    String[] inputs = line.split(" ");
    int row = Integer.parseInt(inputs[0]);
    int col = Integer.parseInt(inputs[1]);
    int elevation = Integer.parseInt(inputs[2]);
    int instructions = Integer.parseInt(inputs[3]);
    int[][] pasture = new int[row][col];
    for (int r = 0; r < row; r++) {
      line = inf.nextLine();
      String[] nums = line.split(" ");
      for (int c = 0; c < col; c++) {
        pasture[r][c] = Integer.parseInt(nums[c]);
      }
    }

    while (inf.hasNextLine()) {
      line = inf.nextLine();
      String[] nums = line.split(" ");
      int r_s = Integer.parseInt(nums[0])-1;
      int c_s = Integer.parseInt(nums[1])-1;
      int d_s = Integer.parseInt(nums[2]);
      int largest = pasture[r_s][c_s];
      for (int r = r_s; r < r_s+3; r++) {
        for (int c = c_s; c < c_s+3; c++) {
          if (pasture[r][c] > largest) largest = pasture[r][c];
        }
      }
      largest -= d_s;
      for (int r = r_s; r < r_s+3; r++) {
        for (int c = c_s; c < c_s+3; c++) {
          if (pasture[r][c] > largest) pasture[r][c] = largest;
        }
      }
    }
    int totalDepth = 0;
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {
        if (elevation > pasture[r][c]) {
          totalDepth += elevation - pasture[r][c];
        }
      }
    }
    return totalDepth*72*72;
  }

  // public static int silver(String filename) {
  //
  // }
}

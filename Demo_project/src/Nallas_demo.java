import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import io.netty.util.internal.ThreadLocalRandom;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Nallas_demo {

	public static String Set1 = "Yet to start";
	public static String Set2 = "Yet to start";
	public static JLabel Set_list1;
	public static JLabel Set_list2;
	public static JLabel Status;
	public static String user_status ="Yet to start";
	public static  String  Verification="";
	public static  int Guess_count=0;
	public static JTextField userEnt;
	public static JTextField userEnt1;
	public static  String  finalstring="";
	public static  String  finalstring1="";
	public static int length;
	 
	public static Integer [] int_array;
	public static JButton number = new JButton();
	public static JButton reset;
	public static String finalvalue="";
	public static JPanel mainPanel, subPanel1, subPanel2;
	public static ArrayList<Integer> value = new ArrayList<Integer>();
	public static JLabel textfield = new JLabel();
	public static Random random = new Random();
	public static int a[][];
	
	public static int N ;
	public static int ind_len ;
	public static int count = 0;
	
	
	 static Random rnd;
	    //True - if not wall. False - if wall.
	    static boolean[] directions = {false,false,false,false};
	    static String line;
	    static Scanner s = new Scanner(System.in);
	    static int currentDirectionn = 0;

	    public static void main(String[] args) throws IOException 
	    {

	   int maze[][]= {{ 0, 1, 1, 1 , 1, 0, 0},
                     { 0, 0, 0, 0, 1, 0, 0 },
                     { 1, 1, 1, 0, 0, 0, 0 },
                     { 1, 0, 0, 0, 1, 1, 0 },
                     {1, 1, 1, 1, 1, 1, 1}};

             N = maze.length;
              ind_len = maze[0].length;
             System.out.println("len"+N);
             System.out.println("index leng"+ind_len);
            solveMaze(maze);
            JOptionPane.showMessageDialog(null, finalvalue, "Welcome to Nallas", JOptionPane.PLAIN_MESSAGE);

	    }

	    
	    static void printSolution(int sol[][])
	    {
	    	 finalvalue = "Result: True";
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < ind_len; j++)
	                System.out.print(
	                    " " + sol[i][j] + " ");
	            System.out.println();
	        }
	    }
	  
	    /* A utility function to check 
	        if x, y is valid index for N*N maze */
	    static boolean isSafe(
	        int maze[][], int x, int y)
	    {
	        // if (x, y outside maze) return false
	        return (x >= 0 && x < N && y >= 0
	                && y < ind_len && maze[x][y] == 0);
	    }
	    
	    
	    static boolean solveMaze(int maze[][])
	    {
	        int sol[][] = new int[N][ind_len];
	  
	        if (solveMazeUtil(maze, 0, 0, sol) == false) 
	        {
	            System.out.print("Solution doesn't exist");
	            finalvalue = "Result: False";
	            return false;
	        }
	  
	        printSolution(sol);
	        return true;
	    }
	  
	    /* A recursive utility function to solve Maze 
	    problem */
	    static boolean solveMazeUtil(int maze[][], int x, int y,
	                          int sol[][])
	    {
	        // if (x, y is goal) return true
	        if (x == N - 1 && y == ind_len - 1
	            && maze[x][y] == 0) 
	        {
	            sol[x][y] = 0;
	            return true;
	        }
	  
	        // Check if maze[x][y] is valid
	        if (isSafe(maze, x, y) == true) {
	              // Check if the current block is already part of solution path.    
	              if (sol[x][y] == 1)
	                  return false;
	            
	            // mark x, y as part of solution path
	            sol[x][y] = 1;
	  
	            /* Move forward in x direction */
	            if (solveMazeUtil(maze, x + 1, y, sol))
	                return true;
	  
	            /* If moving in x direction doesn't give 
	            solution then Move down in y direction */
	            if (solveMazeUtil(maze, x, y + 1, sol))
	                return true;
	  
	            /* If none of the above movements works then 
	            BACKTRACK: unmark x, y as part of solution 
	            path */
	            sol[x][y] = 0;
	            return false;
	        }
	  
	        return false;
	    }
	    
	    
public static int[] system_resolution()
{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		
		int height = (int)screenSize.getHeight();
		int[] val = {width,height};
		return val;
		
}



}	
	











package Recursion.Backtracking;
public class Maze
{
    public static void main(String[] args)
    {
        //System.out.println(count(3,3));

       // printPath_Diagonal("",3,3);

       boolean[][] board={
        {true, true, true},
        {true, true, true},
        {true, true, true}
       };
    
       all_Paths2("", board, 0, 0);
    }

    static int count(int r, int c)
    {
        //Count the total no. of pathe to reach the end cell in a 
        // maze of nxn starting from n,n
        //You can only move R or D

        if(r==1 || c==1)
        {
            return 1;
        }

        int left=count(r-1, c);
        int right=count(r, c-1);

        return left+right;
    }
                            
    static void printPath(String p, int r, int c)
    {
        if(r==1 && c==1)
        {
            System.out.println(p);
            return;
        }

        
        if(r>1)
        {
            printPath(p+'D', r-1, c);
        }
        if(c>1) 
        {
            printPath(p+'R', r, c-1);
        }
    }

    static void printPath_Diagonal(String p, int r,int c)
    {
        
        if(r==1 && c==1)
        {
            System.out.println(p);
            return;
        }

        if(r>1 && c>1)
        {
            printPath_Diagonal(p+'D', r-1, c-1);
        }
        
        if(r>1)
        {
            printPath_Diagonal(p+'V', r-1, c);
        }
        if(c>1) 
        {
            printPath_Diagonal(p+'H', r, c-1);
        }
    }

    static void maze_with_obstacle(String p, boolean[][] maze, int r, int c)
    {
         //Maze starting from (0,0) to (n-1,n-1)
        if(r==maze.length-1 && c==maze[0].length-1)
        {
            System.out.println(p);
            return;
        }

        if(maze[r][c]==false) return;//If that position contains obstacle

        if(r<maze.length-1)maze_with_obstacle(p+'D', maze, r+1, c);

        if(c<maze[0].length-1)maze_with_obstacle(p+'R', maze, r, c+1);



    }

    //This gives stack Overflow
    static void all_Paths1(String p,  boolean[][] maze, int r, int c)//Can go in all directions L-R-U-D
    {
          if(r==maze.length-1 && c==maze[0].length-1)
        {
            System.out.println(p);
            return;
        }

        if(maze[r][c]==false) return;//If that position contains obstacle

        if(r<maze.length-1)all_Paths1(p+'D', maze, r+1, c);

        if(c<maze[0].length-1)all_Paths1(p+'R', maze, r, c+1);

        if(r>0)all_Paths1(p+'U', maze, r-1, c);

        if(c>0)all_Paths1(p+'L', maze, r, c-1);


    }

    //To remove the stack overflow and solve this by backtracking
     static void all_Paths2(String p,  boolean[][] maze, int r, int c)//Can go in all directions L-R-U-D
    {
          if(r==maze.length-1 && c==maze[0].length-1)
        {
            System.out.println(p);
            return;
        }

        if(maze[r][c]==false) return;//If that position contains obstacle

        //if maze[r][c]==true
        //This means I'm concidiring this cell in my path
        maze[r][c]=false;//Mark it as visited
        if(r<maze.length-1)all_Paths2(p+'D', maze, r+1, c);

        if(c<maze[0].length-1)all_Paths2(p+'R', maze, r, c+1);

        if(r>0)all_Paths2(p+'U', maze, r-1, c);

        if(c>0)all_Paths2(p+'L', maze, r, c-1);

        //This is the line where the function willbe over 
        //So before the functions gets removed also remove the changes that were made by that function
        maze[r][c]=true;

    }
}
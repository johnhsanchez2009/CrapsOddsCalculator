public class Craps
{
   public static void main (String[] args)
   {
      MultiDie die1 = new MultiDie(6);
      MultiDie die2 = new MultiDie(6);
      
      int n = 0;
      final int TRIALS = 1000000;
      
      int roll = 0;
      int point = 0;
      boolean sameGame = false;
      int wins = 0;
      int losses = 0;
      
      do
      {
         die1.roll();
         die2.roll();
      
         roll = die1.getFaceValue() + die2.getFaceValue();
         //System.out.println(roll);
         
         if (sameGame == true)
         {
            if (roll == point)
            {
               wins++;
               //System.out.println("win");
               n++;
               sameGame = false;
            }
            else if (roll == 7)
            {
               losses++;
               //System.out.println("loss");
               n++;
               sameGame = false;
            }
            
         }
            
         else
         {
            switch (roll)
            {
               case 2: case 3: case 12:
                  losses++;
                  //System.out.println("loss");
                  n++;
                  break;
               case 7: case 11:
                  wins++;
                  //System.out.println("win");
                  n++;
                  break;
               case 4: case 5: case 6: case 8: case 9: case 10:
                  point = roll;
                  sameGame = true;
                  break;
            }
         }
         
      } while (n < TRIALS);
      
      System.out.println("Number of Trials: " + TRIALS);
      System.out.println("Wins: " + wins);
      System.out.println("Losses: " + losses);
      System.out.println("Chance of Winning: " + ((double)wins/TRIALS * 100) + "%");
   }
}
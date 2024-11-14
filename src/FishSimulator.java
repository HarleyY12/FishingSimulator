

import java.util.List;
public class FishSimulator {
   private List<Fish> fishList;
   private int numfishCaught;
   private int score;
   private boolean isCaught;
   private long timeInMilliseconds;
   private long startTime;
   
   public FishSimulator( List<Fish>fishList,long timeInMilliseconds){
      this.fishList = fishList;
      this.numFishCaught = 0;
      this.score = 0;
      this.isCaught = false;
      this.timeInMilliseconds = timeInMilliseconds;
   }
   public String fishingTime(){
      return "You have " + (timeInMilliseconds/1000) + " seconds to fish !";
   }
   public int castLine(){
      if (System.currentTimeMillis() > timeInMilliseconds){
         return "Time's up!"
      }
      


   }

}




}

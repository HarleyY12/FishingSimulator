
import java.util.ArrayList;
import java.util.List;
public class FishGenerator {
   int numFishCaught = 0;
   int points = 0;
   boolean isCaught = false;
   long timeInMilliseconds;


   public FishGenerator( List<String>fishList,long timeInMilliseconds){



      this.timeInMilliseconds = timeInMilliseconds;


   }
   public int castLine(){
      while (numFishCaught <= 10 || points < 0);
      {
         if (Math.random() > 0.75) {
            if (timeInMilliseconds > 1) {

            }

         }


      }
      return 1;
   }




}

public class wrapped {
    public class ChunkInfo {
        private double latitude;
        private double longtitude;
        private double length;
        private int placeId;
        private String streetName;
        
        private class Quality {
            int qualityIndex;
            int deviationCount; //monthly average
            int castedBalance; //average upvote - downvote i.e. upvCount + dwnCount / Count
            
            public double getIndex() {

                return 0.0;
            }

        } 

        //how to get this shit?
    }

    /*
     * 
     */

    public static void main(String[] args) {
        System.out.println("Goodbye world!");
    }
}

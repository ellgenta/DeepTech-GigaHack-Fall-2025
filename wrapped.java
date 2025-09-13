//import wrapped.ChunkInfo.ChunkProperties;

public class wrapped {
    public class ChunkInfo {
        double latitude; //нам это не нужнл
        double longtitude;
        double length;
        int placeId;
        int balance; //баланс оценок на фото
        String congestionLevel; //трафик (пробки: medium, low, high) 
        String streetName;

        ChunkProperties properties = new ChunkProperties();
        
        public class ChunkProperties {
            double deviation = 0.0; //среднее отклонение для участка дороги [0, 3]
            double rating = 0.0; //"средняя звезда" из приложение [0, 1.2]
            double photo = 0.0; //текущее количество фото [0.8]

            public double getCongestionCoef() {
                if("low".equals(congestionLevel))
                    return 0.25;
                if("medium".equals(congestionLevel))
                    return 0.7;
                return 1.0;
            }

            public double getPhotoMark() {
                if(photo > 10)
                    return 0.8;
                if(photo > 5)
                    return 0.4;
                return 0.0;
            }
        }

        public double getIndex() {
            double index = 0.0; //5 - хуево, 0 - отлично
            
            double actualDeviation = properties.deviation >= 3 ? 3 : properties.deviation;
            double actualRating = properties.rating / 1.2;
            double actualPhoto = properties.getPhotoMark();
            double congCoef = properties.getCongestionCoef();

            index = congCoef * actualDeviation + actualRating + actualPhoto;

            return index;
        }
}
}

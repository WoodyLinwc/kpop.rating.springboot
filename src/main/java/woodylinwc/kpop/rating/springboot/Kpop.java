package woodylinwc.kpop.rating.springboot;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "kpop")
public class Kpop {

    private ObjectId id;
    private String imdbID;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    
}

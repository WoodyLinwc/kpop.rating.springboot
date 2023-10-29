package woodylinwc.kpop.rating.springboot;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KpopRepository extends MongoRepository<Kpop, ObjectId> {
    Optional<Kpop> findKpopByImdbId(String imdbId);
}

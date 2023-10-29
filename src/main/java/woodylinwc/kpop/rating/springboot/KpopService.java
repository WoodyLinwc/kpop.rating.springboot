package woodylinwc.kpop.rating.springboot;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KpopService {

    @Autowired
    private KpopRepository kpopRepository;

    public List<Kpop> allKpop(){
        return kpopRepository.findAll();

    }

    // may return null
    public Optional<Kpop> singleKpop(String imdbId) {
        return kpopRepository.findKpopByImdbId(imdbId);
    }
}

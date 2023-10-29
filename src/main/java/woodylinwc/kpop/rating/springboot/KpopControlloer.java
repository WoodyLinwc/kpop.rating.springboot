package woodylinwc.kpop.rating.springboot;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kpop")
public class KpopControlloer {
    
    @Autowired
    private KpopService kpopService;

    @GetMapping
    public ResponseEntity<List<Kpop>> getAllKpop() {
        // return new ResponseEntity<String>("All Kpop!", HttpStatus.OK);
        return new ResponseEntity<List<Kpop>>(kpopService.allKpop(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Kpop>> getSingleKpop(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Kpop>>(kpopService.singleKpop(imdbId), HttpStatus.OK);
    
}

}

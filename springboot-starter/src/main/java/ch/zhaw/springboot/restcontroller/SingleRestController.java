package ch.zhaw.springboot.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import ch.zhaw.springboot.entities.Single;
import ch.zhaw.springboot.repositories.SingleRepository;

@RestController
@CrossOrigin
public class SingleRestController {

	@Autowired
	private SingleRepository repository;

	@RequestMapping(value = "court/crimes/singles", method = RequestMethod.GET)
	public ResponseEntity<List<Single>> getCrime() {
		List<Single> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Single>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Single>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "court/crimes/singles/{id}", method = RequestMethod.GET)
    public ResponseEntity<Single> getCrimeById(@PathVariable("id") long id) {
        Optional<Single> result = this.repository.findById(id);
        if (result.isPresent()) {
            return new ResponseEntity<Single>(result.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<Single>(HttpStatus.NOT_FOUND);
        }
    }
}

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
import ch.zhaw.springboot.entities.Multiple;
import ch.zhaw.springboot.repositories.MultipleRepository;


@RestController
@CrossOrigin
public class MultipleRestController {

	@Autowired
	private MultipleRepository repository;

	@RequestMapping(value = "court/crimes/multiples", method = RequestMethod.GET)
	public ResponseEntity<List<Multiple>> getCrime() {
		List<Multiple> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Multiple>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Multiple>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "court/crimes/multiples/{id}", method = RequestMethod.GET)
    public ResponseEntity<Multiple> getCrimeById(@PathVariable("id") long id) {
        Optional<Multiple> result = this.repository.findById(id);
        if (result.isPresent()) {
            return new ResponseEntity<Multiple>(result.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<Multiple>(HttpStatus.NOT_FOUND);
        }
    }
}

package ch.zhaw.springboot.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Crime;
import ch.zhaw.springboot.repositories.CrimeRepository;

@RestController
@CrossOrigin
public class CrimeRestController {
	
	@Autowired
	private CrimeRepository repository;

	@RequestMapping(value = "court/crimes", method = RequestMethod.GET)
	public ResponseEntity<List<Crime>> getCrime() {
		List<Crime> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Crime>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Crime>>(HttpStatus.NOT_FOUND);
		}
	}
	@RequestMapping(value = "court/crimes/{id}", method = RequestMethod.GET)
    public ResponseEntity<Crime> getCrimeById(@PathVariable("id") long id) {
        Optional<Crime> result = this.repository.findById(id);
        if (result.isPresent()) {
            return new ResponseEntity<Crime>(result.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<Crime>(HttpStatus.NOT_FOUND);
        }
    }
	
	@RequestMapping(value = "court/create-crime", method = RequestMethod.POST)
	public ResponseEntity<Crime> createCrime(@RequestBody Crime crime) {
		Crime result = this.repository.save(crime);
		return new ResponseEntity<Crime>(result, HttpStatus.OK);
	}
}
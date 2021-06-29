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

import ch.zhaw.springboot.entities.Defendant;
import ch.zhaw.springboot.repositories.DefendantRepository;

@RestController
@CrossOrigin
public class DefendantRestController {

	@Autowired
	private DefendantRepository repository;

	@RequestMapping(value = "court/defendants", method = RequestMethod.GET)
	public ResponseEntity<List<Defendant>> getDefendant() {
		List<Defendant> result = this.repository.findAll();
		
		if (!result.isEmpty()) {
			return new ResponseEntity<List<Defendant>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Defendant>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "court/defendants/{id}", method = RequestMethod.GET)
    public ResponseEntity<Defendant> getDefendantById(@PathVariable("id") long id) {
        Optional<Defendant> result = this.repository.findById(id);
        if (result.isPresent()) {
            return new ResponseEntity<Defendant>(result.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<Defendant>(HttpStatus.NOT_FOUND);
        }
    }
	
	@RequestMapping(value = "court/create-defendant", method = RequestMethod.POST)
	public ResponseEntity<Defendant> createDefendant(@RequestBody Defendant defendant) {
		Defendant result = this.repository.save(defendant);
		return new ResponseEntity<Defendant>(result, HttpStatus.OK);
	}
}
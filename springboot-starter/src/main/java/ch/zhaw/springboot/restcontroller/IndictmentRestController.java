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

import ch.zhaw.springboot.entities.Defendant;
import ch.zhaw.springboot.entities.Indictment;

import ch.zhaw.springboot.repositories.IndictmentRepository;

@RestController
@CrossOrigin
public class IndictmentRestController {

	@Autowired
	private IndictmentRepository repository;

	@RequestMapping(value = "court/indictments", method = RequestMethod.GET)
	public ResponseEntity<List<Indictment>> getIndictment() {
		List<Indictment> result = this.repository.findAll();
		
		if (!result.isEmpty()) {
			return new ResponseEntity<List<Indictment>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Indictment>>(HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "court/indictments/{id}", method = RequestMethod.GET)
	public ResponseEntity<Indictment> getIndictmentById(@PathVariable("id") long id) {
		Optional<Indictment> result = this.repository.findById(id);
		
		if (result.isPresent()) {
			return new ResponseEntity<Indictment>(result.get(), HttpStatus.OK);

		} else {
			return new ResponseEntity<Indictment>(HttpStatus.NOT_FOUND);
		}
	}

	//Endpoint für Custom Query
	
	@RequestMapping(value = "court/indictments/dateofindictment/{date}", method = RequestMethod.GET)
	public ResponseEntity<List<Defendant>> getDefendantsByDateOfIndictment(@PathVariable("date") String date) {
		List<Defendant> result = this.repository.getDefendantsByDateOfIndictment(date);
		if (!result.isEmpty()) {
			return new ResponseEntity<List<Defendant>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Defendant>>(HttpStatus.NOT_FOUND);
		}

	}
}
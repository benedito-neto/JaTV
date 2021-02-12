package tech.init.jatv.controllers;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import tech.init.jatv.entities.Movie;
import tech.init.jatv.repositories.MovieRepository;

@Controller
public class MovieController {

	private Validator validator;

	private MovieRepository repository;

	private Result result;

	public MovieController() {

	}

	@Inject
	public MovieController(Validator validator, MovieRepository repository, Result result) {
		this.validator = validator;
		this.repository = repository;
		this.result = result;
	}

	// TODO E necessario?
	// @IncludeParameters
	public void add(@Valid Movie movie) {
		this.validator.onErrorRedirectTo(IndexController.class).index();

		this.repository.add(movie);

		this.result.redirectTo(this).list();
	}

	public void list() {
		this.result.include("movies", this.repository.list());
	}

}

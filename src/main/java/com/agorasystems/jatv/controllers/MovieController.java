package com.agorasystems.jatv.controllers;

import javax.inject.Inject;
import javax.validation.Valid;

import com.agorasystems.jatv.entities.Movie;
import com.agorasystems.jatv.repositories.MovieRepository;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

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

package tech.init.jatv.repositories;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import tech.init.jatv.entities.Movie;

@RequestScoped
public class MovieRepository {

	private EntityManager manager;

	public MovieRepository() {

	}

	@Inject
	public MovieRepository(EntityManager manager) {
		this.manager = manager;
	}

	public void add(Movie movie) {
		this.manager.getTransaction().begin();

		this.manager.persist(movie);

		this.manager.getTransaction().commit();
	}

	public List<Movie> list() {
		String jpql = "select m from Movie m";

		TypedQuery<Movie> query = this.manager.createQuery(jpql, Movie.class);

		return query.getResultList();
	}

}

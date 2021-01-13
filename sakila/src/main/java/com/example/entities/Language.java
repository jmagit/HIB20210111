package com.example.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the language database table.
 * 
 */
@Entity
@NamedQuery(name="Language.findAll", query="SELECT l FROM Language l")
//@Immutable
@DynamicUpdate
//@OptimisticLocking(type = OptimisticLockType.ALL)
public class Language implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="language_id")
	private int languageId;

	@Column(name="last_update")
//	@Version
//	@Generated(GenerationTime.ALWAYS)
	private Timestamp lastUpdate;

	@Column(nullable = false)
	private String name;

	//bi-directional many-to-one association to Film
	@OneToMany(mappedBy="language")
	private List<Film> films;

	//bi-directional many-to-one association to Film
	@OneToMany(mappedBy="languageVO")
	private List<Film> filmsVO;

	public Language() {
	}

	public Language(int languageId, String name, Timestamp lastUpdate) {
		this.languageId = languageId;
		this.name = name;
		this.lastUpdate = lastUpdate;
	}

	public int getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Film> getFilms() {
		return this.films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	public Film addFilm(Film film) {
		getFilms().add(film);
		film.setLanguage(this);

		return film;
	}

	public Film removeFilm(Film film) {
		getFilms().remove(film);
		film.setLanguage(null);

		return film;
	}

	public List<Film> getFilmsVO() {
		return this.filmsVO;
	}

	public void setFilmsVO(List<Film> filmsVO) {
		this.filmsVO = filmsVO;
	}

	public Film addFilmsVO(Film filmsVO) {
		getFilmsVO().add(filmsVO);
		filmsVO.setLanguageVO(this);

		return filmsVO;
	}

	public Film removeFilmsVO(Film filmsVO) {
		getFilmsVO().remove(filmsVO);
		filmsVO.setLanguageVO(null);

		return filmsVO;
	}

}
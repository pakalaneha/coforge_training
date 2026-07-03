package com.coforge.day3;

public class Movie {

	private String MovieName;
	private String Director;
	private int Rating;

	public String getMovieName() {
		return MovieName;
	}

	public void setMovieName(String movieName) {
		MovieName = movieName;
	}

	public String getDirector() {
		return Director;
	}

	public void setDirector(String director) {
		Director = director;
	}

	public int getRating() {
		return Rating;
	}

	public void setRating(int rating) {
		Rating = rating;
	}

	@Override
	public String toString() {
		return "Movie [MovieName=" + MovieName + ", Director=" + Director + ", Rating=" + Rating + "]";
	}

}

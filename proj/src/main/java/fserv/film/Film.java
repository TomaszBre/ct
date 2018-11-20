package fserv.film;

public class Film {
	private int id;
	private String title;
	private String director;
	private String actor1;
	private String actor2;
	private String description;
	private int mark;

	public Film() {
	}

	public Film(int id, String title, String director, String actor1, String actor2, String description, int mark) {
		this.id = id;
		this.title = title;
		this.director = director;
		this.actor1 = actor1;
		this.actor2 = actor2;
		this.description = description;
		this.mark = mark;
	}
	

	
	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", director=" + director + ", actor1=" + actor1 + ", actor2="
				+ actor2 + ", description=" + description + ", mark=" + mark + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((director == null) ? 0 : director.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor1() {
		return actor1;
	}
	public void setActor1(String actor1) {
		this.actor1 = actor1;
	}
	public String getActor2() {
		return actor2;
	}
	public void setActor2(String actor2) {
		this.actor2 = actor2;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}

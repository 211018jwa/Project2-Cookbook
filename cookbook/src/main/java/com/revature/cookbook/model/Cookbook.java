package com.revature.cookbook.model;
import java.util.Objects;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cookbook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private User user;
	
	private String name;
	
	private int likes;
	private int followers;
	
	private String recipeIds;
	
	
	public Cookbook() {
		
		recipeIds = ""; //I dont want this to be null. Just easier that way. This way, I can just concatonate things no issue
		
	}
	
	

	public Cookbook(int id, User user, String name, int likes, int followers, String recipeIds) {
		super();
		this.id = id;
		this.user = user;
		this.name = name;
		this.likes = likes;
		this.followers = followers;
		this.recipeIds = recipeIds;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getFollowers() {
		return followers;
	}

	public void setFollowers(int followers) {
		this.followers = followers;
	}

	public String getRecipeIds() {
		return recipeIds;
	}

	public void setRecipeIds(String recipeIds) {
		this.recipeIds = recipeIds;
	}

	@Override
	public int hashCode() {
		return Objects.hash(followers, id, likes, name, recipeIds, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cookbook other = (Cookbook) obj;
		return followers == other.followers && id == other.id && likes == other.likes
				&& Objects.equals(name, other.name) && Objects.equals(recipeIds, other.recipeIds)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Cookbook [id=" + id + ", user=" + user + ", name=" + name + ", likes=" + likes + ", followers="
				+ followers + ", recipeIds=" + recipeIds + "]";
	}
	

	
	
}

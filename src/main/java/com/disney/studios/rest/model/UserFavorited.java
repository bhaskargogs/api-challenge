package com.disney.studios.rest.model;

import java.sql.Timestamp;

public class UserFavorited {
	private String userid;
	private boolean voted;
	private Timestamp doe;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public boolean isVoted() {
		return voted;
	}

	public void setVoted(boolean voted) {
		this.voted = voted;
	}

	public Timestamp getDoe() {
		return doe;
	}

	public void setDoe(Timestamp doe) {
		this.doe = doe;
	}

	@Override
	public String toString() {
		return "UserFavorited [userid=" + userid + ", voted=" + voted + ", doe=" + doe + "]";
	}

}

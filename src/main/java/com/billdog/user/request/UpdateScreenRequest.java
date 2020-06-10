package com.billdog.user.request;

public class UpdateScreenRequest {

	private Long id;

	private boolean readAccess;

	private boolean writeAccess;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isReadAccess() {
		return readAccess;
	}

	public void setReadAccess(boolean readAccess) {
		this.readAccess = readAccess;
	}

	public boolean isWriteAccess() {
		return writeAccess;
	}

	public void setWriteAccess(boolean writeAccess) {
		this.writeAccess = writeAccess;
	}
	
	
	
	

}

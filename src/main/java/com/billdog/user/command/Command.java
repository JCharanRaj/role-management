package com.billdog.user.command;

import java.security.NoSuchAlgorithmException;

public interface Command<E, T> {
	public T excute(E request) throws NoSuchAlgorithmException;
}

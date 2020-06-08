package com.billdog.user.command;

public interface Command<E, T> {

	public T excute(E request);

}
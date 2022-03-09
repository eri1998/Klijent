package com.comtade.proxy;

import java.io.IOException;

import com.danilo.domen.User;

public interface IProxy {
public void login(User user) throws ClassNotFoundException, IOException;
}

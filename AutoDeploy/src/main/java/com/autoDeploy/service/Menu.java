package com.autoDeploy.service;

import com.autoDeploy.entity.MenuItem;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service

public interface Menu {

	 Iterator<MenuItem> createIterator();
}

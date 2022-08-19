package com.sbk.MicroserviceBasedApplication.service;

import java.util.List;

import com.sbk.MicroserviceBasedApplication.model.Link;

public interface LinkService {
	public Link saveLink(Link link);
	public List<Link> getAllLinks();
}

package com.poddubchak.education.docker.repository;

import com.poddubchak.education.docker.model.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact,Long> {
}

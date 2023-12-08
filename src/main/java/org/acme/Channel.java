package org.acme;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter @Getter
public class Channel extends PanacheEntity {

    private String hash;

    @ManyToMany(mappedBy = "channels",  fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<User> users;

    public Channel() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }
}